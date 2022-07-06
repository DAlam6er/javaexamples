package com.specialist.bodrov.homework.lambda;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntPredicate;

public class Sequence
{
    public static int[] filter (int[] array, IntPredicate predicate)
    {
        int[] newArray = new int[array.length];
        int top = 0;
        for (int el : array) {
            if (predicate.test(el)) {
                newArray[top++] = el;
            }
        }
        return Arrays.copyOfRange(newArray,0,top);
    }

    public static void main(String[] args)
    {
        int[] array;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input number of elements: ");
        int n = scanner.nextInt();
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        IntPredicate evenNum = num -> 0 == num % 2;
        IntPredicate evenDigSum = num ->
        {
            int testSum = num;
            int res = 0;
            while(testSum != 0) {
                res += testSum % 10;
                testSum /= 10;
            }
            return 0 == res % 2;
        };
        System.out.println("Even numbers: " +
            Arrays.toString(filter(array, evenNum)));
        System.out.println("Numbers with Even sum of digits: " +
            Arrays.toString(filter(array, evenDigSum)));
    }
}