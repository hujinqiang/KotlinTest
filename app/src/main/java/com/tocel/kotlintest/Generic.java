package com.tocel.kotlintest;

import java.util.ArrayList;
import java.util.List;

public class Generic {
    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        List<Object> objects = new ArrayList<>();
        objects.add(1);
        String s = strs.get(0);
        System.out.println(s);
    }
}
