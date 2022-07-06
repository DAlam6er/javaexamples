package com.specialist.bodrov.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class IntArrayMethods {

    public static int evenNumber(int[] a, int max_size) {
        int res=0;
        for (int i = 0; i < max_size; i++) {
            if (0 == a[i] % 2) res++;
        }
        return res;
    }

    public static ArrayList<Integer> evenList(int[] a, int max_size) {
        ArrayList<Integer> resList;
        resList = new ArrayList<>();
        for (int i = 0; i < max_size; i++) {
            if (0 == a[i] % 2) resList.add(a[i]);
        }
        return resList;
    }

    public static int[] evenArray(int[] a, int max_size) {
        int[] filtArr;
        filtArr = new int[max_size];
        int top = 0;
        for (int i = 0; i < max_size; i++) {
            if (0 == a[i] % 2) {
                filtArr[top] = a[i];
                top++;
            }
        }
        return Arrays.copyOfRange(filtArr, 0,top);
    }

    public static void main(String[] args) {
        int n;
        int[] arr;
        Scanner in = new Scanner(System.in);
        System.out.print("Input number of elements in array: ");
        n = in.nextInt();
        arr = new int[n];
        System.out.println("Input elements of array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println();
        System.out.println("The elements of specified array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.println("Number of even numbers is " + evenNumber(arr, n));
        System.out.println("The list of these numbers is \n" + evenList(arr, n));
        System.out.println("The array of these numbers is \n" + Arrays.toString(evenArray(arr, n)));
    }
}