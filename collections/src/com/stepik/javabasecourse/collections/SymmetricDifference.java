package com.stepik.javabasecourse.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference
{
    public static void main(String[] args)
    {
        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> setB = new HashSet<>(Arrays.asList(0, 1, 2));
        System.out.println(setA);
        System.out.println(setB);
        Set<Integer> dif = symmetricDifference(setA, setB);
        System.out.println("symmetricDifference: " + dif);
        System.out.println(setA);
        System.out.println(setB);
    }

    public static <T> Set<T> symmetricDifference(
        Set<? extends T> set1, Set<? extends T> set2)
    {
        // Вариант 1
        /*
        Set<T> setA = new HashSet<>(set1);
        Set<T> setB = new HashSet<>(set2);
        setA.removeAll(set2);
        setB.removeAll(set1);
        setA.addAll(setB);
        return setA;
         */
        // Вариант 2
        Set<T> setA = new HashSet<>(set1);
        Set<T> setB = new HashSet<>(set2);
        // Для каждого элемента из setA лезем в setB и,
        // если такой элемент там находится, удаляем его из setB.
        // Если что-то удалилось, оно вернёт true
        // и removeIf удалит тогда такой элемент и из setA тоже.
        // В итоге, в обоих множествах будут удалены элементы, присутствовавшие и там и там.
        setA.removeIf(setB::remove);
        setA.addAll(setB);
        return setA;
    }
}
