package com.tocel.kotlintest;

class Base{
    Base(){
        preProcess();
    }

    void preProcess(){
        System.out.println("Base.preProcess");
    }
}

public class Derived extends Base{

    public String whenAmISet = "set when declared";

    @Override
    void preProcess() {
        System.out.println("Derived.preProcess");
        whenAmISet = "set in preProcess()";
    }

    public static void main(String[] args) {
        Derived derived = new Derived();
        System.out.println( derived.whenAmISet );
    }
}
