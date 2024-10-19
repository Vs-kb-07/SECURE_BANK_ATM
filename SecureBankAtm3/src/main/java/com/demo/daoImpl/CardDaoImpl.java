package com.demo.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.demo.dao.CardDao;
import com.demo.entity.Card;
import com.demo.exception.ResourceNotFoundException;
import com.demo.util.HibernateUtil;

public class CardDaoImpl implements CardDao {

    @Override
    public Card createCard(Card card) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            session.save(card);
            transaction.commit();
            return card;
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error creating card: " + e.getMessage());
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Unexpected error: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Card> getAllCards() {
        try (Session session = HibernateUtil.getSession()) {
            Query<Card> query = session.createQuery("FROM Card", Card.class);
            return query.list();
        } catch (HibernateException e) {
            System.err.println("Error retrieving cards: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Card getCardById(int cardId) {
        try (Session session = HibernateUtil.getSession()) {
            Card card = session.get(Card.class, cardId);
            if (card == null) {
                throw new ResourceNotFoundException("Card ID not found: " + cardId);
            }
            return card;
        } catch (HibernateException e) {
            System.err.println("Error retrieving card: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Card updateCard(int cardId, Card updatedCard) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            Card card = session.get(Card.class, cardId);
            if (card != null) {
                card.setCardNumber(updatedCard.getCardNumber());
                card.setExpireDate(updatedCard.getExpireDate());
                card.setCustomerId(updatedCard.getCustomerId()); // Ensure the customer is set correctly
                session.update(card);
                transaction.commit();
                return card;
            } else {
                throw new ResourceNotFoundException("Card ID not found: " + cardId);
            }
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error updating card: " + e.getMessage());
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Unexpected error: " + e.getMessage());
        }
        return null;
    }

    @Override
    public String deleteCard(int cardId) {
        Transaction transaction = null;
        String message;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            Card card = session.get(Card.class, cardId);
            if (card != null) {
                session.delete(card);
                transaction.commit();
                message = "Card with ID " + cardId + " is deleted";
            } else {
                throw new ResourceNotFoundException("Card ID not found: " + cardId);
            }
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            message = "Error deleting card: " + e.getMessage();
            System.err.println(message);
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            message = "Unexpected error: " + e.getMessage();
            System.err.println(message);
        }
        return message;
    }
}
