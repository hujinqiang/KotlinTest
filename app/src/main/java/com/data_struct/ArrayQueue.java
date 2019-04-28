package com.data_struct;

public class ArrayQueue {
    private String[] items;
    private int n = 0;
    private int head,tail;

    public ArrayQueue(int capacity){
        items = new String[capacity];
        n = capacity;
    }

    public boolean enqueue(String item){
        if(tail == n) {
            if(head == 0){
                System.out.println("队列已经满了...");
                return false;
            }
            for (int i = head;i<tail;i++){
                items[i-head] = items[i];
            }
            tail -= head;
            head = 0;
        }
        items[tail++ ] = item;
        return true;
    }

    public String dequeue(){
        if(head == tail){
            System.out.println("队列空了...");
            return null;
        }

        String ret = items[head++];

        return ret;

    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        for (int i = 0;i<6;i++){
            queue.enqueue("item:" + i);
        }

        for (int i = 0;i<6;i++){
            System.out.println(queue.dequeue());
        }
    }

}
