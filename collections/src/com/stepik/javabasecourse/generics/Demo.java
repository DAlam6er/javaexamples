package com.stepik.javabasecourse.generics;

import java.math.BigDecimal;

// Параметризованные типы - дженерики
// - аналоги шаблонных классов из C++
public class Demo
{
    public static void main(String[] args)
    {
        TreeNode rootNode = new TreeNode();
        rootNode.value = "foobar";
        // tree manipulation
        // ...
        // Неудобно - нужно явно приводить к нужному типу
        String value = (String) rootNode.value;

        // Неудобно - нужно следить за тем, что добавляешь
        Object[] arrayOfBigDecimals = new Object[]{
            new BigDecimal(String.valueOf(2)), BigDecimal.TEN};

        BigDecimal min = minElement((BigDecimal[]) arrayOfBigDecimals);
    }

    /*
    public static BigDecimal minElement(BigDecimal[] values)
    {
        if (values.length == 0) {
            return null;
        }

        BigDecimal min = values[0];
        for (int i = 1; i < values.length; i++) {
            if (min.compareTo(values[i]) > 0) {
                min = values[i];
            }
        }
        return min;
    }
     */

    // Параметризованный метод
    public static <T extends Comparable<T>> T minElement(T[] values)
    {
        if (values.length == 0) {
            return null;
        }

        T min = values[0];
        for (int i = 1; i < values.length; i++) {
            if (min.compareTo(values[i]) > 0) {
                min = values[i];
            }
        }
        return min;
    }
}

// Двоичное дерево поиска
class TreeNode
{
    Object value;   // Неудобно
    TreeNode left;
    TreeNode right;
}
