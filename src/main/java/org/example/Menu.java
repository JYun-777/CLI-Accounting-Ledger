package org.example;

import java.util.Scanner;

public class Menu {

    public static Scanner read = new Scanner(System.in);
    public static String menuChoice;

    public static void homePage(){
        menuLoop:
        while(true){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~ AUTOMATED LEDGER SYSTEM ~~~~~~~~~~~~~~~~~~~~~~~~~~");
            try{Thread.sleep(500);} catch (InterruptedException e) {throw new RuntimeException(e);}

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
        ledgerMenuLoop:
        while(true) {
            System.out.println("~~~~~~~~~~~~~~~ LEDGER ~~~~~~~~~~~~~~~~~~");
            try{Thread.sleep(500);} catch (InterruptedException e) {throw new RuntimeException(e);}

            System.out.println("""
                    Please select what entries you would like to view:
                     A) All
                     D) Deposits
                     P) Payments
                     R) Reports
                     H) Return to Home""");
            System.out.print("\n>>");
            menuChoice = read.nextLine();

            switch (menuChoice.toLowerCase()) {
                case "a"://display all
                    LedgerFunctions.displayLedger("all");
                    break;
                case "d"://only deposits
                    LedgerFunctions.displayLedger("deposit");
                    break;
                case "p"://only payments
                    LedgerFunctions.displayLedger("payment");
                    break;
                case "r"://reports menu
                    reportsMenu();
                    break;
                case "h"://go home
                    break ledgerMenuLoop;
                default:
                    System.out.println("Invalid option, Please try again");
                    break;
            }
        }
    }

    public static void reportsMenu(){
        reportsMenuLoop:
        while(true) {
            System.out.println("~~~~~~~~~~~~~~~ REPORTS ~~~~~~~~~~~~~~~~~~");
            try{Thread.sleep(500);} catch (InterruptedException e) {throw new RuntimeException(e);}

            System.out.println("""
                    Generate a report with the following filter:
                     1) Month to Date
                     2) Previous Month
                     3) Year to Date
                     4) Previous Year
                     5) Search by Vendor
                     0) Back to Ledger Menu
                    """);
            System.out.print("\n>>");
            menuChoice = read.nextLine();

            switch (menuChoice.toLowerCase()) {
                case "1":
                    LedgerFunctions.displayLedger("currMonth");
                    break;
                case "2":
                    LedgerFunctions.displayLedger("prevMonth");
                    break;
                case "3":
                    LedgerFunctions.displayLedger("currYear");
                    break;
                case "4":
                    LedgerFunctions.displayLedger("prevYear");
                    break;
                case "5":
                    LedgerFunctions.displayLedger("vendor");
                    break;
                //case "6":
                    //LedgerFunctions.customSearch();
                    //break;
                case "0":
                    break reportsMenuLoop;
                default:
                    System.out.println("Invalid option, Please try again");
                    break;
            }
        }
    }

    public static void otherMenu(){
        System.out.println("~~~~~~~~~~~~ ADDITIONAL OPTIONS ~~~~~~~~~~~~~");
        try{Thread.sleep(500);} catch (InterruptedException e) {throw new RuntimeException(e);}

        System.out.println("Please select what you would like to do:\n" +
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
