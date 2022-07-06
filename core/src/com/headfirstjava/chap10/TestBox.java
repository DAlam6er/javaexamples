package com.headfirstjava.chap10;

// Проверка автоматической распаковки
public class TestBox
{
    Integer i;
    int j;

    public static void main(String[] args)
    {
        TestBox t = new TestBox();
        t.go();
    }

    public void go()
    {
        // Cannot invoke "java.lang.Integer.intValue()" because "this.i" is null
        // Exception here (runtime error)
        j = i;
        System.out.println(j);
        System.out.println(i);
    }
}
