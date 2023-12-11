package com.golem.lab.webl3module.hiber;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;


public class HiberFactory {
    private static EntityManagerFactory entityManagerFactory;
    private HiberFactory () {}
    public static EntityManager getManager() {
        if (entityManagerFactory == null) {
            try {
                Map<String, String> properties = new HashMap<>();
                entityManagerFactory = Persistence.createEntityManagerFactory(
                        "appdb",
                        properties
                );
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return entityManagerFactory.createEntityManager();
    }
}
