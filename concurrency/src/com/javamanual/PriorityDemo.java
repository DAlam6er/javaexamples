package com.javamanual;

class Clicker implements Runnable
{
    Thread self;
    private volatile boolean running = true;
    long click = 0;

    public Clicker(int p)
    {
        self = new Thread(this);
        self.setPriority(p);
    }

    @Override
    public void run()
    {
        while (running) {
            click++;
        }
    }

    public void stop()
    {
        running = false;
    }

    public void start()
    {
        self.start();
    }
}

public class PriorityDemo
{
    public static void main(String[] args)
    {
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        Clicker hi = new Clicker(Thread.NORM_PRIORITY + 2);
        Clicker lo = new Clicker(Thread.NORM_PRIORITY - 2);
        lo.start();
        hi.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        lo.stop();
        hi.stop();

        try {
            hi.self.join();
            lo.self.join();
        } catch (InterruptedException e) {
            System.out.println("Caught InterruptedException.");
        }
        System.out.println("Low priority thread: " + lo.click);
        System.out.println("High priority thread: " + hi.click);
    }
}
