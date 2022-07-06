package com.grokkingalgorithms.chap04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RecursiveMethods {
    private List<Integer> list = new ArrayList<>();

    public List<Integer> getList()
    {
        return list;
    }

    public void setList(List<Integer> list)
    {
        this.list = list;
    }

    public int sumRecursive(List<Integer> list)
    {
        if (list.size() == 0) return 0;
        return list.get(0) + sumRecursive(list.subList(1, list.size()));
    }

    public int numberRecursive(List<Integer> list)
    {
        if (list.size() == 0) return 0;
        return 1 + numberRecursive(list.subList(1, list.size()));
    }

    public int maxRecursive(List<Integer> list)
    {
        // Базовый случай
        if (list.size() == 2) {
            return Math.max(list.get(1), list.get(0));
        }

        // Рекурсивный случай
        int subMax = maxRecursive(list.subList(1, list.size()));
        // Метод возвращает большее из 2 значений:
        // 1-й элемент списка в сравнении с результатом предыдущего
        // рекурсивного вызова
        return Math.max(list.get(0), subMax);
    }


    public long factorial(int x)
    {
        if (x == 1) {
            return 1;
        } else {
            return x * factorial(x - 1);
        }
    }

    public void inputList()
    {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println(
                "Input numeric elements of the list: ");
            // Читаем строку до нажатия на enter. Парсим и добавляем в list.
            if (in.hasNextLine()) {
                list = Arrays.stream(in.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).boxed()
                    .collect(Collectors.toList());
            }
        } catch (NumberFormatException ex) {
            System.out.println("Input only numbers!");
            System.exit(1);
        }
    }

    public static void main(String[] args)
    {
        RecursiveMethods rm = new RecursiveMethods();
        rm.inputList();
        System.out.println(
            "List is:\n" + rm.getList());
        System.out.println(
            "Number of elements is " + rm.numberRecursive(rm.list));
        System.out.println(
            "Sum of the elements is " + rm.sumRecursive(rm.list));

        int max = rm.maxRecursive(rm.list);
        System.out.println(
            "Max element is " + max);
        try {
            System.out.printf(
                "%d! = %d\n", max, rm.factorial(max));
        } catch (StackOverflowError error) {
            System.out.println("To big number to find factorial!");
        }
    }
}