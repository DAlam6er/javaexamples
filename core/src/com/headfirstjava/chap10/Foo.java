package com.headfirstjava.chap10;

// Проверка кода с использованием модификаторов static, final
public class Foo
{
    static int x;

    public void go()
    {
        System.out.println(x);
    }
}

/*
// non-static variable x cannot be referenced from a static context
class Foo2 {
    int x;

    public static void go()
    {
        System.out.println(x);
    }
}
*/

/*
// variable x not initialized in the default constructor/
// at the time of the announcement
class Foo3
{
    final int x;

    public void go()
    {
        System.out.println(x);
    }
}
*/

class Foo4
{
    static final int x = 12;

    public void go()
    {
        System.out.println(x);
    }
}

class Foo5
{
    static final int x = 12;

    public void go(final int x)
    {
        System.out.println(x);
    }
}

class Foo6
{
    int x = 12;

    public static void go(final int x)
    {
        System.out.println(x);
    }
}