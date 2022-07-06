package com.specialist.sedykh.patterns.singleton;

public class SingletonDemo
{
    public static void main(String[] args)
    {
        Singleton s1 = Singleton.getInstance();
        System.out.println("s1 = " + s1.getX());

        Singleton s2 = Singleton.getInstance(10);
        System.out.println("s2 = " + s2.getX());

        if (s1 == s2) System.out.println("OK");
    }
}
