package com.javamanual;

public class GenMethDemo
{
    static <T, V extends T> boolean isIn(T x, V[] y)
    {
        for (int i = 0; i < y.length; i++) {
            if(x.equals(y[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        Integer[] nums = {1, 2, 3, 4, 5};
        if(isIn(2,nums)) {
            System.out.println("nums contains 2");
        }
        if(!isIn(7, nums)) {
            System.out.println("nums does not contain 7");
        }
        String strs[] = {"one", "two", "three", "four", "five"};
        if(isIn("two", strs)) {
            System.out.println("strs contains \"two\"");
        }
        if(!isIn("seven", strs)) {
            System.out.println("strs does not contain \"seven\"");
        }

        /* Здесь ошибка типа
        if(isIn("two", nums)) {
            System.out.println("nums contains \"two\"");
        }
        */
    }
}
