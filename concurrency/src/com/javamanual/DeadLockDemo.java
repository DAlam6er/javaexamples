package com.javamanual;

class A
{
    synchronized void foo(B b)
    {
        String name = Thread.currentThread().getName();
        System.out.println(name + " entered in synchronized A.foo");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("A was interrupted.");
        }
        System.out.println(name + " tries to call synchronized B.last()");
        b.last();
    }

    synchronized void last()
    {
        System.out.println("Inside A.last()");
    }
}

class B
{
    synchronized void bar(A a)
    {
        String name = Thread.currentThread().getName();
        System.out.println(name + " entered in synchronized B.bar");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("B was interrupted");
        }
        System.out.println(name + " tries to call synchronized A.last()");
        a.last();
    }

    synchronized void last()
    {
        System.out.println("Inside B.last");
    }
}

class DeadLock implements Runnable
{
    A a = new A();
    B b = new B();

    DeadLock()
    {
        Thread.currentThread().setName("MainThread");
        Thread self = new Thread(this, "RacingThread");
        self.start();
        a.foo(b); // get block inside this thread
        System.out.println("Back into MainThread");
    }

    @Override
    public void run()
    {
        b.bar(a); // get block inside another thread
        System.out.println("Back to another thread");
    }
}

public class DeadLockDemo
{
    public static void main(String[] args)
    {
        new DeadLock();
    }
}
