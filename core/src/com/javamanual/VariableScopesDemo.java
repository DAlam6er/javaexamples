package com.javamanual;

public class VariableScopesDemo
{
    private int counter = 10;
    private static int counter2 = 15;

    public static void main(String[] args)
    {
        int counter = 5;
        System.out.println(counter);
        VariableScopesDemo test = new VariableScopesDemo();
        System.out.println(test.counter);
        System.out.println(counter2);
        System.out.println("--------");
        double d = 5;
        System.out.println(d);
    }
}
