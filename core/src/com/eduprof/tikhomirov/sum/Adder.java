package com.eduprof.tikhomirov.sum;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Adder
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String str;
        long[] numbers;
        long res;

        System.out.println("******Number summation program******");
        while (true) {
            System.out.println(
                "Input numbers to add, separated by a comma (0 to exit).");
            str = in.nextLine();
            // FormatCalendar string, remove any spaces for correct parsing
            try {
                numbers =
                    Arrays.stream(str.replaceAll("\\s+", "")
                        .split(",")).mapToLong(Long::parseLong).toArray();

                if ((numbers.length == 1) && (numbers[0] == 0)) break;
                System.out.println(sum(numbers));
            } catch (NumberFormatException e) {
                System.out.println("Wrong data!");
            }
        }
    }

    public static long sum(long ... args)
    {
        long res = 0;
        // for checking underflow/overflow
        for (int i = 0; i < args.length; i++) {
            res = Math.addExact(res, args[i]);
        }
        return res;
    }
}
