package com.mycompany.miniprojectteam2;
/**
 *
 * @author Abdelrahman_Zaki
 */
public class BankAccount {
    private String accountNumber;
    private double balance;
    public BankAccount(String accountNumber, double balance) {
    setAccountNumber(accountNumber);
    setBalance(balance);
    }
    public BankAccount(String accountNumber) {
    setAccountNumber(accountNumber);
    this.balance = 0;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
    if (accountNumber == null || accountNumber.trim().isEmpty()) {
        System.out.println("Invalid account number!");
        return;
    }
    this.accountNumber = accountNumber;
    }
    public double getBalance() {
    return balance;
    }
    public void setBalance(double balance) {
    if (balance < 0) {
        System.out.println("Balance cannot be negative!");
        return;
    }
    this.balance = balance;
    }
    public void deposit(double amount) {
    if (amount <= 0) {
        System.out.println("Deposit amount must be greater than 0!");
        return;
    }
    balance += amount;
    System.out.println("Deposited: " + amount
            + " | New balance: " + balance);
}
    public void deposit(double amount, String note) {
    if (amount <= 0) {
        System.out.println("Deposit amount must be greater than 0!");
        return;
    }
    balance += amount;
    System.out.println("Deposited: " + amount
            + " | Note: " + note
            + " | New balance: " + balance);
}
public void withdraw(double amount) {
    if (amount <= 0) {
        System.out.println("Withdraw amount must be greater than 0!");
        return;
    }
    if (amount > balance) {
        System.out.println("Insufficient balance! Current balance: " + balance);
        return;
    }
    balance -= amount;
    System.out.println("Withdrawn: " + amount
            + " | New balance: " + balance);
}
}