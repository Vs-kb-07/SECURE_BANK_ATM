package com.demo.service;

import java.util.List;
import com.demo.entity.Bank;

public interface BankService {
    Bank createBank(Bank bank);
    List<Bank> getAllBanks();
    Bank getBankById(int bankId);
    Bank updateBank(int bankId, Bank updatedBank);
    String deleteBank(int bankId);
}
