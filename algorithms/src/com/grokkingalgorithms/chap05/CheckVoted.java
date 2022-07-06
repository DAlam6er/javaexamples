package com.grokkingalgorithms.chap05;

import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;

public class CheckVoted
{
    public static void main(String[] args)
    {
        HashSet<String> names = new HashSet<>();
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Input name (0 for exit): ");
            if (in.hasNextLine()) {
                String value = in.nextLine().toLowerCase(Locale.ROOT);
                if (value.equals("0")) break;
                if (names.contains(value)) {
                    System.out.println("Kick them out!");
                } else {
                    names.add(value);
                    System.out.println("Let them vote!");
                }
            }
        }
    }
}
