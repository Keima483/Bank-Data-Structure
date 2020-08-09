package com.keima;

import java.util.ArrayList;

public class Branch {

    private ArrayList<Customer> customerData = new ArrayList<>();
    private String branchName ;


    public Branch(String branchName) {

        this.branchName = branchName;
    }

    public ArrayList<Customer> getCustomerData() {
        return customerData;
    }

    public String getBranchName() {
        return branchName;
    }

    public int searchCustomer(String  name) {

        name = name.toLowerCase();
        int position = -1 ;
        for (int i = 0 ; i < customerData.size() ; i++ ) {

            if(name.equals(customerData.get(i).getCustomerName().toLowerCase())) {

                position = i ;
            }
        }
        return position ;
    }

    public void addCustomer(String name , double initialBalance ) {

        Customer customer = new Customer( name , initialBalance ) ;
        customerData.add(customer) ;
        int position = searchCustomer(name) ;
        customerData.get(position).addTransaction(initialBalance) ;
    }


    public void bankTransaction( String validation , double creditOrWithdrawal  , int position ) {


        if(validation.equals("credit")) {

            Customer customer = customerData.get(position);
            customer.addBalance(creditOrWithdrawal);
        } else if (validation.equals("debit")){

            Customer customer = customerData.get(position);
            customer.withdrawFromBalance(creditOrWithdrawal);
        } else {

            System.out.println("Transaction failed");
        }
    }
}
