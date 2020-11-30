package com.keima;

import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static Bank newBank = new Bank("SBI");

    public static void main(String[] args) {

        printOptions();
        boolean condition = true ;
        while (condition) {

            System.out.println("Enter your choice: ");
            int choice = sc.nextInt() ;
            sc.nextLine();
            switch (choice) {

                case 0: condition = false;
                    break;

                case 1: addNewBranch();
                    break;

                case 2: newCustomerInBranch();
                    break;

                case 3: depositAndWithdrawal("credit");
                    break;

                case 4: depositAndWithdrawal("debit");
                    break;

                case 5: customerTransaction() ;
                    break;

                case 6: branchCustomerList() ;
                    break;

                case 7: customerBalance() ;
                    break;

                case 8: financialStatusOfABranch();
                    break;

                default:
                    printOptions();
            }
        }
    }

    public static void addNewBranch() {

        System.out.print("Enter the branch to add: ");
        String branchName = sc.nextLine();
        if(newBank.searchBranch(branchName) >= 0) {

            System.out.println("Branch already exist");
        } else {

            newBank.addNewBranch(branchName);
            System.out.println("new Branch added");
        }
    }

    public static void newCustomerInBranch() {

        System.out.print("Enter the branch name in which you want the customer to add: ");
        String branchName = sc.nextLine();
        int position = newBank.searchBranch(branchName) ;
        if(position >= 0) {

            System.out.print("Enter the customer name: ");
            String customerName = sc.nextLine() ;
            int customerPosition = newBank.getBankBranch().get(position).searchCustomer(customerName);
            if (customerPosition >= 0 ) {

                System.out.println("Customer already exist");
            } else {

                System.out.print("Enter initial deposit to start the account: ");
                double initBalance = sc.nextDouble();
                newBank.getBankBranch().get(position).addCustomer(customerName , initBalance);
                System.out.println("Customer added");
            }

        } else {

            System.out.println("Branch not found");
        }
    }

    public static void depositAndWithdrawal(String validation) {

        System.out.print("Enter the name of the branch: ");
        String branch = sc.nextLine();
        int position = newBank.searchBranch(branch) ;
        if(position >= 0) {

            System.out.print("Enter the customer name: ");
            String customerName = sc.nextLine() ;
            int customerPosition = newBank.getBankBranch().get(position).searchCustomer(customerName);
            if (customerPosition >= 0 ) {

                System.out.print("Enter the amount you want to " + validation.toUpperCase() + ": ");
                double transactionAmount = sc.nextDouble();
                newBank.getBankBranch().get(position).bankTransaction(validation.trim() , transactionAmount , customerPosition) ;
            } else {

                System.out.println("Customer not found ");
            }

        } else {

            System.out.println("Branch not found");
        }
    }

    public static void printOptions() {

        System.out.println("Print 0 to quit ");
        System.out.println("Print 1 to add a branch ");
        System.out.println("Print 2 to add a customer ");
        System.out.println("Print 3 to add to balance for a customer ");
        System.out.println("Print 4 to withdraw from balance ");
        System.out.println("Print 5 to see all transactions of a customer ");
        System.out.println("Print 6 to see the customer list of a branch ");
        System.out.println("Print 7 to see the customer balance a branch ");
        System.out.println("Print 8 to see the financial strength of a branch ");
        System.out.println("And any other number to print the action list");
    }

    public static void customerTransaction() {

        System.out.print("Enter the branch of the customer: ");
        String branch = sc.nextLine();
        int position = newBank.searchBranch(branch) ;
        if(position >= 0) {

            System.out.print("Enter the customer name: ");
            String customerName = sc.nextLine() ;
            int customerPosition = newBank.getBankBranch().get(position).searchCustomer(customerName);
            if (customerPosition >= 0 ) {

                System.out.println("So here is your transaction history: ");
                for (int i = 0 ; i < newBank.getBankBranch().get(position).getCustomerData().get(customerPosition).getTransaction().size() ; i ++) {

                    System.out.println("\t" + newBank.getBankBranch().get(position).getCustomerData().get(customerPosition).getTransaction().get(i));
                }
            } else {

                System.out.println("Customer not found");
            }

        } else {

            System.out.println("Branch not found");
        }
    }

    public static void branchCustomerList() {

        System.out.print("Enter the branch of the customer: ");
        String branch = sc.nextLine();
        int position = newBank.searchBranch(branch) ;
        if(position >= 0) {

            System.out.print("press 1 if you want transaction list along with the names list of customers other wise enter 0 : ");
            int choice = sc.nextInt() ;
            if(choice == 1) {

                System.out.println("The customer of this branch are: ");
                for(int i = 0 ; i < newBank.getBankBranch().get(position).getCustomerData().size() ; i ++ ) {

                    System.out.println("\n" + newBank.getBankBranch().get(position).getCustomerData().get(i).getCustomerName() + "'s transaction details are as follows: ");
                    for (int j = 0 ; j < newBank.getBankBranch().get(position).getCustomerData().get(i).getTransaction().size() ; j ++ ) {

                        System.out.println("\t" + newBank.getBankBranch().get(position).getCustomerData().get(i).getTransaction().get(j));
                    }
                }
            } else {

                System.out.println("The customer of this branch are: ");
                for(int i = 0 ; i < newBank.getBankBranch().get(position).getCustomerData().size() ; i ++ ) {

                    System.out.println("\n" + newBank.getBankBranch().get(position).getCustomerData().get(i).getCustomerName() + "'s transaction details are as follows: ");
                }
            }

        } else {

            System.out.println("Branch not found");
        }
    }

    public static void customerBalance() {

        System.out.print("Enter the branch of the customer: ");
        String branch = sc.nextLine();
        int position = newBank.searchBranch(branch) ;
        if(position >= 0) {

            System.out.print("Enter the customer name: ");
            String customerName = sc.nextLine() ;
            int customerPosition = newBank.getBankBranch().get(position).searchCustomer(customerName);
            if (customerPosition >= 0 ) {

                System.out.println("So the customers current balance is: " + newBank.getBankBranch().get(position).getCustomerData().get(customerPosition).getCustomerBalance());

            } else {
 
                System.out.println("Customer not found");
            }

        } else {

            System.out.println("Branch not found");
        }
    }

    public static void financialStatusOfABranch() {

        System.out.print("Enter the branch of the customer: ");
        String branch = sc.nextLine();
        int position = newBank.searchBranch(branch) ;
        int sum = 0 ;
        if(position >= 0) {

            for (int i = 0 ; i < newBank.getBankBranch().get(position).getCustomerData().size() ; i++ ) {

                sum += newBank.getBankBranch().get(position).getCustomerData().get(i).getCustomerBalance();
            }
            System.out.println("The financial strength of the bank is: Rs" + sum);

        } else {

            System.out.println("Branch not found");
        }
    }

}
