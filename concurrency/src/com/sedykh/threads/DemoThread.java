package com.sedykh.threads;

public class DemoThread extends Thread
{
    @Override
    public void run()
    {
        // Так писать правильно
        System.out.println("Hello from " + Thread.currentThread().getName());
        // Напрямую пользоваться методами Thread нельзя!
        // Потому что так мы получим то, что задано в объекте,
        // А не те реальные данные, с которыми мы работаем
        //System.out.println("Short Hello from " + getName());
    }
}
