package com.javamanual;

class NewThread2 extends Thread{
    NewThread2()
    {
        super("Demo Thread"); // calls public Thread(String threadName)
        System.out.println("Child Thread: " + this);
        start();
    }

    @Override
    public void run()
    {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Child thread: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Child thread interrupted.");
        }
        System.out.println("Child thread stopped.");
    }
}

public class ThreadExtendingDemo
{
    public static void main(String[] args)
    {
        new NewThread2();
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Main thread: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main Thread interrupted");
        }
        System.out.println("Main Thread stopped.");
    }
}
