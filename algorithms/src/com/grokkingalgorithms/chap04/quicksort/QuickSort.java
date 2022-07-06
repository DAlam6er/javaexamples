package com.grokkingalgorithms.chap04.quicksort;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort
{
    private int[] array;

    public int[] getArray()
    {
        return array;
    }

    public void setArray(int[] array)
    {
        this.array = array;
    }

    public void inputArray()
    {
        int num;
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Enter number of elements of array: ");
            num = Integer.parseInt(in.nextLine());
            array = new int[num];

            System.out.println("Enter integer elements of array: ");
            for (int i = 0; i < num; i++) {
                array[i] = in.nextInt();
            }
        } catch (NumberFormatException ex) {
            System.out.println("Input only numbers!");
            System.exit(1);
        }
    }

    public static void main(String[] args)
    {
        QuickSort qs = new QuickSort();
        qs.inputArray();
        System.out.println(Arrays.toString(qs.getArray()));
        int[] res = qs.quickSort(qs.getArray());
        System.out.println(Arrays.toString(res));
    }

    public int[] quickSort(int[] arrToSort)
    {
        // Базовый случай
        if (arrToSort.length < 2) return arrToSort;

        // Рекурсивный случай
        int pivotInd = arrToSort.length / 2;
        int[] pivot = new int[]{arrToSort[pivotInd]};
        int lessSize = 0;
        int greaterSize = 0;

        for (int i = 0; i < arrToSort.length; i++) {
            if (i == pivotInd) continue;
            if (arrToSort[i] <= pivot[0]) lessSize++;
            else if (arrToSort[i] > pivot[0]) greaterSize++;
        }
        int[] less = new int[lessSize];
        int[] greater = new int[greaterSize];

        int j = 0;
        int k = 0;
        for (int i = 0; i < arrToSort.length; i++) {
            if (i == pivotInd) continue;
            if (arrToSort[i] <= pivot[0]) less[j++] = arrToSort[i];
            else if (arrToSort[i] > pivot[0]) greater[k++] = arrToSort[i];
        }
        int[] res = ConcatArrays.concat(
            ConcatArrays.concat(quickSort(less), pivot),
            quickSort(greater));
        return res;
    }
}
