package com.javamanual;

public class GenDemo
{
    public static void main(String[] args)
    {
        Generic<Integer> iOb = new Generic<Integer>(88);
        iOb.showType();
        int v = iOb.getOb();
        System.out.println("value: " + v);
        System.out.println();

        Generic<String> strOb = new Generic<String>("p1.Generic test");
        strOb.showType();
        String str = strOb.getOb();
        System.out.println("value: " + str);

        // iOb = strOb; compile error here!
    }
}

class Generic<T>
{
    T ob;
    Generic(T o)
    {
        ob = o;
    }

    T getOb()
    {
        return ob;
    }

    void showType()
    {
        System.out.println("Type of T is " + ob.getClass().getName());
    }
}
