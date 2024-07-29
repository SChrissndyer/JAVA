package org.example.day52;

import org.example.day52.controler.AccountManager;
import org.example.day52.objects.BankAccount;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
    run();
    }

    public static void run() {

        HashMap<String,Integer> maps= new HashMap<>();
        maps.put("a",1);
        maps.put("b",2);
        maps.put("c",3);
        maps.put("b", 50);
        // object way for
        System.out.println(maps.get("a"));
        for(String currentKey : maps.keySet()){
            System.out.println(currentKey);
        }
        // Lamda way forEach
        maps.forEach((k,v)->System.out.println("Key: " + k + " Value: " + v));

    }



}
