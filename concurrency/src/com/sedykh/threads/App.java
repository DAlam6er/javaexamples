package com.sedykh.threads;

public class App
{
    public static void main(String[] args) throws InterruptedException
    {
        System.out.println("Start of " + Thread.currentThread().getName());

        DemoThread thread = new DemoThread();
        System.out.println("Thread created");
        thread.start();
        // многопоточность имеет смысл, только если здесь(в main) есть код
        // ...
        thread.join(); // блокирующий вызов, ждем пока код в thread завершится

        System.out.println(Thread.currentThread().getName() + " finished");
    }
}
