package org.example.day56;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda {

    public static void main(String[] args){
        LambdaExample();
        LambdaRunnableExample();

    }
    public static void LambdaExample () {
        List<String> names = Arrays.asList("Charlie", "Alice", "Bob");

        // Using lambda to sort the list
        names.sort((String a, String b) -> a.compareTo(b));

        System.out.println(names); // Output: [Alice, Bob, Charlie]
    }
    public static void LambdaRunnableExample () {
        // Traditional way
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from a traditional Runnable!");
            }
        };

        // Lambda way
        Runnable r2 = () -> System.out.println("Hello from a lambda Runnable!");

        // Running both runnables
        r1.run();
        r2.run();
    }

    public static void LambdaForEachExample () {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Using lambda to print each name
        names.forEach(name -> System.out.println(name));
    }
    public static void LambdaStreamExample () {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Using lambda to filter even numbers
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(evenNumbers); // Output: [2, 4, 6, 8, 10]
    }

    public static void LambdaMapExample() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Using lambda to convert each name to uppercase
        List<String> upperCaseNames = names.stream()
                .map(name -> name.toUpperCase())
                .collect(Collectors.toList());

        System.out.println(upperCaseNames); // Output: [ALICE, BOB, CHARLIE]
    }

    interface MathOperation {
        int operate(int a, int b);
    }

        public static void LambdaCustomInterfaceExample() {
            // Using lambda to define the operation
            MathOperation addition = (a, b) -> a + b;
            MathOperation multiplication = (a, b) -> a * b;

            // Performing operations
            System.out.println("Addition: " + addition.operate(5, 3)); // Output: 8
            System.out.println("Multiplication: " + multiplication.operate(5, 3)); // Output: 15
        }





}
