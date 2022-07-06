package com.javarush.favourites.n0206;

/*
Задача №1 на преобразование целых типов
*/

public class Solution
{
    public static void main(String[] args)
    {
        int a = 0;
        int b = (int) a + 46;
        byte c = (byte) (a * b);
        double f = (double) 1234.15;
        long d = (long) (a + f / c + b);
        System.out.println("f / c = " + (f / c));
        System.out.println("(long) (f / c) = " + (long) (f / c));
        System.out.println("(long) (0 + Infinity + 46) = " + d);
        // При делении на 0 получаем бесконечность.
        // А при приведении типа бесконечность "обрезается" до приемлемого значения,
        // то есть до максимального, которое может принимать переменная данного типа.
        // 9223372036854775807 для long или  2147483647 для int.
    }
}
