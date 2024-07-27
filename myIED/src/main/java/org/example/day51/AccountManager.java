package org.example.day51;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountManager<T extends BankAccount> {
    private List<T> accounts = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        boolean exit = false;

        while (!exit) {
            printMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    viewAccounts();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    withdraw();
                    break;
                case 5:
                    transfer();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n--- Bank Account Manager ---");
        System.out.println("1. Create Account");
        System.out.println("2. View All Accounts");
        System.out.println("3. Deposit");
        System.out.println("4. Withdraw");
        System.out.println("5. Transfer");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private int getChoice() {
        return Integer.parseInt(scanner.nextLine());
    }

    private void createAccount() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        BankAccountType accountType = chooseAccountType();

        T newAccount = (T) new BankAccount(accountNumber, accountType);
        accounts.add(newAccount);

        System.out.println("Account created successfully: " + newAccount);
    }

    private BankAccountType chooseAccountType() {
        while (true) {
            System.out.println("Choose account type:");
            System.out.println("1. Savings");
            System.out.println("2. Checking");
            System.out.println("3. Business");
            System.out.print("Enter your choice: ");

            int typeChoice = Integer.parseInt(scanner.nextLine());

            switch (typeChoice) {
                case 1:
                    return BankAccountType.SAVINGS;
                case 2:
                    return BankAccountType.CHECKING;
                case 3:
                    return BankAccountType.BUSINESS;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void viewAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            System.out.println("\n--- List of Bank Accounts ---");
            for (T account : accounts) {
                System.out.println(account);
            }
        }
    }

    private void deposit() {
        T account = findAccount();
        if (account != null) {
            System.out.print("Enter amount to deposit: ");
            double amount = Double.parseDouble(scanner.nextLine());
            account.deposit(amount);
        }
    }

    private void withdraw() {
        T account = findAccount();
        if (account != null) {
            System.out.print("Enter amount to withdraw: ");
            double amount = Double.parseDouble(scanner.nextLine());
            account.withdraw(amount);
        }
    }

    private void transfer() {
        System.out.println("Enter the account number to transfer from:");
        T fromAccount = findAccount();
        if (fromAccount != null) {
            System.out.println("Enter the account number to transfer to:");
            T toAccount = findAccount();
            if (toAccount != null) {
                System.out.print("Enter amount to transfer: ");
                double amount = Double.parseDouble(scanner.nextLine());
                fromAccount.transfer(toAccount, amount);
            }
        }
    }

    private T findAccount() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        for (T account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }

        System.out.println("Account not found.");
        return null;
    }
}
