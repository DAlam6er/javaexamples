package com.javarush.favourites.n0408;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
    НОД 2 чисел, вводимых с клавиатуры
*/

public class Solution
{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        br.close();
        System.out.println(gcd(x, y));
    }

    static int gcd(int x, int y)
    {
        while (y != 0) {
            int mod = x % y;
            x = y;
            y = mod;
        }
        return x;
    }
}
