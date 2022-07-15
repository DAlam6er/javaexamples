package com.stepik.javabasecourse.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo
{
    public static void main(String[] args)
    {
        List<Integer> collection = new ArrayList<>(Arrays.asList(19,29,23,1));

        // iterator() унаследован от интерфейса java.lang.Iterable
        // Iterator позволяет единообразно обходить элементы любой коллекции,
        // не задумываясь об её устройстве - дерево, связный список или массив
        Iterator<Integer> iterator = collection.iterator();
        // hasNext() - проверка наличия следующего элемента
        while (iterator.hasNext()) {
            // next() - получение следующего элемента
            Integer element = iterator.next();
            System.out.printf("%d ", element);
        }
        System.out.println();

        // remove() - метод Iterator'а, удаляющий текущий элемент из коллекции
        // текущий элемент - элемент, который был последним возвращен из next()

        // более короткий способ обхода коллекции
        for (Integer element : collection) {
            System.out.printf("%d ", element);
        }
        System.out.println();

        // еще более короткий способ обхода элементов коллекции
        // из java.lang.Iterable
        // forEach() принимает на вход java.util.functionConsumer<T>
        // Consumer - функциональный интерфейс с единственным методом accept(T)
        // инстанцируем функциональный интерфейс с помощью ссылки на метод
        collection.forEach(System.out::println);

        // Коллекции не любят, когда их меняют в процессе обхода не через итератор!
        // в данном примере будет выброшено исключение java.util.ConcurrentModificationException
        for (Integer number : collection) {
            if (number > 5) {
                collection.remove(number);
            }
        }
    }
}
