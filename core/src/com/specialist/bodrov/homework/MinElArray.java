package com.specialist.bodrov.homework;

import java.util.Scanner;

public class MinElArray {

    public static void clearScreen() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows"))
                Runtime.getRuntime().exec("cls");
            else
                Runtime.getRuntime().exec("clear");
        }
        catch (final Exception e) {
            // Handle any exceptions
        }
    }

    public static void insertSort(int[] a, int max_size) {
        for (int i = 1; i < max_size; i++) {
            int k = i;
            while (k > 0 && a[k-1] > a[k]) {
                int tmp = a[k-1];
                a[k-1] = a[k];
                a[k] = tmp;
                k--;
            }
        }
    }

    public static int printMinEl(int[] a, int max_size) {
        insertSort(a,max_size);
        return a[0];
    }

    public static int digitSum(int number) {
        int sum = 0;
        int buf = number > 0 ? number : -number;
        while(buf != 0) {
            sum += buf%10;
            buf /= 10;
        }
        return sum;
    }

    public static int minDigitNumber(int[] a, int n) {
        int minSum = digitSum(a[0]);
        int minEl = a[0];
        for (int i = 1; i < n; i++) {
            if (digitSum(a[i]) < minSum) {
                minSum = digitSum(a[i]);
                minEl = a[i];
            }
        }
        return minEl;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, minEl, minDigEl;
        System.out.print("Input number of elements in array:");
        n = in.nextInt();
        /* Объявление массива */
        int[] arr;
        System.out.println("Input elements of array:");
        /* Создание массива */
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        /* НЕ РАБОТАЕТ, перед выводом элементов
            консоль не очищается! */
        clearScreen();
        System.out.println("Array has the following elements:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        minEl = printMinEl(arr, n);
        System.out.println("Min element of array is " + minEl);

        minDigEl = minDigitNumber(arr, n);
        System.out.println("Element with min sum of digits is " + minDigEl);
    }
}