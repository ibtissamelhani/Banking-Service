package org.ibtissam;

import org.ibtissam.exception.InsufficientFundsException;
import org.ibtissam.exception.InvalidAmountException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Account {
    private ArrayList<Transaction> transactions;
    private int balance;

    public Account() {
        this.transactions = new ArrayList<>();
        this.balance = 0;
    }

    public void deposit(int amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be positive. Provided: " + amount);
        }

        this.balance += amount;
        Transaction transaction = new Transaction(LocalDate.now().toString(), amount, this.balance);
        transactions.add(transaction);
    }


    public void withdraw(int amount) throws InvalidAmountException, InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be positive.");
        }

        if (amount > this.balance) {
            throw new InsufficientFundsException("Insufficient funds.");
        }

        this.balance -= amount;
        Transaction transaction = new Transaction(LocalDate.now().toString(), -amount, this.balance);
        transactions.add(transaction);
    }

    public void printStatement() {
        System.out.println("Date || Amount || Balance");

        ArrayList<Transaction> reversedTransactions = new ArrayList<>(transactions);
        Collections.reverse(reversedTransactions);

        for (Transaction transaction : reversedTransactions) {
            System.out.println(transaction);
        }
    }
}
