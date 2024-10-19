package com.demo.main;

import com.demo.service.CustomerService;
import com.demo.service.CardService;
import com.demo.service.BankService;
import com.demo.service.AtmMachineService;
import com.demo.serviceImpl.CustomerServiceImpl;
import com.demo.serviceImpl.CardServiceImpl;
import com.demo.serviceImpl.BankServiceImpl;
import com.demo.serviceImpl.AtmMachineServiceImpl;
import com.demo.entity.Customer;
import com.demo.entity.Card;
import com.demo.entity.Bank;
import com.demo.entity.AtmMachine;

import java.util.List;
import java.util.Scanner;

public class AllOparations {

    static CustomerService customerService = new CustomerServiceImpl();
    static CardService cardService = new CardServiceImpl();
    static BankService bankService = new BankServiceImpl();
    static AtmMachineService atmMachineService = new AtmMachineServiceImpl();

    static Scanner sc = new Scanner(System.in);

    public static Customer customerInputs() {
        System.out.println("Enter Customer ID:");
        int customerId = sc.nextInt();
        sc.nextLine(); // Clear buffer

        System.out.println("Enter Customer Name:");
        String customerName = sc.nextLine();

        System.out.println("Enter Email:");
        String email = sc.nextLine();

        System.out.println("Enter Phone Number:");
        String phoneNumber = sc.nextLine();

        System.out.println("Enter Address:");
        String address = sc.nextLine();

        return new Customer(customerId, customerName, email, phoneNumber, address);
    }

    public static Card cardInputs() {
        System.out.println("Enter Card ID:");
        int cardId = sc.nextInt();
        sc.nextLine(); // Clear buffer

        System.out.println("Enter Card Number:");
        String cardNumber = sc.nextLine();

        System.out.println("Enter Expiry Date (MM/YY):");
        String expireDate = sc.nextLine();

        System.out.println("Enter Customer ID (owner of the card):");
        int customerId = sc.nextInt();
        sc.nextLine();

        Customer customer = customerService.getCustomerById(customerId);
        if (customer == null) {
            System.out.println("Customer ID not found. Please try again.");
            return null;
        }

        return new Card(cardId, cardNumber, expireDate, customer);
    }

    public static Bank bankInputs() {
        System.out.println("Enter Bank ID:");
        int bankId = sc.nextInt();
        sc.nextLine(); // Clear buffer

        System.out.println("Enter Bank Name:");
        String bankName = sc.nextLine();

        System.out.println("Enter Bank Address:");
        String bankAddress = sc.nextLine();

        return new Bank(bankId, bankName, bankAddress);
    }

    public static AtmMachine atmMachineInputs() {
        System.out.println("Enter ATM ID:");
        int atmId = sc.nextInt();
        sc.nextLine(); // Clear buffer

        System.out.println("Enter Bank Location:");
        String bankLocation = sc.nextLine();

        System.out.println("Enter Bank ID (owner of the ATM):");
        int bankId = sc.nextInt();
        sc.nextLine();

        Bank bank = bankService.getBankById(bankId);
        if (bank == null) {
            System.out.println("Bank ID not found. Please try again.");
            return null;
        }

        return new AtmMachine(atmId, bankLocation, bank);
    }

