package com.grokkingalgorithms.chap03;

public class Factorial
{
    public static void main(String[] args)
    {
        System.out.println("5! = " + factor(5));
        System.out.println("4! = " + factor(4));
    }

    static long factor(int x)
    {
        if (x == 1) {
            return 1;
        } else {
            return x * factor(x - 1);
        }
    }
}
