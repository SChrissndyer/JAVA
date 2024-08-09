package org.example.day59;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterDemo {

    public static void main(String[] args) {
        // Specify the source and destination files
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        // Use try-with-resources to ensure streams are closed after use
        try (FileReader reader = new FileReader(inputFile);
             FileWriter writer = new FileWriter(outputFile)) {

            // Buffer to hold characters read from the file
            char[] buffer = new char[1024];
            int charsRead;

            // Read the input file and write to the output file
            while ((charsRead = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, charsRead);
            }

            System.out.println("File copied successfully using FileReader/FileWriter!");

        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
