package com.data_struct;

public class CircularQueue {
    private String[] items;
    private int n = 0;
    private int head,tail;

    public CircularQueue(int capacity){
        items = new String[capacity];
        n = capacity;
    }

    public boolean enqueue(String item){
        if(head == (tail + 1) % n){
            System.out.println("队列已经满了...");
            return false;
        }

        items[tail] = item;

        tail = (tail+1) % n;
        return true;
    }

    public String dequeue(){
        if(head == tail){
            System.out.println("队列空了...");
            return null;
        }

        String ret = items[head];

        head = (head + 1) % n;

        return ret;

    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);
        for (int i = 0;i<6;i++){
            String item = "item:" + i;
            if(queue.enqueue(item))
                System.out.println("放入：" + item);

        }

        for (int i = 0;i<6;i++){
            System.out.println("取出：" + queue.dequeue());
        }
    }

}
