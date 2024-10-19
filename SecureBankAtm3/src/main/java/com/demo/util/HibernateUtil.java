package com.demo.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.AtmMachine;
import com.demo.entity.Bank;
import com.demo.entity.Card;
import com.demo.entity.Customer;



public class HibernateUtil {

    private final static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Customer.class) // Add Customer entity
                    .addAnnotatedClass(AtmMachine.class) // Add ATM entity
                    .addAnnotatedClass(Card.class) // Add Card entity
                    .addAnnotatedClass(Bank.class) //add Bank entity
                    .buildSessionFactory();

        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession() {
        return getSessionFactory().openSession(); // session opened
    }
}
