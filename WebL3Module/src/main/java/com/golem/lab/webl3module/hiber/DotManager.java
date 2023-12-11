package com.golem.lab.webl3module.hiber;

import com.golem.lab.webl3module.data.Dot;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Queue;

public class DotManager {
//    private SessionFactory factory = HiberFactory.getManager();
    public DotManager () {
    }

    public List<Dot> getDots () {
        try (Session session = HiberFactory.getSessionFactory().openSession()) {
            Query<Dot> query = session.createQuery("from Dot", Dot.class);
            return query.getResultList();
        }
        catch (Exception e) {
            return null;
        }
    }

    public void addDot (Dot dot) {
        try (Session session = HiberFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(dot);
            transaction.commit();
        }
    }
}
