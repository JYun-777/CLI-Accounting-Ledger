package org.example;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class LedgerFunctions {

    public static ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
    public static Scanner read = new Scanner(System.in);


    //Read transaction list
    //Opens transactions.csv and parses each line into a Transaction object, which gets added to transactionList
    public static void readTransactList(){
        try{
            FileReader fr = new FileReader("transactions.csv");
            BufferedReader br = new BufferedReader(fr);

            String dataLine;
            String[] dataFields;

            //skip first line
            br.readLine();

            while((dataLine = br.readLine()) != null) {
                dataFields = dataLine.split("\\|");
                Transaction newTransact = new Transaction(LocalDate.parse(dataFields[0]), LocalTime.parse(dataFields[1]),
                        dataFields[2], dataFields[3], Float.parseFloat(dataFields[4]));
                transactionList.add(newTransact);
            }

        }catch(IOException e){
            System.out.println("transactions.csv File not found.");
        }
    }


    //Write Transact List, to convert the Arraylist into a csv file. If I just make sure to append correctly, I shouldn't need this.
    public static void writeTransactList(){
        try{
            FileWriter fw = new FileWriter("transactions.csv",true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.close();
        }catch(IOException e){
            System.out.println("Write error");
        }
    }

    //writeTransactList 2
    //receives Transaction as argument and converts it into a string to be placed into transactions.csv
    public static void writeTransactList(Transaction _newTransact){

        //add to ArrayList
        transactionList.add(_newTransact);

        //Convert to string then write to transactions.csv
        String date = _newTransact.getDate().toString();
        String time = _newTransact.getTime().toString();
        String description = _newTransact.getDescription();
        String vendor = _newTransact.getVendor();
        Float price = _newTransact.getPrice();

        try{
            FileWriter fw = new FileWriter("transactions.csv",true);
            BufferedWriter bw = new BufferedWriter(fw);

            String transactString = String.format("\n%s\\|%s\\|%s\\|%s\\|%f",
                    date, time, description, vendor, price);

            bw.write(transactString);

            bw.close();
        }catch(IOException e){
            System.out.println("Write error");
        }

    }

    public static void clear(){

    }

    //Prompts user for details on a Deposit transaction then adds it to transaction list at current timestamp
    public static void addDeposit(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~ Enter Deposit ~~~~~~~~~~~~~~~~~~~~~~~~");
        //add new transaction
        Transaction newTransact = new Transaction();

        System.out.print("Enter description of deposit: ");
        newTransact.setDescription(read.nextLine());

        System.out.print("\nEnter username for deposit: ");
        newTransact.setVendor(read.nextLine());

        System.out.print("\nEnter amount of deposit: ");
        newTransact.setPrice(read.nextFloat());

        writeTransactList(newTransact);
    }

    //Prompts user for details on a Payment transaction then adds it to transaction list at current timestamp
    public static void addPayment(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~ Enter Payment ~~~~~~~~~~~~~~~~~~~~~~~~");
        //add new transaction
        Transaction newTransact = new Transaction();

        System.out.print("Enter description of payment: ");
        newTransact.setDescription(read.nextLine());

        System.out.print("\nEnter vendor of payment: ");
        newTransact.setVendor(read.nextLine());

        System.out.print("\nEnter amount of payment: ");
        newTransact.setPrice(read.nextFloat());

        writeTransactList(newTransact);
    }


}
