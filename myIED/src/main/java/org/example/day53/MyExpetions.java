package org.example.day53;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyExpetions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter an integer: ");
            int divisor = scanner.nextInt();

            // This line can throw an ArithmeticException if divisor is 0
            int result = 100 / divisor;
            System.out.println("Result: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a valid integer.");
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        } catch (Exception e) {
            System.out.println("Error: An unexpected error occurred: " + e.getMessage());
        } finally {
            // This block will always execute
            System.out.println("Execution of the try-catch block is complete.");
            scanner.close(); // Closing the scanner
        }
    }
}
