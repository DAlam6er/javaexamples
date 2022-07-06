package com.headfirstjava.Annex;

public class StringTest
{
    public static void main(String[] args)
    {
        String s1 = "Сравнение";
        String s2 = s1;
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2);
        System.out.println("1--------------");

        int a = 3;
        byte b = 3;
        System.out.println(a == b); // true
        System.out.println("2--------------");

        Object c = new Object();
        Object d = new Object();
        Object e = c;
        System.out.println(c == d); // false
        System.out.println(c == e); // true
        System.out.println(d == e); // false
        System.out.println("3--------------");
        // Методы класса String
        System.out.println("Осень".charAt(1)); // 'с'
        System.out.println("Осень".length()); // 5
        System.out.println("Осень".substring(2,4)); // со 2-го по 4-й(исключительно)
        System.out.println("Лето ".concat("- лучшее время года!"));
        StringBuilder strb = new StringBuilder();
        strb.append("Осень ").append("- худшее время года");
        System.out.println(strb);
        System.out.println("Маска".replace('с','р'));
        System.out.println("Синхроимпульс".substring(6,13));
        System.out.println("Космос".toCharArray().getClass().getSimpleName());
        System.out.println(String.valueOf(new char[]{'В', 'е', 'к'}));
        System.out.println(String.valueOf(99).charAt(0));
        strb = new StringBuilder();
        strb.append("а роза упала на лапу азора").reverse();
        System.out.println(strb);
    }
}