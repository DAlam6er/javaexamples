package com.stepik.javabasecourse;

import java.math.BigInteger;

public class Factorial
{
    public static void main(String[] args)
    {
        System.out.println(factorial(299));
    }

    public static BigInteger factorial(int value) {
        if (value < 0) return BigInteger.ZERO;
        if (value == 0) return BigInteger.ONE;
        return factorial(value - 1).multiply(new BigInteger(String.valueOf(value)));
    }
}
