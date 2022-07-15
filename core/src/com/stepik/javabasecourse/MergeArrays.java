package com.stepik.javabasecourse;

import java.util.Arrays;

public class MergeArrays
{
    public static void main(String[] args)
    {
        int[] m1 = new int[]{0, 2, 2};
        int[] m2 = new int[]{1, 3};
        System.out.println(Arrays.toString(mergeArrays(m1, m2)));
    }

    /**
     * Merges two given sorted arrays into one
     *
     * @param a1 first sorted array
     * @param a2 second sorted array
     * @return new array containing all elements from a1 and a2, sorted
     */
    public static int[] mergeArrays(int[] a1, int[] a2)
    {
        if (a1.length == 0) return a2;
        if (a2.length == 0) return a1;

        int i = 0, j = 0, k = 0;
        int[] res = new int[a1.length + a2.length];

        while (i < a1.length && j < a2.length) {
            res[k++] = a1[i] < a2[j] ? a1[i++] : a2[j++];
        }

        if (i < a1.length) {
            System.arraycopy(a1, i, res, k, a1.length - i);
        } else if (j < a2.length) {
            System.arraycopy(a2, j, res, k, a2.length - j);
        }

        return res;
    }
}
