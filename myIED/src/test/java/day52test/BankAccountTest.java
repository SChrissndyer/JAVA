package day52test;

import org.example.day52.enums.BankAccountType;
import org.example.day52.objects.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    private BankAccount savingsAccount;
    private BankAccount checkingAccount;

    @BeforeEach
    public void setUp() {
        savingsAccount = new BankAccount("12345", BankAccountType.SAVINGS);
        checkingAccount = new BankAccount("67890", BankAccountType.CHECKING);
    }

    @Test
    public void testDeposit() {
        savingsAccount.deposit(100);
        assertEquals(100, savingsAccount.getBalance(), "Balance should be 100 after depositing 100");

        savingsAccount.deposit(-50);
        assertEquals(100, savingsAccount.getBalance(), "Balance should remain 100 after attempting to deposit a negative amount");
    }

    @Test
    public void testWithdraw() {
        savingsAccount.deposit(200);
        savingsAccount.withdraw(50);
        assertEquals(150, savingsAccount.getBalance(), "Balance should be 150 after withdrawing 50");

        savingsAccount.withdraw(300);
        assertEquals(150, savingsAccount.getBalance(), "Balance should remain 150 after attempting to withdraw more than available");
    }

    @Test
    public void testTransferSuccess() {
        savingsAccount.deposit(300);
        savingsAccount.transfer(checkingAccount, 100);
        assertEquals(200, savingsAccount.getBalance(), "Balance should be 200 after transferring 100");
        assertEquals(100, checkingAccount.getBalance(), "Balance should be 100 after receiving 100");

      }
    @Test
    public void testTransferOverAmount(){
        savingsAccount.deposit(300);
        savingsAccount.transfer(checkingAccount, 400);
        assertEquals(300, savingsAccount.getBalance(), "Balance should remain 200 after attempting to transfer more than available");
        assertEquals(0, checkingAccount.getBalance(), "Balance should remain 100 after failed transfer");

    }
}
