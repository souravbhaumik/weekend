package com.Sourav.spring;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        Student s1 = new Student();
        s1.setRollNo(1);
        s1.setName("Tinni");
        s1.setAge(26);

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(com.Sourav.spring.Student.class);
        cfg.configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        session.persist(s1);

        System.out.println(s1);
    }
}
