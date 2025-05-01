package org.example;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class LedgerFunctions {

    public static ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
    public static Scanner read = new Scanner(System.in);


    //Display Ledger Entries




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
        clear();
        try{

            FileWriter fw = new FileWriter("transactions.csv",true);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Transaction t : transactionList){
                writeTransactList(t);
            }

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

            String transactString = String.format("\n%s|%s|%s|%s|%f",
                    date, time, description, vendor, price);

            bw.write(transactString);

            bw.close();
        }catch(IOException e){
            System.out.println("Write error");
        }

    }

    //Clear transactions.csv by opening a new filewriter and replace the header
    public static void clear(){
        try{
            FileWriter fw = new FileWriter("transactions.csv");
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Date|Time|Description|Vendor|Amount");

            bw.close();
        }catch(IOException e){
            System.out.println("File write error");
        }
    }

    //Prompts user for details on a Deposit transaction then adds it to transaction list at current timestamp
    public static void addDeposit(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~ Enter Deposit ~~~~~~~~~~~~~~~~~~~~~~~~");
        try{Thread.sleep(1000);} catch (InterruptedException e) {throw new RuntimeException(e);}


        //add new transaction
        Transaction newTransact = new Transaction();

        System.out.print("Enter description of deposit: ");
        newTransact.setDescription(read.nextLine());

        System.out.print("\nEnter username for deposit: ");
        newTransact.setVendor(read.nextLine());

        System.out.print("\nEnter amount of deposit: ");

        //ensure positive
        float depositPrice = read.nextFloat();
        depositPrice = Math.abs(depositPrice);
        newTransact.setPrice(depositPrice);
        read.nextLine();//eat next line


        writeTransactList(newTransact);

        //Print confirmation
        System.out.printf("Recorded deposit of $%.2f by %s for %s on %s at %s.\n",
                newTransact.getPrice(),newTransact.getVendor(), newTransact.getDescription(), newTransact.getDate(), newTransact.getTime());

        try{Thread.sleep(1000);} catch (InterruptedException e) {throw new RuntimeException(e);}

    }

    //Prompts user for details on a Payment transaction then adds it to transaction list at current timestamp
    public static void addPayment() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~ Enter Payment ~~~~~~~~~~~~~~~~~~~~~~~~");
        try{Thread.sleep(1000);} catch (InterruptedException e) {throw new RuntimeException(e);}
 
        //add new transaction
        Transaction newTransact = new Transaction();

        System.out.print("Enter description of payment: ");
        newTransact.setDescription(read.nextLine());

        System.out.print("\nEnter vendor of payment: ");
        newTransact.setVendor(read.nextLine());

        System.out.print("\nEnter amount of payment: ");

        //ensure payment is negative
        float paymentPrice = read.nextFloat();
        paymentPrice = Math.abs(paymentPrice) * -1;
        newTransact.setPrice(paymentPrice);
        read.nextLine();//eat next line

        writeTransactList(newTransact);

        //Print confirmation
        System.out.printf("Recorded payment of $%.2f to %s for %s on %s at %s.\n",
                Math.abs(newTransact.getPrice()),newTransact.getVendor(), newTransact.getDescription(), newTransact.getDate(), newTransact.getTime());

        try{Thread.sleep(1000);} catch (InterruptedException e) {throw new RuntimeException(e);}


    }


}
