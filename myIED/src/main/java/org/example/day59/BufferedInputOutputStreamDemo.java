package org.example.day59;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferedInputOutputStreamDemo {

    public static void main(String[] args) {
        // Specify the source and destination files
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        // Use try-with-resources to ensure streams are closed after use
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(inputFile));
             BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outputFile))) {

            // Buffer to hold data read from the file
            byte[] buffer = new byte[1024];
            int bytesRead;

            // Read the input file and write to the output file
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("File copied successfully using buffered streams!");

        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
