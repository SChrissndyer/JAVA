package org.example.day51;

public class BankAccount implements MyBankInterface{
    private String accountNumber;
    private BankAccountType accountType;
    private double balance;

    public BankAccount(String accountNumber, BankAccountType accountType) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = 0.0; // Initialize with zero balance
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BankAccountType getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }


    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Invalid withdraw amount or insufficient funds.");
        }
    }
    @Override
    public void transfer(BankAccount a, double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            a.deposit(amount);
            System.out.println("Transferred " + amount + " to account " + a.getAccountNumber());
        } else {
            System.out.println("Invalid transfer amount or insufficient funds.");
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountType=" + accountType +
                ", balance=" + balance +
                '}';
    }
}
