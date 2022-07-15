package com.stepik.javabasecourse.datatypes;

public class IsPowerOfTwo
{
    public static void main(String[] args)
    {
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(9));
    }

    public static boolean isPowerOfTwo(int value) {
        value = value > 0 ? value : -value;
        return (value > 0) && (value & (value-1)) == 0;
    }
}
