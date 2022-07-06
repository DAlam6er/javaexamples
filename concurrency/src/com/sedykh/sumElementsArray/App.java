package com.sedykh.sumElementsArray;

import java.util.Random;

public class App
{
    public static void main(String[] args) throws InterruptedException
    {
        int i;
        GlobalData.array = new int[GlobalData.ARRAY_SIZE];
        Random rnd = new Random();
        for (i = 0; i < GlobalData.ARRAY_SIZE; i++) {
            GlobalData.array[i] = rnd.nextInt(10);
        }

        GlobalData.results = new long[GlobalData.THREADS_COUNT];
        for (i = 0; i < GlobalData.THREADS_COUNT; i++) {
            GlobalData.results[i] = 0;
        }

        SumThread[] threads = new SumThread[GlobalData.THREADS_COUNT];
        for (i = 0; i < GlobalData.THREADS_COUNT; i++) {
            // создаем элемент массива - поток
            threads[i] = new SumThread(i);
        }

        long sum1 = 0;
        long t1 = System.currentTimeMillis();
        for (i = 0; i < GlobalData.ARRAY_SIZE; i++) {
            sum1 += GlobalData.array[i];
        }
        long t2 = System.currentTimeMillis();

        long sum2 = 0;
        long t3 = System.currentTimeMillis();
        for (i = 0; i < GlobalData.THREADS_COUNT; i++) {
            threads[i].start();
        }
        for (i = 0; i < GlobalData.THREADS_COUNT; i++) {
            threads[i].join();
        }
        for (i = 0; i < GlobalData.THREADS_COUNT; i++) {
            sum2 += GlobalData.results[i];
        }
        long t4 = System.currentTimeMillis();

        System.out.println("sum1 = " + sum1 + ", working time: " + (t2-t1));
        System.out.println("sum2 = " + sum2 + ", working time: " + (t4-t3));
    }
}
