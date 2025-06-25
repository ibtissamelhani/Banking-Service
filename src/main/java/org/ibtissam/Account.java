package org.ibtissam;

import org.ibtissam.exception.InvalidAmountException;

import java.time.LocalDate;
import java.util.ArrayList;

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


}
