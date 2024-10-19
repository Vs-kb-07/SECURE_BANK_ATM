package com.demo.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.demo.dao.BankDao;
import com.demo.entity.Bank;
import com.demo.exception.ResourceNotFoundException;
import com.demo.util.HibernateUtil;

public class BankDaoImpl implements BankDao {

    @Override
    public Bank createBank(Bank bank) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            session.save(bank);
            transaction.commit();
            return bank;
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error creating bank: " + e.getMessage());
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Unexpected error: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Bank> getAllBanks() {
        try (Session session = HibernateUtil.getSession()) {
            Query<Bank> query = session.createQuery("FROM Bank", Bank.class);
            return query.list();
        } catch (HibernateException e) {
            System.err.println("Error retrieving banks: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Bank getBankById(int bankId) {
        try (Session session = HibernateUtil.getSession()) {
            Bank bank = session.get(Bank.class, bankId);
            if (bank == null) {
                throw new ResourceNotFoundException("Bank not found with ID: " + bankId);
            }
            return bank;
        } catch (HibernateException e) {
            System.err.println("Error retrieving bank: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Bank updateBank(int bankId, Bank updatedBank) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            Bank bank = session.get(Bank.class, bankId);
            if (bank != null) {
                bank.setBankName(updatedBank.getBankName());
                bank.setBankAddress(updatedBank.getBankAddress());
                session.update(bank);
                transaction.commit();
                return bank;
            } else {
                throw new ResourceNotFoundException("Bank not found with ID: " + bankId);
            }
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error updating bank: " + e.getMessage());
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Unexpected error: " + e.getMessage());
        }
        return null;
    }

    @Override
    public String deleteBank(int bankId) {
        Transaction transaction = null;
        String message;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            Bank bank = session.get(Bank.class, bankId);
            if (bank != null) {
                session.delete(bank);
                transaction.commit();
                message = "Bank deleted successfully";
            } else {
                message = "Bank not found with ID: " + bankId;
                transaction.rollback(); // Rollback if the bank was not found
            }
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            message = "Error deleting bank: " + e.getMessage();
            System.err.println(message);
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            message = "Unexpected error: " + e.getMessage();
            System.err.println(message);
        }
        return message;
    }
}
