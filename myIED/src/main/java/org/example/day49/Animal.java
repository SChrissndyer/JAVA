package org.example.day49;

abstract class Animal {
    // Abstract method (does not have a body)
    private String name;

    public abstract void animalSound();
    // Regular method
    public void sleep() {
        System.out.println("Zzz");
    }
}

