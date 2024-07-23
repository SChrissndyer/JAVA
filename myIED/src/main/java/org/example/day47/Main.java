package org.example.day47;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter an integer: ");

        int n = in.nextInt();
        System.out.println("you entered " + n);
        if (n % 2 == 0) {
            System.out.println("even");
        }else {
            System.out.println("odd");
        }
        //System.out.println((n % 2 == 0)? "even":"odd");
        for (int i =0 ; i < n ; i++) {
            System.out.println(i);
        }
        runner();
    }
    public static void runner(){
        while (true){
        Scanner in = new Scanner(System.in);
        System.out.println("Do you want to leave? (y/n): ");
        if (in.next().equals("y")){
            break;
        }
        System.out.println("you did not say y");
        }
    }
}