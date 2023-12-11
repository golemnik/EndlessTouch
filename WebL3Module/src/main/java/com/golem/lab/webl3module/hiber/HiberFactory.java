package com.golem.lab.webl3module.hiber;

import com.golem.lab.webl3module.data.Dot;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.HashMap;
import java.util.Map;


public class HiberFactory {
    private static SessionFactory sessionFactory;
    private HiberFactory() {}
    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null){
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Dot.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Something went wrong with configuration: " + e.getMessage());
            }
        }
        return sessionFactory;
    }
}
