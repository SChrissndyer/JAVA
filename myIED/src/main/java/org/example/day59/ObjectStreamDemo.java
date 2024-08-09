package org.example.day59;

import org.example.day59.pojo.Person;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class ObjectStreamDemo {

    public static void main(String[] args) {
        // Specify the file to write to and read from
        String objectFile = "src/main/java/org/example/day59/objectData.bin";

        // Creating an object to serialize
        Person person = new Person("John Doe", 30);

        // Writing the object to a file using ObjectOutputStream
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(objectFile))) {
            objectOutputStream.writeObject(person);
            System.out.println("Object written to file successfully!");

        } catch (IOException e) {
            System.err.println("An error occurred while writing the object: " + e.getMessage());
        }

        // Reading the object from the file using ObjectInputStream
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(objectFile))) {
            Person readPerson = (Person) objectInputStream.readObject();
            System.out.println("Object read from file:");
            System.out.println("Name: " + readPerson.getName());
            System.out.println("Age: " + readPerson.getAge());

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("An error occurred while reading the object: " + e.getMessage());
        }
    }
}



