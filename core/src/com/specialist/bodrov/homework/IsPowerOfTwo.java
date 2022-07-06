package com.specialist.bodrov.homework;

import java.util.Scanner;

public class IsPowerOfTwo {
    /**
     *
     * @param inNumber is integer
     * @return true if inNumber is power of 2
     */
    private static boolean check(int inNumber) {
        int num = (inNumber < 0) ? -inNumber : inNumber;
        return (num & (num-1)) == 0;
    }

    public static void main(String[] args){
        Scanner in = new Scanner (System.in);
        int num;
        System.out.print("Input a integer number:");
        num = in.nextInt();
        System.out.println(check(num));
    }
}