package com.demo.serviceImpl;

import java.util.List;

import com.demo.dao.CardDao;
import com.demo.daoImpl.CardDaoImpl;
import com.demo.entity.Card;
import com.demo.service.CardService;

public class CardServiceImpl implements CardService {

    CardDao cardDao = new CardDaoImpl();

    @Override
    public Card createCard(Card card) {
        // Invoke dao method to save the card object
        return cardDao.createCard(card);
    }

    @Override
    public List<Card> getAllCards() {
        // Retrieve all cards
        return cardDao.getAllCards();
    }

    @Override
    public Card getCardById(int cardId) {
        // Retrieve a card by its ID
        return cardDao.getCardById(cardId);
    }

    @Override
    public Card updateCard(int cardId, Card updatedCard) {
        // Update an existing card
        return cardDao.updateCard(cardId, updatedCard);
    }

    @Override
    public String deleteCard(int cardId) {
        // Delete a card by ID
        return cardDao.deleteCard(cardId);
    }
}
