package com.stepik.javabasecourse.datatypes;

// метод меняет значение одного бита заданного целого числа на противоположное
public class FilpBit
{
    public static void main(String[] args)
    {
        System.out.println(flipBit(5, 2));
    }

    public static int flipBit(int value, int bitIndex)
    {
        //return value ^ (int)Math.pow(2, bitIndex-1);
        return value ^ 1 << (bitIndex - 1);
    }
}
