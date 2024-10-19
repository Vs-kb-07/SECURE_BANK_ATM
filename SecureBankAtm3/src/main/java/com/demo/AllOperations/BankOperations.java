package com.demo.AllOperations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;

import com.demo.entity.Bank; 
import com.demo.util.HibernateUtil; 

public class BankOperations {
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;

        try (Session session = factory.openSession()) {
            // Begin a transaction
            transaction = session.beginTransaction();

            // Create a Bank object
            Bank bank = new Bank();
            bank.setBankName("Bank of india Bank");
            bank.setBankAddress("Kelwaroad");

            // Save the bank to the database
            session.save(bank);

            // Commit the transaction
            transaction.commit();

            // Retrieve the bank from the database
            Bank retrievedBank = session.get(Bank.class, bank.getBankId());
            // Display the retrieved bank
            System.out.println(retrievedBank);
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Log the exception
        } finally {
            if (factory != null) {
                factory.close(); // Close the factory
            }
        }
    }
}
