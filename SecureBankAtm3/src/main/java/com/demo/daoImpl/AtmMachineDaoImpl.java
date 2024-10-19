package com.demo.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.demo.dao.AtmMachineDao;
import com.demo.entity.AtmMachine;
import com.demo.exception.ResourceNotFoundException;
import com.demo.util.HibernateUtil;

public class AtmMachineDaoImpl implements AtmMachineDao {

    @Override
    public AtmMachine createAtmMachine(AtmMachine atmMachine) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            session.save(atmMachine);
            transaction.commit();
            return atmMachine;
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error creating ATM machine: " + e.getMessage());
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Unexpected error: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<AtmMachine> getAllAtmMachines() {
        try (Session session = HibernateUtil.getSession()) {
            Query<AtmMachine> query = session.createQuery("FROM AtmMachine", AtmMachine.class);
            return query.list();
        } catch (HibernateException e) {
            System.err.println("Error retrieving ATM machines: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
        return null;
    }

    @Override
    public AtmMachine getAtmMachineById(int atmId) {
        try (Session session = HibernateUtil.getSession()) {
            AtmMachine atmMachine = session.get(AtmMachine.class, atmId);
            if (atmMachine == null) {
                throw new ResourceNotFoundException("ATM Machine ID not found: " + atmId);
            }
            return atmMachine;
        } catch (HibernateException e) {
            System.err.println("Error retrieving ATM machine: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
        return null;
    }

    @Override
    public AtmMachine updateAtmMachine(int atmId, AtmMachine updatedAtmMachine) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            AtmMachine atmMachine = session.get(AtmMachine.class, atmId);
            if (atmMachine != null) {
                atmMachine.setBankLocation(updatedAtmMachine.getBankLocation());
                atmMachine.setBankId(updatedAtmMachine.getBankId());
                session.update(atmMachine); // Use update instead of saveOrUpdate
                transaction.commit();
                return atmMachine;
            } else {
                throw new ResourceNotFoundException("ATM Machine ID not found: " + atmId);
            }
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error updating ATM machine: " + e.getMessage());
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Unexpected error: " + e.getMessage());
        }
        return null;
    }

    @Override
    public String deleteAtmMachine(int atmId) {
        Transaction transaction = null;
        String message;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            AtmMachine atmMachine = session.get(AtmMachine.class, atmId);
            if (atmMachine != null) {
                session.delete(atmMachine);
                transaction.commit();
                message = "ATM Machine with ID " + atmId + " is deleted";
            } else {
                throw new ResourceNotFoundException("ATM Machine ID not found: " + atmId);
            }
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            message = "Error deleting ATM machine: " + e.getMessage();
            System.err.println(message);
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            message = "Unexpected error: " + e.getMessage();
            System.err.println(message);
        }
        return message;
    }
}
