package org.example.day47;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter an integer: ");

        int n = Integer.parseInt( in.next());
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
        while (true) {
            try {
                Scanner in = new Scanner(System.in);
                System.out.println("Guess a number ");

                if (Integer.parseInt(in.next()) == 10) {
                    System.out.println("Correct!");
                    break;
                }
                System.out.println("Wrong guess");
            }catch (NumberFormatException exception){
                System.out.println("that was not a number!!!");
            }
        }
    }
}