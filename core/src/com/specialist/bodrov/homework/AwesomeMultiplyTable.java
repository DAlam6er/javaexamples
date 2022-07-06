package com.specialist.bodrov.homework;

import java.util.Arrays;
import java.util.Scanner;

public class AwesomeMultiplyTable {
    public static void printMultiplyTable(int n) {
        /* Вывод рамки с заголовком */
        char[] chars;
        String border;
        chars = new char[(n+1)*4];
        Arrays.fill(chars, '-');
        border = new String(chars);
        System.out.println(border);
        for (int i = 1; i <= n; i++) {
            System.out.print("\t" + i);
        }
        System.out.println();
        System.out.println(border);

        /* Вывод строк */
        for (int i = 1; i <= n ; i++) {
            System.out.print(i + "|");
            for (int j = 1; j <= n; j++) {
                System.out.print("\t" + i*j);
            }
            System.out.println();
        }
        System.out.println(border);
    }

    public static void main(String[] args){
        int upBound;
        Scanner n = new Scanner(System.in);
        System.out.print("Input upper bound of matrix: ");
        upBound = n.nextInt();
        printMultiplyTable(upBound);
    }
}