    public static void customerOperations() {
        while (true) {
            System.out.println("Press 1. Add Customer\nPress 2. Retrieve All Customers\n" +
                               "Press 3. Update Customer\nPress 4. Delete Customer\n" +
                               "Press 5. To get back to the main menu");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    Customer customer = customerInputs();
                    if (customer != null) {
                        Customer savedCustomer = customerService.createCustomer(customer);
                        System.out.println("Customer has been saved successfully: " + savedCustomer);
                    }
                    break;

                case 2:
                    List<Customer> customers = customerService.getAllCustomers();
                    for (Customer c : customers) {
                        System.out.println(c);
                    }
                    break;

                case 3:
                    System.out.println("Enter Customer ID to update the information:");
                    int customerId = sc.nextInt();
                    Customer existingCustomer = customerService.getCustomerById(customerId);
                    if (existingCustomer != null) {
                        Customer updatedCustomer = customerInputs();
                        if (updatedCustomer != null) {
                            Customer updatedInfo = customerService.updateCustomer(customerId, updatedCustomer);
                            System.out.println("Customer has been updated successfully: " + updatedInfo);
                        }
                    } else {
                        System.out.println("Customer ID not found");
                    }
                    break;

                case 4:
                    System.out.println("Enter Customer ID to delete the information:");
                    int id = sc.nextInt();
                    String message = customerService.deleteCustomer(id);
                    System.out.println(message);
                    break;

                case 5:
                    return; // Return to main menu

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void cardOperations() {
        while (true) {
            System.out.println("Press 1. Add Card\nPress 2. Retrieve All Cards\n" +
                               "Press 3. Update Card\nPress 4. Delete Card\n" +
                               "Press 5. To get back to the main menu");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    Card card = cardInputs();
                    if (card != null) {
                        Card savedCard = cardService.createCard(card);
                        System.out.println("Card has been saved successfully: " + savedCard);
                    }
                    break;

                case 2:
                    List<Card> cards = cardService.getAllCards();
                    for (Card c : cards) {
                        System.out.println(c);
                    }
                    break;

                case 3:
                    System.out.println("Enter Card ID to update the information:");
                    int cardId = sc.nextInt();
                    Card existingCard = cardService.getCardById(cardId);
                    if (existingCard != null) {
                        Card updatedCard = cardInputs();
                        if (updatedCard != null) {
                            Card updatedInfo = cardService.updateCard(cardId, updatedCard);
                            System.out.println("Card has been updated successfully: " + updatedInfo);
                        }
                    } else {
                        System.out.println("Card ID not found");
                    }
                    break;

                case 4:
                    System.out.println("Enter Card ID to delete the information:");
                    int id = sc.nextInt();
                    String message = cardService.deleteCard(id);
                    System.out.println(message);
                    break;

                case 5:
                    return; // Return to main menu

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void bankOperations() {
        while (true) {
            System.out.println("Press 1. Add Bank\nPress 2. Retrieve All Banks\n" +
                               "Press 3. Update Bank\nPress 4. Delete Bank\n" +
                               "Press 5. To get back to the main menu");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    Bank bank = bankInputs();
                    if (bank != null) {
                        Bank savedBank = bankService.createBank(bank);
                        System.out.println("Bank has been saved successfully: " + savedBank);
                    }
                    break;

                case 2:
                    List<Bank> banks = bankService.getAllBanks();
                    for (Bank b : banks) {
                        System.out.println(b);
                    }
                    break;

                case 3:
                    System.out.println("Enter Bank ID to update the information:");
                    int bankId = sc.nextInt();
                    Bank existingBank = bankService.getBankById(bankId);
                    if (existingBank != null) {
                        Bank updatedBank = bankInputs();
                        if (updatedBank != null) {
                            Bank updatedInfo = bankService.updateBank(bankId, updatedBank);
                            System.out.println("Bank has been updated successfully: " + updatedInfo);
                        }
                    } else {
                        System.out.println("Bank ID not found");
                    }
                    break;

                case 4:
                    System.out.println("Enter Bank ID to delete the information:");
                    int id = sc.nextInt();
                    String message = bankService.deleteBank(id);
                    System.out.println(message);
                    break;

                case 5:
                    return; // Return to main menu

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void atmMachineOperations() {
        while (true) {
            System.out.println("Press 1. Add ATM Machine\nPress 2. Retrieve All ATMs\n" +
                               "Press 3. Update ATM Machine\nPress 4. Delete ATM Machine\n" +
                               "Press 5. To get back to the main menu");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    AtmMachine atmMachine = atmMachineInputs();
                    if (atmMachine != null) {
                        AtmMachine savedAtmMachine = atmMachineService.createAtmMachine(atmMachine);
                        System.out.println("ATM Machine has been saved successfully: " + savedAtmMachine);
                    }
                    break;

                case 2:
                    List<AtmMachine> atmMachines = atmMachineService.getAllAtmMachines();
                    for (AtmMachine atm : atmMachines) {
                        System.out.println(atm);
                    }
                    break;

                case 3:
                    System.out.println("Enter ATM ID to update the information:");
                    int atmId = sc.nextInt();
                    AtmMachine existingAtmMachine = atmMachineService.getAtmMachineById(atmId);
                    if (existingAtmMachine != null) {
                        AtmMachine updatedAtmMachine = atmMachineInputs();
                        if (updatedAtmMachine != null) {
                            AtmMachine updatedInfo = atmMachineService.updateAtmMachine(atmId, updatedAtmMachine);
                            System.out.println("ATM Machine has been updated successfully: " + updatedInfo);
                        }
                    } else {
                        System.out.println("ATM ID not found");
                    }
                    break;

                case 4:
                    System.out.println("Enter ATM ID to delete the information:");
                    int id = sc.nextInt();
                    String message = atmMachineService.deleteAtmMachine(id);
                    System.out.println(message);
                    break;

                case 5:
                    return; // Return to main menu

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("Choose an operation:\n" +
                               "1. Customer Operations\n" +
                               "2. Card Operations\n" +
                               "3. Bank Operations\n" +
                               "4. ATM Machine Operations\n" +
                               "5. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    customerOperations();
                    break;
                case 2:
                    cardOperations();
                    break;
                case 3:
                    bankOperations();
                    break;
                case 4:
                    atmMachineOperations();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
