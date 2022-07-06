package com.eduprof.tikhomirov.array;

public class App
{
    public static void main(String[] args)
    {
        int res = 1;
        for (int el : new int[]{2, 3, 4, 5}) {
            res *= el;
        }
        System.out.printf("Product is %d.\n", res);
    }
}
