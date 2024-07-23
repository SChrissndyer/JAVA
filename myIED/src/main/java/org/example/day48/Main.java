package org.example.day48;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // this will print the location in memory the pointer
        int[] unList = new int[4];
        System.out.println(unList);
        int[] intList={1,2,3,4};
        System.out.println(intList);
        String[] stringList={"a","B","C"};
        //how to use the Arrays method forEach to print
        Arrays.asList(stringList).forEach(System.out::println);
        System.out.println(" ");
        doArrayNoType();
        doArrayType();

        System.out.println("5+5 = "+add(5,5));
        System.out.println("5*5 = "+multiply(5,5));
        System.out.println("5/10 = "+divide(5,10));
    }

    public static void doArrayNoType(){
        //non typed
        ArrayList lists= new ArrayList<>();
        lists.add('a');
        lists.add("b");
        lists.add(true);
        lists.add(14);
        lists.add(15L);
        for (int i =0; i<lists.size();i++){
            System.out.println(lists.get(i));
        }
        System.out.println(" ");
    }
    public static void doArrayType(){
        //typed
        ArrayList<Integer> number= new ArrayList<>();
        number.add(11);
        number.add(12);
        number.add(13);
        number.add(14);
        number.add(15);
        for (Integer num :number){
            System.out.println(num);
        }
        System.out.println(" ");
    }

    public static int add(int a, int b){
        return a+b;
    }
    public static int multiply(int a, int b){
        return a*b;
    }
    public static double divide (int a,int b){
        return (double) a /b;
    }
}