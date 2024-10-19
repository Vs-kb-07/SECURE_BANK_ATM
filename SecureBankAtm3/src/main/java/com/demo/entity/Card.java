package com.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Card {

    @Id // primary key
    @Column(name = "CardId", length = 10)
    private int cardId;

    @Column(name = "CardNumber", length = 16)
    private String cardNumber;

    @Column(name = "ExpireDate")
    private String expireDate; // Consider using java.util.Date or java.time.LocalDate

    @ManyToOne
    @JoinColumn(name = "CustomerId")
    private Customer customerId;

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Card [cardId=" + cardId + ", cardNumber=" + cardNumber + ", expireDate=" + expireDate +
               ", customerId=" + customerId + "]";
    }

    public Card(int cardId, String cardNumber, String expireDate, Customer customerId) {
        super();
        this.cardId = cardId;
        this.cardNumber = cardNumber;
        this.expireDate = expireDate;
        this.customerId = customerId;
    }

    public Card() {
        super();
        // Default constructor
    }
}
