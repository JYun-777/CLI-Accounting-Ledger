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
                    " L) Ledger\n O) Other options\n X) Exit\n\n>>");

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
                case "o":
                    otherMenu();
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
        System.out.println("""
                ~~~~~~~~~~~~ LEDGER ~~~~~~~~~~~~~
                Please select what you would like to view:
                 A) All
                 D) Deposits
                 P) Payments
                 H) Return to Home""");
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
            default:
                System.out.println("Invalid option, Please try again");
                break;
        }
    }

    public static void otherMenu(){
        System.out.println("~~~~~~~~~~~~ ADDITIONAL OPTIONS ~~~~~~~~~~~~~\nPlease select what you would like to do:\n" +
                " C) Clear transaction records\n H) Return to Home");
        System.out.print("\n>>");
        menuChoice = read.nextLine();

        switch (menuChoice.toLowerCase()) {
            case "c":
                System.out.println("Are you sure you would like to clear transaction records?\n Enter Y for yes, N for no.");
                System.out.print(">>");
                menuChoice = read.nextLine();
                if (menuChoice.equalsIgnoreCase("y")) {
                    LedgerFunctions.clear();
                    System.out.println("Ledger cleared.");
                } else {
                    break;
                }
                break;
            case "h":
                homePage();
                break;
            default:
                System.out.println("Invalid option, Please try again");
                break;
        }
    }

}
