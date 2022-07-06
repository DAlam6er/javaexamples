package com.specialist.bodrov.base;

public class BinaryOperations {
    public static void main(String[] args) {


        //8 4 2 1
        //0 1 0 0

        // 0 ... 0 1
        // 0 ... 1 1

        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(3));
        System.out.println(Integer.toBinaryString(4));

        System.out.println("---");

        System.out.println(zeroPaddedString(Integer.toBinaryString(1)) + " <- " + 1);
        System.out.println(zeroPaddedString(Integer.toBinaryString(Integer.MAX_VALUE)) + " <- " + Integer.MAX_VALUE);
        System.out.println(zeroPaddedString(Integer.toBinaryString(0)) + " <- " + 0);
        System.out.println(zeroPaddedString(Integer.toBinaryString(Integer.MIN_VALUE)) + " <- " + Integer.MIN_VALUE);
        System.out.println(zeroPaddedString(Integer.toBinaryString(-1)) + " <- " + -1);

        System.out.println("---");
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE + Integer.MAX_VALUE + Integer.MAX_VALUE);

        System.out.println("---");
        System.out.println(~1);
        System.out.println(14 & 7);
        System.out.println(14 | 7);

        System.out.println(1<<1);
        System.out.println(-1>>>1);
        System.out.println(-1>>1);
    }

    private static String zeroPaddedString(String s){
        return String.format("%32s", s).replace(" ", "0");
    }
}
