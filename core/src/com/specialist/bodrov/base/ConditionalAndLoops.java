package com.specialist.bodrov.base;

import java.util.Random;

public class ConditionalAndLoops {

    public static void main(String[] args) {
        int a = 2;
        if (true) System.out.println("!!!");

        if (a > 0) {
            System.out.println("a is positive");
        } else if (a == 0) {
            System.out.println("a is zero");
        } else {
            System.out.println("a is negative");
        }
        System.out.println("---");

        String result;
        if (a == 0) {
            result = "a is zero";
        } else {
            result = "a is not zero";
        }

        result = a == 0
                ? "a is zero"
                : "a is not zero";

        System.out.println("---");

        switch (a) {
            case 0:
                result = "a is zero";
                break;
            case 1:
                result = "a is one";
                break;
            case 2, 3, 4:
                result = "a is from two to four";
                break;
            default:
                result = "a is other";
        }

        System.out.println(result);

        switch (a) {
            case 0 -> result = "a is zero";
            case 1 -> {
                String one = "one";
                result = "a is " + one;
            }
            default -> result = "a is other";
        }
        System.out.println(result);


        result = switch (a) {
            case 0 -> "a is zero";
            case 1 -> "a is one";
            case 2, 3, 4 -> "a is from 2 to 4";
            default -> "a is other";
        };

        System.out.println(result);
        System.out.println(switch (a) {
            case 0 -> "a is zero";
            case 1 -> "a is one";
            case 2, 3, 4 -> "a is from 2 to 4";
            default -> "a is other";
        });

        System.out.println("---");
        for (int i = 0; i < 10; i++) {
            System.out.println(i + 1);
        }
        System.out.println("---");

        int counter = 0;
        while (counter < 10) {
            System.out.println(++counter);
        }
        System.out.println("---");

        do {
            System.out.println("!");
        } while (false);
        System.out.println("---");

        long time = System.currentTimeMillis();

        int number = 0;
        do {
            System.out.println(++number);
            if (number == 500) {
                System.out.println("Enough!");
                break;
            }
        } while (System.currentTimeMillis() < time + 10);
        System.out.println("---");

        for (char c = 65; c <= 122; c++) {
            if (c >= 91 && c <= 96) {
                continue;
            }
            System.out.print(c);
        }
        System.out.println();
        System.out.println("---");

        outer:
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print(i*j + " ");
                if (i*j == 25)
                    break outer;
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("End of loop");

        {
            int inner = 10;
        }

        label:{
            System.out.println(1);
            System.out.println(2);

            if (new Random().nextBoolean())
                break label;
            System.out.println(3);
            System.out.println(4);
        }
        System.out.println("End of block");





    }
}
