package com.specialist.bodrov.homework;

import java.util.Scanner;

public class DigitSum {
    private static int sum(int inNumber) {
        int res = 0;
        while (inNumber!=0) {
            res += inNumber%10;
            inNumber /= 10; // портим переданное число
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num;
        System.out.print("Input an integer num: ");
        num = in.nextInt();
        System.out.println(sum(num));
    }
}