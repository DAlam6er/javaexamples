package com.specialist.bodrov.base;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class HelloWorld {
/*
        Block
        Comment
*/

    /**
     * Java-doc comment
     * Main method of the application
     * @param args arguments of this method
     */
    public static void main(String[] args)
    {
        int a = 10;
        float b = (float).5;//.5f;
        b = 1.f / 0; // b = Infinity
        System.out.println("b = " + b);
        if (a < b) System.out.println("OK");

        int myNumber = 9;
        System.out.println(myNumber);

        myNumber = 10;
        System.out.println(myNumber);

        final int MY_CONSTANT = 200;
        System.out.println(MY_CONSTANT);

        boolean myBoolean = true;
        System.out.println(myBoolean);

        char ch = 'Q';
        String myStr = "Hello World!";
        System.out.println(myStr);

        String s = myStr.toUpperCase();
        System.out.println(s);
        System.out.println(myStr.toUpperCase());
        System.out.println("---");

        int i = 1;
        Integer myInt = i;
        int i2 = myInt;

        List<Integer> list = List.of(1,2,3,4);
        System.out.println(list);

        int a1 = 2;

        int numb = (((10 + 10) * a1) / 4) % 3;
        System.out.println(numb);
        System.out.println("---");

        System.out.println(5 / 2);
        System.out.println(5 / 2d);
        System.out.println(5 / 2.0);
        System.out.println(5 / (double)2);

        int i3 = (int)2.5;
        System.out.println(i3);

        int i4 = 10;
        long l = i4;

        l = 300L;
        i4 = (int)l;

        System.out.println(i4);
        System.out.println("---");

        int k = 1;
        k = k + 1;
        System.out.println(k);

        k += 1;
        System.out.println(k);

        System.out.println("---");
        k = 1;
        System.out.println(++k);
        System.out.println(k);

        k = 1;
        System.out.println(k++);
        System.out.println(k);

        int a5 = 1, a6 = 2, a7 = 3;

        int a8 = 1;
        int a9 = 1;

        a7 = 1;
        a6 = 1;
        System.out.println("---");

        System.out.println(1 == 1);
        System.out.println(1 == 2);

        System.out.println(1.1 > 1);
        System.out.println(1.1 <= 2);
        System.out.println(1 != 2);

        Object o1 = new Object();
        Object o2 = new Object();

        System.out.println(o1 == o2);
        Object o3 = o1;

        System.out.println(o1 == o3);
        System.out.println();

        System.out.println(1.0 == 1d);

        System.out.println(123458.3459345);

        BigInteger bi =
            new BigInteger("889235792837235892826872356828935253");
        System.out.println(bi.add(new BigInteger("10")));

        BigDecimal bd =
            new BigDecimal("923482983489234.2349823479234789234");
        System.out.println("---");

        boolean b1 = true;
        boolean b2 = true;
        System.out.println(!true);
        System.out.println(b1 && b2);
        System.out.println(true || false);

        //vbodrov@specialist.ru

    }
}