package com.specialist.sedykh.interfaces;

import java.util.Comparator;

public class Box implements Comparable<Box>
{
    private final int a, b, c;

    public Box(int a, int b, int c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA()
    {
        return a;
    }

    public int getB()
    {
        return b;
    }

    public int getC()
    {
        return c;
    }

    @Override
    public String toString()
    {
        return "Box{" + "a=" + a + ", b=" + b + ", c=" + c + '}';
    }

    public int volume()
    {
        return a * b * c;
    }

    @Override
    public int compareTo(Box rValue)
    {
        return volume() - rValue.volume();
    }

        // Inner class
//        public class CompareByA implements Comparator<Box>
//    {
//
//        @Override
//        public int compare(Box b1, Box b2)
//        {
//            return b1.a - b2.a;
//        }
//    }

        // Local class
//    public static Comparator<Box> compareByA()
//    {
//        class CMP implements Comparator<Box>
//        {
//
//            @Override
//            public int compare(Box b1, Box b2)
//            {
//                return b1.a - b2.a;
//            }
//        }
//        return new CMP();
//    }

    // Anonymous class
    public static Comparator<Box> compareByA()
    {
        return new Comparator<Box>()
        {
            @Override
            public int compare(Box b1, Box b2)
            {
                return b1.a - b2.a;
            }
        };
    }

    // Static inner class
    public static class CompareByA implements Comparator<Box>
    {
        @Override
        public int compare(Box b1, Box b2)
        {
            return b1.a - b2.a;
        }
    }
}