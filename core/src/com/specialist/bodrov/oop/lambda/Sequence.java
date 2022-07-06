package com.specialist.bodrov.oop.lambda;

import java.util.function.IntPredicate;

public class Sequence {

    //1) Проверка на четность:
    //[1,2,3,4,5] -> [2,4]

    //2) Проверка суммы цифр элемента на четность:
    //[123,104,75, 81, 1, 8] -> [123,75,8]

    public static int[] filter (int[] array, IntPredicate predicate) {
        return null;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5};
        System.out.println(filter(array, null)); //null <- lambda expression
        System.out.println(filter(array, null)); //null <- lambda expression
    }
}