package com.headfirstjava.chap15;

public class ThreadTestDrive
{
    public static void main(String[] args)
    {
        Runnable theJob = new MyRunnable();
        Thread t = new Thread(theJob);
        t.start();
        System.out.println("Возвращаемся в метод main");
    }
}

class MyRunnable implements Runnable
{
    @Override
    public void run()
    {
        go();
    }

    public void go()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        doMore();
    }

    public void doMore()
    {
        System.out.println("На вершине стека");
    }
}
