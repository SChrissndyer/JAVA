package org.example.day49;

public class Cat extends Animal{
    private String name;
    public Cat(String name){
        this.name= name;
    }


    public void animalSound() {
        System.out.println("MEOW");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
