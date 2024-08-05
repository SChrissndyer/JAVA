package org.example.day53;

import java.util.*;


public class SetExample {
    public static void main(String[] args) {
        // Using HashSet
        Set<String> hashSet = new HashSet<>();
        hashSet.add("One");
        hashSet.add("Two");
        hashSet.add("Three");


        System.out.println("HashSet: " + hashSet);

        // Using LinkedHashSet
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("One");
        linkedHashSet.add("Two");
        linkedHashSet.add("Three");

        System.out.println("LinkedHashSet: " + linkedHashSet);

        // Using TreeSet
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("One");
        treeSet.add("Two");
        treeSet.add("Three");
        System.out.println("TreeSet: " + treeSet);





    }
}
