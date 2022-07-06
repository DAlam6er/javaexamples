package com.stepik.javabasecourse;

import java.util.Random;

public class CastExceptionExample
{
    public static void main(String[] args)
    {
        String s = "some string";
        Object d;
        if ((new Random()).nextBoolean()) {
            d = 0.5;
        } else {
            d = "new string";
        }
        s = (String) d;
        System.out.println(d);
    }
}
