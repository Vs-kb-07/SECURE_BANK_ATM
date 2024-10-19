package com.demo.serviceImpl;

import java.util.List;

import org.hibernate.Session;

import com.demo.dao.AtmMachineDao;
import com.demo.daoImpl.AtmMachineDaoImpl;
import com.demo.entity.AtmMachine;
import com.demo.util.HibernateUtil;
import com.demo.service.AtmMachineService;

public class AtmMachineServiceImpl implements AtmMachineService {

    AtmMachineDao atmMachineDao = new AtmMachineDaoImpl();

    @Override
    public AtmMachine createAtmMachine(AtmMachine atmMachine) {
        // Invoke dao method to save the ATM machine object
        return atmMachineDao.createAtmMachine(atmMachine);
    }

    @Override
    public List<AtmMachine> getAllAtmMachines() {
        // Retrieve all ATM machines
        return atmMachineDao.getAllAtmMachines();
    }

    @Override
    public AtmMachine getAtmMachineById(int atmId) {
        // Retrieve ATM machine by ID
        return atmMachineDao.getAtmMachineById(atmId);
    }

    @Override
    public AtmMachine updateAtmMachine(int atmId, AtmMachine updatedAtmMachine) {
        // Update an existing ATM machine
        return atmMachineDao.updateAtmMachine(atmId, updatedAtmMachine);
    }

    @Override
    public String deleteAtmMachine(int atmId) {
        // Delete an ATM machine by ID
        return atmMachineDao.deleteAtmMachine(atmId);
    }
}
