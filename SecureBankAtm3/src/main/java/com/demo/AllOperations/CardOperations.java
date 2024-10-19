/*package com.demo.AllOperations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;

import com.demo.entity.Card; // Adjust the package name according to your project
import com.demo.entity.Customer; // Assuming you have a Customer class
import com.demo.util.HibernateUtil; // Adjust the package name according to your project

import java.util.HashSet;

public class CardOperations {
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = null;
        Transaction transaction = null;

        try {
            // Open a new session
            session = factory.openSession();
            // Begin a transaction
            transaction = session.beginTransaction();

            // Create a Customer object (make sure the customer exists)
            Customer customer = new Customer();
            customer.setCustomerId(1L); // Assuming a customer with ID 1 exists in the database

            // Create a Card object
            Card card = new Card();
            card.setCardNumber("1234-5678-9876-5432");
            card.setExpiryDate("12/26");
            card.setCustomer(customer);
            //card.setAtmMachines(new HashSet<>()); // Assuming you will add ATM machines later

            // Save the card to the database
            session.save(card);

            // Commit the transaction
            transaction.commit();

            // Retrieve the card from the database
            Card retrievedCard = session.get(Card.class, card.getCardId());
            // Display the retrieved card
            System.out.println(retrievedCard);
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace(); // Log the exception
        } finally {
            if (session != null) session.close();
        }

        // Close the factory after all operations are done
        factory.close();
    }
}*/
