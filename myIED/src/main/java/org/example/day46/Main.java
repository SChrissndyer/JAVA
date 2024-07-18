package org.example.day46;

public class Main {
    public static void main(String[] args) {
        int num = 1;
        double dec=1.0;
        String name = "Chris";

        System.out.println("Hello world!");

        int sum = add(num, (int)dec);

    }

    public static int add( int a, int b){
        return (a+b);
    }
}