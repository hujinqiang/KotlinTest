package com.data_struct.sort;

import java.util.Random;

public class SortTest {

    private static Random random = new Random();

    public static void main(String[] args) {
        int[] arr = generateArray();

        insertSort(arr);

        bubbleSort(generateArray());

    }

    private static int[] generateArray() {
        random.setSeed(System.currentTimeMillis());
        int[] arr = new int[100000];
        for (int i = 0;i<arr.length;i++){
            arr[i] = random.nextInt(100000);
        }
        System.out.println("排序前:");
//        printArray(arr);
        return arr;
    }

    private static void bubbleSort(int[] a) {

        long start = System.currentTimeMillis();

        int len = a.length;
        if(len <= 1)return;

        for(int i = 0;i<len;i++){
            boolean isExchange = false;
            for (int j = 0 ;j<len-i -1;j++){
                if(a[j] > a[j+1]){
                    isExchange = true;
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }

            }
            if(!isExchange){
                System.out.println("i = " + i  + ",no exchange early break");
                break;
            }
        }

        calcCost(start);

        System.out.println("排序后:");
//        printArray(a);

    }

    private static void calcCost(long start) {
        System.out.println("排序耗时:" + (System.currentTimeMillis() - start) /1000f + "秒");
    }

    public static void insertSort(int[] arr){
        long start = System.currentTimeMillis();
        int len = arr.length;
        if(len <= 1)return;

        for (int i = 1;i<len ; i++){
            int value = arr[i];
            int j = i-1;
            for (;j>=0;j--){
                if(arr[j] > value){
                    arr[j+1] = arr[j];
                }else{
                    break;
                }
            }

            arr[j+1] = value;
        }

        calcCost(start);

        System.out.println("排序后:");
        printArray(arr);
    }


    private static void printArray(int[] arr){
        for (int a:arr){
            System.out.print(a + " ");
        }
        System.out.println();
        System.out.println("长度:" + arr.length);
    }
}
