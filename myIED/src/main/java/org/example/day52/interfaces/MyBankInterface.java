package org.example.day52.interfaces;

import org.example.day52.objects.BankAccount;

public interface MyBankInterface {
    public void withdraw(double amount);
    public void deposit(double amount);
    public void transfer(BankAccount a, double amount);
}
