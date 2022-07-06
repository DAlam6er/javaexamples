package com.headfirstjava.Annex;

import java.util.Arrays;

public class ArrayTest
{
    public static void main(String[] args)
    {
        // Многомерные массивы
        int[][] a2d = new int[4][2];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                a2d[i][j] = (int) (Math.random() * 10);
            }
        }
        System.out.println(Arrays.deepToString(a2d));
        // доступ ко второму элементу третьего массива
        int x = a2d[2][1];
        System.out.println("a2d[2][1] = " + x);
        // одномерная ссылка на один из дочерних массивов
        int[] copy = a2d[1];
        System.out.println("a2d[1] = " + Arrays.toString(copy));
        // сокращенная инициализация массива 2x3
        int[][] kappa = {{2, 3, 4}, {7, 8, 9}};
        // создание массива с непостоянным количеством измерений
        int[][] delta = new int[2][];
        delta[0] = new int[3];
        delta[1] = new int[5];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                delta[i][j] = (int) (Math.random() * 5) + 1;
            }
        }
        delta[1][3] = 9;
        delta[1][4] = 10;
        System.out.println(Arrays.deepToString(delta));
    }
}
