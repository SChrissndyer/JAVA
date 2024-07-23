package org.example.day50;

import com.sun.source.tree.NewArrayTree;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Person me= null;
        System.out.println(me.toString());
        me= new Person("Chris","123-445-5555");
        System.out.println(me.toString());
        Person per1=new Person("Chris","123-445-5555");
        Person per2=new Person("Bob","888-445-5555");
        Person per3=new Person("Tamara","555-445-5555");
        Person per4=new Person("Anggun","444-445-5555");
        ArrayList<Person> myPeople= new ArrayList<>();
        myPeople.add(per1);
        myPeople.add(per2);
        myPeople.add(per3);
        myPeople.add(per4);

        for( Person  person:myPeople){
            System.out.println(person.toString());
        }

    }
}