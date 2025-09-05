package com.Sourav.spring.starter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        Student s1 = new Student();
        Student s2 = null;
        s1.setRollNo(7);
        s1.setName("Anant");
        s1.setAge(28);

        Configuration cfg = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure();

        try(SessionFactory sf = cfg.buildSessionFactory())
        {
            Session session = sf.openSession();

        /*
            // Get Data
            s2 = session.find(Student.class, 1);
        */

        /*
            // Save Data -
            Transaction transaction = session
            .beginTransaction();
            session.persist(s1);
            transaction.commit();
        */
            Transaction tx = session.beginTransaction();
            session.merge(s1);
            tx.commit();

            System.out.println(s1);
        }
    }
}
