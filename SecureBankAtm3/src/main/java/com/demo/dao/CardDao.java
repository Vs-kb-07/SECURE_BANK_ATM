package com.demo.dao;

import java.util.List;
import com.demo.entity.Card;

public interface CardDao {
    Card createCard(Card card);
    List<Card> getAllCards();
    Card getCardById(int cardId);
    Card updateCard(int cardId, Card updatedCard);
    String deleteCard(int cardId);
}
