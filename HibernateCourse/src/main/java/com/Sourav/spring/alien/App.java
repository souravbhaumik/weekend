package com.Sourav.spring.alien;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {

        Laptop l1 = new Laptop();
        l1.setId(1);
        l1.setBrand("Dell");
        l1.setModel("MSI");
        l1.setRam(16);

        Laptop l2 = new Laptop();
        l1.setId(2);
        l1.setBrand("Hp");
        l1.setModel("Pavilion");
        l1.setRam(16);

        Alien a1 = new Alien();
        a1.setAid(1);
        a1.setAname("Tinni");
        a1.setTech("Java");
        a1.setLaptops(Arrays.asList(l1, l2));

        l1.setAlien(a1);
        l2.setAlien(a1);

        Configuration cfg =
                new Configuration().addAnnotatedClass(Alien.class).addAnnotatedClass(Laptop.class).configure();
        try (SessionFactory sf =
                     cfg.buildSessionFactory()) {
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();
            session.persist(l1);
            session.persist(l2);
            session.persist(a1);
            tx.commit();
            session.close();
        }
    }
}
