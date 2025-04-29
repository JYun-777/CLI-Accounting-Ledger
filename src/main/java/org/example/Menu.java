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
                    depositPrompt();
                case "P":
                    paymentPrompt();
                case "L":
                    ledgerMenu();
                case "X":
                    break;
            }
        }
    }

    public static void ledgerMenu(){
        //All entries should show newest entry first
        System.out.println("~~~~~~~~~~~~ LEDGER ~~~~~~~~~~~~~\nPlease select an option:\n" +
                " A) All\n D) Deposits\n P) Payments\n H) Return to Home");
    }

}
