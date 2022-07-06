package com.javamanual;

class CallMeSync
{
    synchronized void call(String msg)
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

class Caller2 implements Runnable
{
    String msg;
    CallMeSync target;
    Thread self;

    public Caller2(CallMeSync targ, String s)
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

public class SyncMethDemo
{
    public static void main(String[] args)
    {
        CallMeSync target = new CallMeSync();
        Caller2 ob1 = new Caller2(target, "Welcome");
        Caller2 ob2 = new Caller2(target, "to the synchronized");
        Caller2 ob3 = new Caller2(target, "world!");

        try {
            ob1.self.join();
            ob2.self.join();
            ob3.self.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}
