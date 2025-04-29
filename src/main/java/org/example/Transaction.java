package org.example;

import java.time.LocalDate;
import java.time.LocalTime;

java.time.LocalDate;
java.time.LocalTime;

public class Transaction {

    private LocalDate date;
    private LocalTime time;
    private String productName;
    private String vendor;
    private float price;

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
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
