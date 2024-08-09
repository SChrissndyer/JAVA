package org.example.day59;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class StreamReaderWriterDemo {

    public static void main(String[] args) {
        // Specify the source and destination files
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        // Use try-with-resources to ensure streams are closed after use
        try (Reader reader = new InputStreamReader(new FileInputStream(inputFile), "UTF-8");
             Writer writer = new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8")) {

            // Buffer to hold characters read from the file
            char[] buffer = new char[1024];
            int charsRead;

            // Read the input file and write to the output file
            while ((charsRead = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, charsRead);
            }

            System.out.println("File copied successfully using StreamReader/Writer!");

        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
