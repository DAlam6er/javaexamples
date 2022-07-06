package com.javamanual;

class NewThread3 implements Runnable
{
    String name;
    Thread self;

    NewThread3(String threadName)
    {
        name = threadName;
        self = new Thread(this, name);
        System.out.println("New thread: " + self);
        self.start();
    }

    @Override
    public void run()
    {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted.");
        }
        System.out.println(name + " stopped.");
    }
}

public class MultiThreadDemo
{
    public static void main(String[] args)
    {
        new NewThread3("One");
        new NewThread3("Two");
        new NewThread3("Three");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Main thread stopped.");
    }
}
