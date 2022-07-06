package com.javarush.favourites.n0705;

import java.util.ArrayList;
import java.util.Iterator;

public class ArraySorter1
{

    public void sort(String[] array) {
        ArrayList<String> listOfNumbers =
            new ArrayList<>(array.length/2);
        ArrayList<String> listOfWords =
            new ArrayList<>(array.length/2);
        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                listOfNumbers.add(array[i]);
            } else {
                listOfWords.add(array[i]);
            }
        }
        listOfNumbers.sort(
            (s1, s2) -> Integer.parseInt(s2) - Integer.parseInt(s1));
        String temp;
        for (int i = 0; i < listOfWords.size(); i++) {
            for (int j = 0; j < listOfWords.size() - 1 - i; j++) {
                if (isGreaterThan(listOfWords.get(j), listOfWords.get(j + 1)))
                {
                    temp = listOfWords.get(j);
                    listOfWords.set(j, listOfWords.get(j + 1));
                    listOfWords.set(j + 1, temp);
                }
            }
        }
        Iterator<String> numIterator = listOfNumbers.iterator();
        Iterator<String> wordsIterator = listOfWords.iterator();
        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                array[i] = numIterator.next();
            } else {
                array[i] = wordsIterator.next();
            }
        }
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public boolean isNumber(String text) {
        if (text.length() == 0) {
            return false;
        }

        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char character = chars[i];
            if ((i != 0 && character == '-') // Строка содержит '-'
                    || (!Character.isDigit(character) && character != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && character == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
