package com.specialist.bodrov.base;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArraysExample {

    public static void main(String[] args) {
        boolean EXPERIMENT;
        /* Experiment */
        EXPERIMENT = false;
        if (EXPERIMENT) {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter size of array to create:");
            int n = in.nextInt();
            char[] A = new char[n];
            System.out.println("Array succesfully created!");
            return;
        }
        /* Experiment end */

        String s = null;
        int[] a = null;
        System.out.println(a);

        a = new int[3];
        System.out.println(a);
        System.out.println(new int[3]);
        System.out.println(Arrays.toString(a));
        int num = 1;
        System.out.println(num);
        System.out.println(Arrays.toString(new boolean[5]));
        System.out.println(Arrays.toString(new String[5]));
        System.out.println("---");

        int[] a2 = {19, 34, -555, 1, 25};
        System.out.println(Arrays.toString(a2));

        int[] a3;
        a3 = new int[]{1,8,-4};

        System.out.println(a3[0]);
        System.out.println(a3[1]);
        System.out.println(a3[2]);
//        System.out.println(a3[3]);
        System.out.println(a3.length);
        System.out.println(a3.length);
        System.out.println(a3[a3.length - 1]);

        for (int i = 0; i < a3.length; i++) {
            System.out.print(a3[i] + " ");
        }
        System.out.println();

        for(int number: a3){
            System.out.print(number + " ");
        }
        System.out.println();
        System.out.println("---");

        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(Arrays.toString(matrix));
        System.out.println(Arrays.deepToString(matrix));

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <matrix[i].length ; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---");

        int[][][] multiArray = {{{1,2}, {3}}, {{4,5,6}}, {{}, {9}}};
        System.out.println(Arrays.deepToString(multiArray));
        System.out.println("---");

        char[] symbols = {'q','H','w','f','g'};
        System.out.println(Arrays.toString(symbols));

        char[] newSymbols = Arrays.copyOf(symbols, symbols.length);

        System.out.println(Arrays.toString(newSymbols));
        char[] someSymbols =  Arrays.copyOfRange(symbols, 1, 4);
        System.out.println(Arrays.toString(someSymbols));
        System.out.println("---");

        symbols[0] = 'Z';
        System.out.println(Arrays.toString(symbols));
        System.out.println(Arrays.toString(newSymbols));
        System.out.println(Arrays.toString(someSymbols));

        System.out.println("---");
        //1,5,10,15,7,9

        int[] nums = {1,5,10,15,7,9};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.binarySearch(nums, 7));

        String[] fruits = {"груша", "ананас", "банан",
                "апельсин", "абрикос", "арбуз"};

        System.out.println(Arrays.toString(fruits));
        Arrays.sort(fruits);
        System.out.println(Arrays.toString(fruits));

        LocalDate[] dates = {
                LocalDate.now(),
                LocalDate.of(2007, 1, 10),
                LocalDate.MIN
        };

        System.out.println(Arrays.toString(dates));
        Arrays.sort(dates);
        System.out.println(Arrays.toString(dates));
        System.out.println("---");

        ArrayList<Integer> list = new ArrayList();
        list.add(3);
        list.add(999);
//        list.add(9.1);
//        list.add("Hello");
//        list.add(LocalDate.now());

//        System.out.println(list);
//        list.add(new Object());

//        System.out.println(list);
//        list.add(dates);
        list.add(-10);
        System.out.println(list);

        list.remove(0);
        System.out.println(list);

        List<LocalDate> datesDates = Arrays.asList(dates);
        System.out.println(datesDates);

        List<Integer> integerList = Arrays.asList(9,3,4,5, 54);
        System.out.println(integerList);

        List<String> fruits2 = new ArrayList<>();
        fruits2.add("Персики");
        fruits2.add("Хурма");
        fruits2.add("Черешня");
        fruits2.add("Клементины");

        System.out.println(fruits2);

        String[] instruments = new String[]{"Молоток", "Клещи", "Рубанок"};
        System.out.println(instruments);
        System.out.println(Arrays.toString(instruments));
    }
}
