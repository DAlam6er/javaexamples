package com.stepik.javabasecourse.datatypes;
// Реализуйте метод, возвращающий true, если среди четырех его аргументов
// ровно два истинны (любые).
// Во всех остальных случаях метод должен возвращать false.
public class TwoTrues
{
    public static void main(String[] args)
    {
        System.out.println(
            booleanExpression(true, false, false,true));
    }

    public static boolean booleanExpression(
        boolean a, boolean b, boolean c, boolean d)
    {
        return ((a != b) && (c != d)) || ((a != c) && (b != d));
    }
}
