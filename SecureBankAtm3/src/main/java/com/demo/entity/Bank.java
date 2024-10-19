package com.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bank {

    @Id // primary key
    @Column(name = "BankId", length = 10)
    private int bankId;

    @Column(name = "BankName", length = 50)
    private String bankName;

    @Column(name = "BankAddress", length = 100)
    private String bankAddress;

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAddress() {
        return bankAddress;
    }

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    @Override
    public String toString() {
        return "Bank [bankId=" + bankId + ", bankName=" + bankName + ", bankAddress=" + bankAddress + "]";
    }

    public Bank(int bankId, String bankName, String bankAddress) {
        super();
        this.bankId = bankId;
        this.bankName = bankName;
        this.bankAddress = bankAddress;
    }

    public Bank() {
        super();
        // Default constructor
    }
}
