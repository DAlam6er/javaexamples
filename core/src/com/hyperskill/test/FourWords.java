package com.hyperskill.test;

import java.util.Scanner;

// Write a program that reads four words and outputs them in the same order,
// each in a new line.
public class FourWords
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        scanner.tokens().forEach(System.out::println);
    }
}
