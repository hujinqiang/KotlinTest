package com.tocel.kotlintest;

public class Demo {
    public static void main(String[] args) {
        System.out.println(); //sout: Prints
        System.out.println("Demo.main"); //soutm: Prints current class and method names to System.out
        System.out.println("args = [" + args + "]"); // soutp: Prints method parameter names and values to System.out
        System.out.println("args = " + args); //soutv: Prints a value to System.out

        int sum = 0;
        for(int i=0;i<=100;i++){
            sum += i;
        }
        System.out.println(sum);

        System.out.println((sum = 5) != 5);
    }

}
