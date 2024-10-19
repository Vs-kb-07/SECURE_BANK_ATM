package com.demo.main;

import com.demo.entity.*; // Adjust this import to match your actual package for entities
import static com.demo.main.AllOparations.customerOperations;
import static com.demo.main.AllOparations.cardOperations;
import static com.demo.main.AllOparations.bankOperations;
import static com.demo.main.AllOparations.atmMachineOperations;
import java.util.Scanner;

public class MainOperations {

    static Scanner sc = new Scanner(System.in);

    public static void mainOps() {
        while (true) {
            System.out.println("Press 1: Customer Operations\n"
                    + "Press 2: Card Operations\n"
                    + "Press 3: Bank Operations\n"
                    + "Press 4: ATM Machine Operations\n"
                    + "Press 5: Quit");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    customerOperations();
                    System.out.println("=======================================");
                    break;
                case 2:
                    cardOperations();
                    System.out.println("=======================================");
                    break;
                case 3:
                    bankOperations();
                    System.out.println("=======================================");
                    break;
                case 4:
                    atmMachineOperations();
                    System.out.println("=======================================");
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong input, please try again.");
            }
        }
    }

    public static void main(String[] args) {
        mainOps();
    }
}
