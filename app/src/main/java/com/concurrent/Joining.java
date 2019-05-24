package com.concurrent;

import com.thinking.java.PrintUtilKt;

class Sleeper extends Thread{
    private int duration;
    public Sleeper(String name ,int sleepTime){
        super(name);
        duration = sleepTime;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(duration);
        }catch (InterruptedException e){
            PrintUtilKt.printS(getName() + " was interrupted." + "isInterrupted():" + isInterrupted());
            return;
        }

        PrintUtilKt.printS(getName() + " has awakened");
    }
}

class Joiner extends Thread{
    private Sleeper sleeper;
    public Joiner(String name ,Sleeper sleeper){
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            PrintUtilKt.printS("Interrupted");
        }

        PrintUtilKt.printS(getName() + " join completed");
    }
}


public class Joining {

    public static void main(String[] args) {
        Sleeper sleepy = new Sleeper("Sleepy",1500),
                grumpy = new Sleeper("Grumpy",1500);

        Joiner dopey = new Joiner("Dopey",sleepy),
                doc = new Joiner("Doc",grumpy);

        grumpy.interrupt();
    }
}
