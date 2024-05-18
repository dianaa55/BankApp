/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
package bankproject;

import bankproject.Transaction;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private static int counter = 1;
    private int accountId;
    private String userName;
    private double balance;
    private List<Transaction> transactions;

    public Account(String userName, double balance) {
        this.accountId = counter++;
        this.userName = userName;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance - amount < 0) {
            throw new IllegalArgumentException("Account balance cannot go below zero!");
        }
        balance -= amount;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public int getAccountId() {
        return accountId;
    }

    public String getUserName() {
        return userName;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
