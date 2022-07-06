package com.javamanual;

public class NonGenDemo
{
    public static void main(String[] args)
    {
        NonGen iOb = new NonGen(88);
        iOb.showType();
        int v = (Integer) iOb.getOb();
        System.out.println("value: " + v);
        System.out.println();

        NonGen strOb = new NonGen("Non-generic test");
        strOb.showType();
        String str = (String) strOb.getOb();
        System.out.println("value: " + str);

        // iOb = strOb; // compiles but makes no sense
        // v = (Integer) iOb.getOb(); //run-time error here!
    }
}

class NonGen
{
    Object ob;

    NonGen(Object o)
    {
        ob = o;
    }

    Object getOb()
    {
        return ob;
    }

    void showType()
    {
        System.out.println("Type of ob is " + ob.getClass().getName());
    }
}
