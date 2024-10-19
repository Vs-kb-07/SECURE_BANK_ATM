/*package com.demo.AllOperations;

import java.util.List;
import java.util.Scanner;

import com.demo.entity.AtmMachine;
import com.demo.entity.Bank; // Import the Bank entity
import com.demo.exception.ResourceNotFoundException;
import com.demo.service.AtmMachineService;
import com.demo.serviceImpl.AtmMachineServiceImpl;

public class AtmMachineOperations {

    static AtmMachineService atmMachineService = new AtmMachineServiceImpl();
    static Scanner sc = new Scanner(System.in);

    public static AtmMachine atmMachineInputs() {
        System.out.println("Enter ATM ID (numeric value):");
        Long atmId = sc.nextLong();
        sc.nextLine(); // Consume the newline

        System.out.println("Enter Location:");
        String location = sc.nextLine();

        // Get the bank object
        Bank bank = selectBank(); // Method to select a bank
        if (bank == null) {
            System.out.println("Unable to create ATM Machine without a valid Bank.");
            return null; // Return null if no valid bank
        }

        // Create and return the new AtmMachine object
        return new AtmMachine(atmId, location, bank);
    }

    public static void atmMachineOperations() {
        while (true) {
            System.out.println("Choose an option:\n"
                    + "1. Add ATM Machine Details\n"
                    + "2. Retrieve All ATM Machines\n"
                    + "3. Update ATM Machine Data\n"
                    + "4. Delete ATM Machine Data\n"
                    + "5. Return to Main Menu");

            int input;
            try {
                input = Integer.parseInt(sc.nextLine()); // Read input as String and parse
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue; // Skip the rest of the loop and prompt again
            }

            switch (input) {
                case 1:
                    addAtmMachine(); // Method to add ATM machine
                    break;

                case 2:
                    retrieveAllAtmMachines(); // Method to retrieve all ATM machines
                    break;

                case 3:
                    updateAtmMachine(); // Method to update ATM machine
                    break;

                case 4:
                    deleteAtmMachine(); // Method to delete ATM machine
                    break;

                case 5:
                    // Return to the main menu
                    System.out.println("Returning to the main menu...");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void addAtmMachine() {
        AtmMachine atmMachine = atmMachineInputs();
        if (atmMachine != null) {
            AtmMachine savedEntity = atmMachineService.createAtmMachine(atmMachine);
            System.out.println("ATM Machine data has been saved successfully: " + savedEntity);
        }
    }

    private static void retrieveAllAtmMachines() {
        List<AtmMachine> atmMachines = atmMachineService.getAllAtmMachines();
        if (atmMachines == null || atmMachines.isEmpty()) {
            System.out.println("No ATM machines found.");
        } else {
            System.out.println("List of ATM Machines:");
            for (AtmMachine atmMachineItem : atmMachines) {
                System.out.println(atmMachineItem);
            }
        }
    }

    private static void updateAtmMachine() {
        System.out.println("Enter ATM ID to update:");
        Long atmId = sc.nextLong();
        try {
            AtmMachine existingAtmMachine = atmMachineService.getAtmMachine(atmId);
            if (existingAtmMachine != null) {
                AtmMachine updatedAtmMachine = updatedAtmMachineData();
                AtmMachine updatedInfo = atmMachineService.updateAtmMachine(atmId, updatedAtmMachine);
                System.out.println("ATM Machine data has been updated successfully: " + updatedInfo);
            } else {
                System.out.println("ATM ID not found.");
            }
        } catch (ResourceNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deleteAtmMachine() {
        System.out.println("Enter ATM ID to delete:");
        Long id = sc.nextLong();
        String message = atmMachineService.deleteAtmMachine(id);
        System.out.println(message);
    }

    private static AtmMachine updatedAtmMachineData() {
        System.out.println("Enter updated ATM ID (existing ID):");
        Long atmId = sc.nextLong();
        sc.nextLine(); // Consume the newline

        System.out.println("Enter updated Location:");
        String location = sc.nextLine();

        // Assuming the bank should not be updated here
        return new AtmMachine(atmId, location, null); // You can modify this if needed
    }

    private static Bank selectBank() {
        System.out.println("Enter Bank ID to associate with the ATM Machine:");
        Long bankId = sc.nextLong();
        // Implement the logic to get the Bank object by its ID
        // For example, using a BankService to fetch the bank
        // return bankService.getBankById(bankId);
        return null; // Placeholder; implement as per your requirement
    }
}*/
