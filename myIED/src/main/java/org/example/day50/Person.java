package org.example.day50;

import java.util.Objects;

public class Person {
    // encapsulation and polymorphism
    private String name;
    private String phoneNumber;

    public Person(String name, String phoneNumber) { //polymorphism
        this.name = name;
        this.phoneNumber=phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(phoneNumber, person.phoneNumber);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber);
    }

    public Person(String name) { //polymorphism
        this.name = name;
        this.phoneNumber="No Number";
    }

    public String getName() { //encapsulation
        return name;
    }
    public void yell(){
        System.out.println("Hi my name is "+this.name);
    }

    public void setName(String name) {// encapsulation
        this.name = name;
    }

    public String getPhoneNumber() { //encapsulation
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) { //encapsulation
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + this.name + '\'' +
                ", phoneNumber='" + this.phoneNumber + '\'' +
                '}';
    }
}
