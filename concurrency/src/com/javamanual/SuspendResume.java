package com.javamanual;

class MyThread implements Runnable
{
    String name;
    Thread self;
    volatile boolean suspendFlag;

    MyThread(String threadName)
    {
        name = threadName;
        self = new Thread(this, name);
        System.out.println("New thread: " + self);
        suspendFlag = false;
        self.start();
    }

    @Override
    public void run()
    {
        try {
            for (int i = 15; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(200);
                synchronized (this) {
                    while (suspendFlag) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted.");
        }
        System.out.println(name + " terminated.");
    }

    void mySuspend()
    {
        suspendFlag = true;
    }

    synchronized void myResume()
    {
        suspendFlag = false;
        notify();
    }
}

public class SuspendResume
{
    public static void main(String[] args)
    {
        MyThread ob1 = new MyThread("One");
        MyThread ob2 = new MyThread("Two");
        try {
            Thread.sleep(1000);
            ob1.mySuspend();
            System.out.println("Suspending thread One");
            Thread.sleep(1000);
            ob1.myResume();
            System.out.println("Resuming thread One");
            ob2.mySuspend();
            System.out.println("Suspending thread Two");
            Thread.sleep(1000);
            ob2.myResume();
            System.out.println("Resuming thread Two");
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        try {
            System.out.println("Waiting for threads to be terminated.");
            ob1.self.join();
            ob2.self.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Main thread terminated.");
    }
}
