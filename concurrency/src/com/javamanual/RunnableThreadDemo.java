package com.javamanual;

class NewThread implements Runnable
{
    Thread self;
    NewThread()
    {
        self = new Thread(this, "Demo Thread");
        System.out.println("Child thread " + self + " was created");
        self.start();
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
public class RunnableThreadDemo
{
    public static void main(String[] args)
    {
        new NewThread();
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Main Thread: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main Thread interrupted.");
        }
        System.out.println("Main Thread stopped.");
    }
}
