package com.tocel.kotlintest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

        List<Data> datas = new ArrayList<>();
        datas.add(new Data("a",1));
        datas.add(new Data("b",2));
        datas.add(new Data("b",2));
        datas.add(new Data("a",1));
        datas.add(new Data("a",1));
        datas.add(new Data("b",2));


        List<Data> filter = new ArrayList<>();

        Collections.sort(datas);
        for (Data data:datas){
            int index = Collections.binarySearch(filter,data);
            if( index < 0){
                filter.add(data);
            }
        }

        System.out.println(Arrays.toString(filter.toArray()));

        int i = 10;
        print(i);

        print(i >> 1);
        print(i << 1);

        print(i >>> 1);

    }

    private static void print(int i) {
        System.out.println(Integer.toBinaryString(i));
    }


    static class Data implements Comparable<Data>{
        public Data(String name, int age) {
            this.name = name;
            this.age = age;
        }

        String name;
        int age;

        @Override
        public int compareTo(Data o) {
            return name.compareTo(o.name);
        }

        @Override
        public String toString() {
            return "Data{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }


}
