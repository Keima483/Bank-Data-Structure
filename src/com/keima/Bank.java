package com.keima;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Branch> bankBranch = new ArrayList<>() ;
    private String bankName ;

    public Bank(String bankName) {
        this.bankName = bankName;
    }

    public ArrayList<Branch> getBankBranch() {
        return bankBranch;
    }

    public void addNewBranch(String branchName) {

        Branch newBranch = new Branch(branchName);
        bankBranch.add(newBranch);
    }

    public int searchBranch(String name) {

        name = name.toLowerCase();
        int location = -1 ;
        for(int i = 0 ; i < bankBranch.size() ; i ++ ) {

            if (name.equals(bankBranch.get(i).getBranchName().toLowerCase())) {

                return i ;
            }
        }
        return location ;
    }
}
