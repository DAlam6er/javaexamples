package com.specialist.bodrov.base;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayHomework {

    public static void main(String[] args) {
        int[] array = {2,9,8,-3,5,6,7,-200};
        System.out.println(countEvens(array));
        System.out.println(evenList(array));
        System.out.println(Arrays.toString(evenArray(array)));
    }

    public static int countEvens(int[] array){
        int count = 0;
        for (int num : array) {
            if (num % 2 == 0)
                count++;
        }

        return count;
    }

    public static ArrayList<Integer> evenList(int[] array){
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : array) {
            if (num % 2 == 0)
                list.add(num);
        }

        return list;
    }

    public static int[] evenArray(int[] array){
        int[] resultArray = new int[array.length];

        int count = 0;
        for (int num : array) {
            if (num % 2 == 0) {
                resultArray[count++] = num;
            }
        }

        return Arrays.copyOf(resultArray, count);
    }





}
