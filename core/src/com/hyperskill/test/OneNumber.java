package com.hyperskill.test;

import java.util.Scanner;
import java.util.stream.IntStream;

// Write a program that reads three integer numbers and prints true
// if exactly ONE number is positive (i.e. > 0).
public class OneNumber
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        long number = scanner.tokens()
            .flatMapToInt(s -> IntStream.of(Integer.parseInt(s)))
            .filter(i -> i > 0).count();
        System.out.println(number == 1);
    }
}
