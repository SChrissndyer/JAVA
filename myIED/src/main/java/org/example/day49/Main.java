package org.example.day49;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Person billy= new Person("billy");
        Person billy2= new Person("billy","222-333-4444");
        billy.yell();
        System.out.println(billy.getPhoneNumber());
        System.out.println();
        System.out.println(billy2.getPhoneNumber());
        ArrayList<String> list = new ArrayList<>();
        list.add("Math");
        Student bob= new Student("bob","86753099",1,list);
        System.out.println();
        bob.yell();
        System.out.println();
       // Abstract
        Pig myPig = new Pig("nill"); // Create a Pig object
        myPig.animalSound();
        Cat myCat= new Cat("vex");
        myPig.sleep();
        myCat.animalSound();


    }
}