package org.example.day59;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputOutputStreamDemo {

    public static void main(String[] args) {
        // Specify the file to write to and read from
        String dataFile = "data.bin";

        // Writing data to a binary file using DataOutputStream
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(dataFile))) {
            // Writing different types of data
            dataOutputStream.writeInt(123);
            dataOutputStream.writeDouble(45.67);
            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeUTF("Hello, Data Streams!");

            System.out.println("Data written to the file successfully!");

        } catch (IOException e) {
            System.err.println("An error occurred while writing data: " + e.getMessage());
        }

        // Reading data from the binary file using DataInputStream
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(dataFile))) {
            // Reading the data in the same order it was written
            int intValue = dataInputStream.readInt();
            double doubleValue = dataInputStream.readDouble();
            boolean boolValue = dataInputStream.readBoolean();
            String utfString = dataInputStream.readUTF();

            // Output the data read from the file
            System.out.println("Data read from the file:");
            System.out.println("Integer: " + intValue);
            System.out.println("Double: " + doubleValue);
            System.out.println("Boolean: " + boolValue);
            System.out.println("String: " + utfString);

        } catch (IOException e) {
            System.err.println("An error occurred while reading data: " + e.getMessage());
        }
    }
}
