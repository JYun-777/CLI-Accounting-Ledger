package org.example;

import java.util.Scanner;

public class Menu {

    public static Scanner read = new Scanner(System.in);
    public static String menuChoice;

    public static void homePage(){
        menuLoop:
        while(true){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~ AUTOMATED LEDGER SYSTEM ~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print("Please select an option:\n" +
                    " D) Add Deposit\n P) Make Payment (Debit)\n" +
                    " L) Ledger\n X) Exit\n\n>>");

            menuChoice = read.nextLine();

            switch (menuChoice.toLowerCase()){
                case "d":
                    LedgerFunctions.addDeposit();
                    break;
                case "p":
                    LedgerFunctions.addPayment();
                    break;
                case "l":
                    ledgerMenu();
                    break;
                case "x":
                    System.out.println("Have a nice day!");
                    break menuLoop;
                default:
                    System.out.println("Invalid option, Please try again");
                    break;
            }
        }
    }
    public static void ledgerMenu(){
        //All entries should show newest entry first
        System.out.println("~~~~~~~~~~~~ LEDGER ~~~~~~~~~~~~~\nPlease select what you would like to view:\n" +
                " A) All\n D) Deposits\n P) Payments\n H) Return to Home");
        System.out.print("\n>>");
        menuChoice = read.nextLine();

        switch (menuChoice.toLowerCase()){
            case "a":
                break;
            case "d":
                break;
            case "p":
                break;
            case "h":
                break;
        }
    }

}
