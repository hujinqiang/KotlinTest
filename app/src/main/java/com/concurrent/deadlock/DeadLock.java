package com.concurrent.deadlock;

public class DeadLock extends Thread{

    protected Object tool;

    static Object fork1 = new Object();
    static Object fork2 = new Object();

    public DeadLock(Object obj){
        this.tool = obj;
        if (tool == fork1){
            setName("Thread A");
        }else if(tool == fork2){
            setName("Thread B");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        DeadLock A = new DeadLock(fork1);
        DeadLock B = new DeadLock(fork2);

        A.start();
        B.start();

        Thread.sleep(1000);
    }


    @Override
    public void run() {
        if(tool == fork1){
            synchronized (fork1){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (fork2){
                    System.out.println("A 开始吃饭了。。。");
                }
            }
        }

        if(tool == fork2){
            synchronized (fork2){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (fork1){
                    System.out.println("B 开始吃饭了。。。");
                }
            }
        }
    }
}
