package com.keima;

import java.util.ArrayList;

public class Customer {

    private String customerName ;
    private ArrayList<Double> transaction = new ArrayList<>() ;
    private double customerBalance ;

    public Customer(String customerName, double customerBalance) {

        this.customerName = customerName ;
        this.customerBalance = customerBalance ;
    }

    public String getCustomerName() {
        return customerName;
    }

    public ArrayList<Double> getTransaction() {
        return transaction;
    }

    public double getCustomerBalance() {
        return customerBalance;
    }

    public void addBalance(double trans) {

        this.customerBalance += trans ;
        System.out.println("A balance of Rs " + trans + " is added");
        this.transaction.add(trans);
    }

    public void withdrawFromBalance(double trans) {

        if(this.customerBalance > trans) {

            this.customerBalance -= trans ;
            System.out.println("A balance of Rs " + trans + " is withdrawn");
            this.transaction.add(-1.0 * trans);
        } else {

            System.out.println("not enough balance");
        }
    }

    public void addTransaction(double Transaction ) {

        this.transaction.add(Transaction);
    }
}
