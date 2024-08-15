package day52test;


import org.example.day52.controler.AccountManager;
import org.example.day52.objects.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class AccountManagerTest {
    private AccountManager<BankAccount> manager;
    private ByteArrayOutputStream outContent;
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

    }

    @Test
    public void testCreateAccount() {
        String input = "1\n12345\n1\n6\n"; // create account, then exit
        simulateUserInput(input);
        manager = new AccountManager<>(new Scanner(System.in));
        manager.run();
        String output = outContent.toString();

        assertTrue(output.contains("Account created successfully"), "Output should confirm account creation.");
    }

    @Test
    public void testDepositAndWithdraw() {
        String input = "1\n12345\n1\n3\n12345\n100\n4\n12345\n50\n6\n";
        simulateUserInput(input);
        manager = new AccountManager<>(new Scanner(System.in));
        manager.run();
        String output = outContent.toString();

        assertTrue(output.contains("Deposited 100.0"), "Output should confirm deposit.");
        assertTrue(output.contains("Withdrew 50.0"), "Output should confirm withdrawal.");
    }

    @Test
    public void testTransfer() {
        String input = "1\n12345\n1\n3\n12345\n100\n1\n67890\n2\n5\n12345\n67890\n50\n6\n";
        simulateUserInput(input);
        manager = new AccountManager<>(new Scanner(System.in));
        manager.run();
        String output = outContent.toString();

        assertTrue(output.contains("Transferred 50.0 to account 67890"), "Output should confirm transfer.");
    }

    private void simulateUserInput(String input) {
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
    }
}
