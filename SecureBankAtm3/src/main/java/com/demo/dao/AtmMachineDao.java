package com.demo.dao;

import java.util.List;
import com.demo.entity.AtmMachine;

public interface AtmMachineDao {
    AtmMachine createAtmMachine(AtmMachine atmMachine);
    List<AtmMachine> getAllAtmMachines();
    AtmMachine getAtmMachineById(int atmId);
    AtmMachine updateAtmMachine(int atmId, AtmMachine updatedAtmMachine);
    String deleteAtmMachine(int atmId);
}
