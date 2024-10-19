package com.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AtmMachine {

    @Id // primary key
    @Column(name = "AtmId", length = 10)
    private int atmId;

    @Column(name = "BankLocation", length = 100)
    private String bankLocation;

    @ManyToOne
    @JoinColumn(name = "BankId")
    private Bank bankId;

    public int getAtmId() {
        return atmId;
    }

    public void setAtmId(int atmId) {
        this.atmId = atmId;
    }

    public String getBankLocation() {
        return bankLocation;
    }

    public void setBankLocation(String bankLocation) {
        this.bankLocation = bankLocation;
    }

    public Bank getBankId() {
        return bankId;
    }

    public void setBankId(Bank bankId) {
        this.bankId = bankId;
    }

    @Override
    public String toString() {
        return "AtmMachine [atmId=" + atmId + ", bankLocation=" + bankLocation + ", bankId=" + bankId + "]";
    }

    public AtmMachine(int atmId, String bankLocation, Bank bankId) {
        super();
        this.atmId = atmId;
        this.bankLocation = bankLocation;
        this.bankId = bankId;
    }

    public AtmMachine() {
        super();
        // Default constructor
    }
}
