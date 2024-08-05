package org.example.day57;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {

    public static void main(String[] args){
        RegexExample();
        EmailValidation();
        ExtractNumbers();
        ReplaceMultiplePatterns();
        PhoneNumberFormatting();

    }
    public static void RegexExample () {
        // Define the input string
        String input = "The quick brown dog jumps over the lazy dog.";

        // Define the regex pattern to find the word "dog"
        String regex = "\\bdog\\b";  // The \\b ensures that we match the whole word "dog"

        // Create a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Create a Matcher object
        Matcher matcher = pattern.matcher(input);

        // Define the replacement string
        String replacement = "cat";

        // Replace all occurrences of the word "dog" with "cat"
        String result = matcher.replaceAll(replacement);

        // Print the original and the result strings
        System.out.println("Original String: " + input);
        System.out.println("Modified String: " + result);
    }

        public static void EmailValidation() {
            // Define some test email addresses
            String[] emails = {"user@example.com", "user.example@domain", "user.name@domain.co.in", "user@domaincom"};

            // Define the regex pattern for email validation
            String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

            // Create a Pattern object
            Pattern pattern = Pattern.compile(emailRegex);

            // Validate each email address
            for (String email : emails) {
                Matcher matcher = pattern.matcher(email);
                System.out.println(email + " : " + matcher.matches());
            }
        }

        public static void ExtractNumbers() {
            // Define the input string
            String input = "There are 123 apples, 45 bananas, and 678 oranges.";

            // Define the regex pattern to find numbers
            String numberRegex = "\\d+";

            // Create a Pattern object
            Pattern pattern = Pattern.compile(numberRegex);

            // Create a Matcher object
            Matcher matcher = pattern.matcher(input);

            // Find and print all numbers
            while (matcher.find()) {
                System.out.println("Found number: " + matcher.group());
            }
        }

    public static void ReplaceMultiplePatterns () {
        // Define the input string
        String input = "Hello123, welcome to Java456!";

        // Define the regex pattern to find all digits
        String digitRegex = "\\d";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(digitRegex);

        // Create a Matcher object
        Matcher matcher = pattern.matcher(input);

        // Replace all digits with an asterisk
        String result = matcher.replaceAll("*");

        // Print the modified string
        System.out.println("Modified String: " + result);
    }

    public static void PhoneNumberFormatting () {
        // Define the input phone number
        String input = "1234567890";

        // Define the regex pattern to format the phone number
        String phoneRegex = "(\\d{3})(\\d{3})(\\d{4})";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(phoneRegex);

        // Create a Matcher object
        Matcher matcher = pattern.matcher(input);

        // Define the replacement pattern
        String replacement = "($1) $2-$3";

        // Format the phone number
        String result = matcher.replaceAll(replacement);

        // Print the formatted phone number
        System.out.println("Formatted Phone Number: " + result);
    }

}

