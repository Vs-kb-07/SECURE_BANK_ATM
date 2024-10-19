package com.demo.SecureBankAtm3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.entity.Customer;
import com.demo.entity.Card;
import com.demo.entity.Bank;
import com.demo.entity.AtmMachine;
import com.demo.util.HibernateUtil;

public class App {
    public static void main(String[] args) {
        // Obtain a Hibernate SessionFactory
        SessionFactory factory = HibernateUtil.getSessionFactory();
        
        // Open a new session
        Session session = factory.openSession();
        // Begin a transaction
        Transaction transaction = session.beginTransaction();
        
        try {
            // Create and save a Customer
            Customer customer = new Customer(1, "John Doe", "john.doe@example.com", "1234567890", "123 Main St, City");
            session.save(customer);
            
            // Create and save a Bank
            Bank bank = new Bank(1, "Demo Bank", "456 Elm St, City");
            session.save(bank);
            
            // Create and save a Card
            Card card = new Card(1, "1234567812345678", "12/25", customer);
            session.save(card);
            
            // Create and save an AtmMachine
            AtmMachine atmMachine = new AtmMachine(1, "789 Pine St, City", bank);
            session.save(atmMachine);
            
            // Commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace(); // Log the exception
        } finally {
            // Close the Session
            session.close();
            // Close the Session Factory
            factory.close();
        }
    }
}
