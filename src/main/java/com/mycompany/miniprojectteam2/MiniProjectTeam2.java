package com.mycompany.miniprojectteam2;

/**
 *
 * @author Abdelrahman_Zaki
 */

public class MiniProjectTeam2 {

    public static void main(String[] args) {
         BankAccount acc1 = new BankAccount("ACC-101", 500);
        System.out.println("Account: " + acc1.getAccountNumber());
        System.out.println("Starting balance: " + acc1.getBalance());
        
        acc1.deposit(200);
        
        acc1.deposit(100, "Salary");
        
        acc1.withdraw(150);
        
        acc1.withdraw(1000);
        System.out.println("Final balance: " + acc1.getBalance());
    }
}
