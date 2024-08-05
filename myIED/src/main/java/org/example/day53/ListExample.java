package org.example.day53;
import java.util.*;

public class ListExample {
    public static void main(String[] args) {
        // Using ArrayList
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Cherry");

        System.out.println("ArrayList: " + arrayList);

        // Using LinkedList
        List<String> linkedList = new LinkedList<>();
        linkedList.add("Dog");
        linkedList.add("Cat");
        linkedList.add("Horse");

        System.out.println("LinkedList: " + linkedList);

        // Using Vector
        List<String> vector = new Vector<>();
        vector.add("Red");
        vector.add("Green");
        vector.add("Blue");

        System.out.println("Vector: " + vector); // Output: [Red, Green, Blue]

        // Using Stack
        Stack<String> stack = new Stack<>();
        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        System.out.println("Stack: " + stack); // Output: [First, Second, Third]

        // Stack specific operations
        System.out.println("Stack pop: " + stack.pop()); // Output: Third
        System.out.println("Stack after pop: " + stack); // Output: [First, Second]


    }
}
