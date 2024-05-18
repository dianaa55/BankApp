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

public class Bank {
    private String bankName;
    private List<Account> accounts;
    private double totalTransactionFeeAmount;
    private double totalTransferAmount;
    private double transactionFlatFeeAmount;
    private double transactionPercentFeeValue;

    public Bank(String bankName, double transactionFlatFeeAmount, double transactionPercentFeeValue) {
        this.bankName = bankName;
        this.accounts = new ArrayList<>();
        this.totalTransactionFeeAmount = 0;
        this.totalTransferAmount = 0;
        this.transactionFlatFeeAmount = transactionFlatFeeAmount;
        this.transactionPercentFeeValue = transactionPercentFeeValue;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account getAccountById(int accountId) {
        for (Account account : accounts) {
            if (account.getAccountId() == accountId) {
                return account;
            }
        }
        throw new IllegalArgumentException("Account not found!");
    }

    public void performTransaction(Transaction transaction) {
        Account fromAccount = getAccountById(transaction.getOriginatingAccountId());
        Account toAccount = getAccountById(transaction.getResultingAccountId());

        double amount = transaction.getAmount();

        if (fromAccount.getBalance() < amount) {
            throw new IllegalArgumentException("Not enough funds in the account!");
        }

        double transactionFee = transactionFlatFeeAmount + (amount * transactionPercentFeeValue / 100);
        totalTransactionFeeAmount += transactionFee;
        totalTransferAmount += amount;

        fromAccount.withdraw(amount + transactionFee);
        toAccount.deposit(amount);

        transaction.setTransactionFee(transactionFee);
        fromAccount.addTransaction(transaction);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public double getTotalTransactionFeeAmount() {
        return totalTransactionFeeAmount;
    }

    public double getTotalTransferAmount() {
        return totalTransferAmount;
    }

    public double getTransactionFlatFeeAmount() {
        return transactionFlatFeeAmount;
    }

    public double getTransactionPercentFeeValue() {
        return transactionPercentFeeValue;
    }
}

