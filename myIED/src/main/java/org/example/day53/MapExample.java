package org.example.day53;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MapExample {
    public static void main(String[] args) {
        // Using HashMap
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "One");
        hashMap.put(2, "Two");
        hashMap.put(3, "Three");

        System.out.println("HashMap: " + hashMap);

        // Using LinkedHashMap
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, "One");
        linkedHashMap.put(2, "Two");
        linkedHashMap.put(3, "Three");

        System.out.println("LinkedHashMap: " + linkedHashMap);

        // Using TreeMap
        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "One");
        treeMap.put(2, "Two");
        treeMap.put(3, "Three");

        System.out.println("TreeMap: " + treeMap);

        // Using WeakHashMap
        Map<Integer, String> weakHashMap = new WeakHashMap<>();
        weakHashMap.put(1, "One");
        weakHashMap.put(2, "Two");
        System.out.println("WeakHashMap: " + weakHashMap); // Output: {1=One, 2=Two}

        // Using ConcurrentHashMap
        Map<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(1, "One");
        concurrentHashMap.put(2, "Two");
        System.out.println("ConcurrentHashMap: " + concurrentHashMap); // Output: {1=One, 2=Two}
    }
}
