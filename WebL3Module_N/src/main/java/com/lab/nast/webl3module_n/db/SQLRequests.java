package com.lab.nast.webl3module_n.db;

public class SQLRequests {

        public static final String tablesCreation =
                "CREATE TABLE IF NOT EXISTS hit_data(" +
                        "id serial primary key," +
                        "owner_uuid varchar not null," +
                        "x float not null," +
                        "y float not null," +
                        "r float not null," +
                        "result bool not null" +
                        ");";

        public static final String insertResult =
                "INSERT INTO hit_data (owner_uuid, x, y, r, result)" +
                        "VALUES (?, ?, ?, ?, ?);";

        public static final String selectAllResults =
                "SELECT x, y, r, result" +
                        "WHERE owner_uuid = ?;";

        public static final String deleteAllResults =
                "DELETE FROM hit_data WHERE owner_uuid = ?;";
    }





