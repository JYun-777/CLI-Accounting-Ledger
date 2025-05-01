package org.example;



public class Main {


    public static void main(String[] args) {

        LedgerFunctions.readTransactList();
        System.out.println(LedgerFunctions.transactionList);
        Menu.homePage();
    }
}