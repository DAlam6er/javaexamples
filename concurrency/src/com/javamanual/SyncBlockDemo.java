package com.javamanual;

class CallMeSync2
{
    void call(String msg)
    {
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted.");
        }
        System.out.println("]");
    }
}

class Caller3 implements Runnable
{
    String msg;
    final CallMeSync2 target;
    Thread self;

    public Caller3(CallMeSync2 targ, String s)
    {
        target = targ;
        msg = s;
        self = new Thread(this);
        self.start();
    }

    @Override
    public void run()
    {
        synchronized (target) {
            target.call(msg);
        }
    }
}

public class SyncBlockDemo
{
    public static void main(String[] args)
    {
        CallMeSync2 target = new CallMeSync2();
        Caller3 ob1 = new Caller3(target, "Welcome");
        Caller3 ob2 = new Caller3(target, "to the synchronized");
        Caller3 ob3 = new Caller3(target, "world");

        try {
            ob1.self.join();
            ob2.self.join();
            ob3.self.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted.");
        }
    }
}
