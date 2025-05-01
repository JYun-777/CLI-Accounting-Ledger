package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private LocalDate date;
    private LocalTime time;
    private String fmtTime;
    private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss");
    private String description;
    private String vendor;
    private float price;

    public Transaction() {
        //auto grab timestamp
        setDate();
        setTime();
    }

    public Transaction(LocalDate _date, LocalTime _time, String _description, String _vendor, Float _price){
        this.date = _date;
        this.time = _time;
        this.description = _description;
        this.vendor = _vendor;
        this.price = _price;
    }


    //Display Individual Transaction
    //Show 
    public String displayTransaction(){

    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate() {
        this.date = LocalDate.now();
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime() {
        this.time = LocalTime.now();
        this.fmtTime = time.format(timeFormatter);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
