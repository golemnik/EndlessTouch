package com.lab.nast.webl3module_n.db;

import com.lab.nast.webl3module_n.webapp.PreviousResult;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.LinkedList;
import java.util.Properties;
public class DatabaseHelper {
    private static DatabaseHelper instance;

    private Connection connection;

    private DatabaseHelper() {}

    public boolean connect() {
        Properties properties = new Properties();
        System.out.println(getClass().getClassLoader().getResource("db.properties"));
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("db.properties");
             InputStreamReader ir = new InputStreamReader(is)) {
            properties.load(ir);
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql:postgres", properties);
//            change database scheme jdbc:postgresql:<scheme name> <-- here!
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean createTables() {
        try {
            Statement st = connection.createStatement();
            st.execute(SQLRequests.tablesCreation);
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public boolean addResult(String uuid, PreviousResult result) {
        try {
            PreparedStatement ps = connection.prepareStatement(SQLRequests.insertResult);
            int i = 1;
            ps.setString(i++, uuid);
            ps.setDouble(i++, result.getX());
            ps.setDouble(i++, result.getY());
            ps.setDouble(i++, result.getR());
            ps.setBoolean(i++,false);
            ps.executeUpdate();
            return true;
        } catch (SQLException ignored) {}
        return false;
    }

    public LinkedList<PreviousResult> getAllResults(String uuid) {
        LinkedList<PreviousResult> list = new LinkedList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(SQLRequests.selectAllResults);
            ps.setString(1, uuid);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                PreviousResult result = new PreviousResult();
                result.setX(res.getDouble(1));
                result.setY(res.getDouble(2));
                result.setR(res.getDouble(3));
                result.setResult(res.getBoolean(4));
                list.add(result);
            }
        } catch (SQLException ignored) {
//            ignored.printStackTrace();
        }
        return list;
    }

    public boolean removeAllResults(String uuid) {
        try {
            PreparedStatement ps = connection.prepareStatement(SQLRequests.deleteAllResults);
            ps.setString(1, uuid);
            ps.executeUpdate();
            return true;
        } catch (SQLException ignored) {}
        return false;
    }

    public static DatabaseHelper get() {
        if(instance == null) {
            instance = new DatabaseHelper();
            instance.connect();
            instance.createTables();
        }
        return instance;
    }

}

