package com.demo.serviceImpl;

import java.util.List;

import com.demo.dao.BankDao;
import com.demo.daoImpl.BankDaoImpl;
import com.demo.entity.Bank;
import com.demo.service.BankService;

public class BankServiceImpl implements BankService {

    BankDao bankDao = new BankDaoImpl();

    @Override
    public Bank createBank(Bank bank) {
        // Invoke dao method to save the bank object
        return bankDao.createBank(bank);
    }

    @Override
    public List<Bank> getAllBanks() {
        // Retrieve all banks
        return bankDao.getAllBanks();
    }

    @Override
    public Bank getBankById(int bankId) {
        // Retrieve bank by ID
        return bankDao.getBankById(bankId);
    }

    @Override
    public Bank updateBank(int bankId, Bank updatedBank) {
        // Update bank details
        return bankDao.updateBank(bankId, updatedBank);
    }

    @Override
    public String deleteBank(int bankId) {
        // Delete bank by ID
        return bankDao.deleteBank(bankId);
    }
}
