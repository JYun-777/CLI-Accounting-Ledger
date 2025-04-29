package org.example;

import java.util.Scanner;

public class Menu {

    public static Scanner read = new Scanner()

    public static void homePage(){
        while(true){
            System.out.println("Please select an option:\n" +
                    " D) Add Deposit\n P) Make Payment (Debit)\n" +
                    " L) Ledger\n X) Exit\n\n>>");

            String menuChoice = read.nextLine();

            switch (menuChoice){
                case "D":
                    addDeposit();
                case "P":
                    makePayment();
                case "L":
                    openLedger();
                case "X":
                    break;
            }
        }

    }

}
