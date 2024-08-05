package org.example.day53;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        // Using LinkedList as a Queue
        Queue<String> linkedListQueue = new LinkedList<>();
        linkedListQueue.add("First");
        linkedListQueue.add("Second");
        linkedListQueue.add("Third");

        System.out.println("LinkedList Queue: " + linkedListQueue);

        // Using PriorityQueue
        Queue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.add("First");
        priorityQueue.add("Second");
        priorityQueue.add("Third");

        System.out.println("PriorityQueue: " + priorityQueue);

        // Using ArrayDeque
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.add("One");
        arrayDeque.add("Two");
        arrayDeque.addFirst("Zero");
        System.out.println("ArrayDeque: " + arrayDeque); // Output: [Zero, One, Two]
    }
}

