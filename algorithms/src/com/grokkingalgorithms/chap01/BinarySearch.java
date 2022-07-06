package com.grokkingalgorithms.chap01;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch
{
    private int[] array;

    //O(log2(n))
    public Integer binarySearch(int[] arr, int elem)
    {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        int guess;

        while (low <= high) {
            mid = (low + high) /2;
            guess = arr[mid];
            System.out.printf("arr[%d] = %d\n", mid, guess);
            if (elem == guess) {
                return mid;
            }
            if (guess > elem) {
                System.out.println("Too much!");
                high = mid - 1;
            }
            else {
                System.out.println("Too little!");
                low = mid + 1;
            }
        }
        return null;
    }

    public static void main(String[] args)
    {
        BinarySearch bSearch = new BinarySearch();
        // getting array
        bSearch.inputArray();
        // Insert sorting array
        bSearch.insertSort();
        // Printing sorted array
        System.out.println(
            "Sorted array:\n" + Arrays.toString(bSearch.getArray()));
        // Calling BinarySearch
        System.out.print("Input element to find: ");
        int elToFind = new Scanner(System.in).nextInt();
        Integer res = bSearch.binarySearch(bSearch.getArray(), elToFind);
        if (res == null) {
            System.out.println("Element not found!");
        } else {
            System.out.println("Element's position is " + res);
        }
    }

    // User input
    public void inputArray()
    {
        int num;
        Scanner in = new Scanner(System.in);

        System.out.print("Enter number of elements of array: ");
        num = Integer.parseInt(in.nextLine());
        array = new int[num];

        System.out.println("Enter integer elements of array: ");
        for (int i = 0; i < num; i++) {
            array[i] = in.nextInt();
        }
        in.close();
        // consumes the \n character
        /*
        if (in.hasNextLine()) {
            in.nextLine();
        }
         */
    }

    public int[] getArray()
    {
        return array;
    }

    public void setArray(int[] array)
    {
        this.array = array;
    }

    public void insertSort()
    {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j-1] > array[j]) {
                int tmp = array[j - 1];
                array[j - 1] = array[j];
                array[j] = tmp;
                j--;
            }
        }
    }
}