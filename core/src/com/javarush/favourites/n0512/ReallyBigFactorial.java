package com.javarush.favourites.n0512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/* 
Факториал
*/

public class ReallyBigFactorial
{
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();
        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        if (n < 0) return "0";
        if (n == 0) return "1";
        return
            (new BigInteger(factorial(n - 1)))
            .multiply(new BigInteger(String.valueOf(n)))
            .toString();
    }
}
