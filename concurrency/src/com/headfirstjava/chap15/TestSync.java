package com.headfirstjava.chap15;

class Sync implements Runnable
{
    private int balance = 0;

    @Override
    public void run()
    {
        for (int i = 0; i < 50; i++) {
            increment();
            System.out.printf("Баланс равен %s(%s)\n",
                balance, Thread.currentThread().getName());
        }
    }

    // Метод - атомарный за счет synchronized. Это позволяет быть
    // уверенным в том, что, начав выполнять метод, поток доведет дело
    // до конца (в виде единого атомарного процесса),
    // прежде чем другой поток сможет работать с этим методом.
    public synchronized void increment()
    {
        int i = balance;
        balance = i + 1;
    }
}

public class TestSync
{
    public static void main(String[] args)
    {
        Sync job = new Sync();
        Thread a = new Thread(job);
        Thread b = new Thread(job);
        a.setName("Thread a");
        b.setName("Thread b");
        a.start();
        b.start();
    }
}
