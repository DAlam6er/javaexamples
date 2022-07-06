package com.eduprof.tikhomirov;

import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        int compNumber = random();
        int humanNumber = scan();
        if (humanNumber == compNumber) {
            System.out.println("Вы выиграли!");
        } else {
            System.out.println("Вы проиграли!");
            System.out.println("Было загадано число " + compNumber);
        }
    }

    public static int random()
    {
        Random newRandom = new Random();
        return newRandom.nextInt(10) + 1;
    }

    public static int scan()
    {
        System.out.println("Input number from 1 to 10");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}