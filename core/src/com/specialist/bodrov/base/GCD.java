package com.specialist.bodrov.base;

public class GCD {

    public static void main(String[] args) {
        int result = gcd(16, 106);
        System.out.println(result);
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
