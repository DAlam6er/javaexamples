package com.specialist.sedykh;

public class IntSum
{
    public static void main(String[] args)
    {
        int a, b, c;
        a = sum(1, 2);
        b = sum(a, 1, 2);
        System.out.println("a = " + a + ", b = " + b );
    }

    private static int sum(int ... a)
    {
        int s = 0;
//        for (int i = 0; i < a.length; i++) {
//            s += a[i];
//        }
        // xi read-only! Use iterator
        for (int xi: a) {
            s += xi;
        }
        return s;
    }

//    private static int sum(int a, int b, int c)
//    {
//        return a + b + c;
//    }
//
//    private static int sum(int a, int b)
//    {
//        return a + b;
//    }
}
