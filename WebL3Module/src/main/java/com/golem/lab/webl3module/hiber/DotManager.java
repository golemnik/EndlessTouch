package com.golem.lab.webl3module.hiber;

import com.golem.lab.webl3module.data.Dot;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class DotManager {
//    private SessionFactory factory = HiberFactory.getManager();
    public DotManager () {
    }

    public List<Dot> getDots () {
        try {
            return HiberFactory.getManager().createQuery("from Dot", Dot.class).getResultList();
        }
        catch (Exception e) {
            return null;
        }
    }

    public void addDot (Dot dot) {
        try {
            EntityManager manager = HiberFactory.getManager();
            manager.getTransaction().begin();
            manager.persist(dot);
            manager.getTransaction().commit();
        }
        catch (Exception e) {
        }
    }
}
