package com.javamanual;

class CallMe
{
    void call(String msg)
    {
        System.out.print("["+ msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted.");
        }
        System.out.println("]");
    }
}

class Caller implements Runnable
{
    String msg;
    CallMe target;
    Thread self;

    public Caller(CallMe targ, String s)
    {
        target = targ;
        msg = s;
        self = new Thread(this);
        self.start();
    }

    @Override
    public void run()
    {
        target.call(msg);
    }
}

public class RaceNonSyncDemo
{
    public static void main(String[] args)
    {
        CallMe target = new CallMe();
        Caller ob1 = new Caller(target, "Welcome");
        Caller ob2 = new Caller(target, "to the synchronized");
        Caller ob3 = new Caller(target, "world!");

        try {
            ob1.self.join();
            ob2.self.join();
            ob3.self.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}
