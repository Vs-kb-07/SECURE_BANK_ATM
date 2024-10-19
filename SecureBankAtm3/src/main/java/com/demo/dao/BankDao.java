package com.demo.dao;

import java.util.List;
import com.demo.entity.Bank;

public interface BankDao {
    Bank createBank(Bank bank);
    List<Bank> getAllBanks();
    Bank getBankById(int bankId);
    Bank updateBank(int bankId, Bank updatedBank);
    String deleteBank(int bankId);
}
