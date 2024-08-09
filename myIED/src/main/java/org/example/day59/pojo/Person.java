package org.example.day59.pojo;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L; // Serial version UID for object serialization
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}