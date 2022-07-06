package com.specialist.bodrov.base;

public class Check2Power {

    public static void main(String[] args) {
        for (int i = 1; i <= 1024; i++) {
//            if (check2power(i))
            if (check2powerAlt(i))
                System.out.println(i);
        }
    }

    public static boolean check2power(int n){
        return  (n & (n-1)) == 0;
//       (n & -n) == n;
        // 0 0 0 ... 1 0 ... 0 0 0 : n
        // 1 1 1 ... 1 0 ... 0 0 0 : (-n)
        // 0 0 0 ... 1 0 ... 0 0 0


//      (n & (n-1)) == 0;
        // 0 0 0 ... 1 0 ... 0 0 0 - n
        // 0 0 0 ... 0 1 ... 1 1 1 - (n - 1)
    }

    public static boolean check2powerAlt(int n){
        if (n == 1)
            return true;
        return Integer.parseInt(Integer.toBinaryString(n).substring(1)) == 0;
    }
}
