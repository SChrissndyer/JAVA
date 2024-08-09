package org.example.day59;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderWriterDemo {

    public static void main(String[] args) {
        // Specify the source and destination files
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        // Use try-with-resources to ensure streams are closed after use
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            // Read and write each line of the file
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // Add a newline character after each line
            }

            System.out.println("File copied successfully using BufferedReader/BufferedWriter!");

        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
