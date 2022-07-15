package com.stepik.javabasecourse.collections;

// Утилитный класс Collections
public class CollectionsDemo
{
    // Перетасовывание списка
    // Collections.shuffle(list);
    // Сортировка списка
    // Collections.sort(list)

    // Установка коллекции только на чтение
    // Set<String> set = Collections.unmodifiableSet(originalSet);
    // set.remove("abc");   // throws java.lang.UnsupportOperationException

    // конвертирование коллекции в массив
    // List<Integer> list = ...;
    // Object[] array1 = list.toArray();

    // перегруженный вариант метода, принимающий массив правильного типа
    // Integer[] array2 = list.toArray(new Integer[list.size()];

    // toArray(T[]) может создать новый массив T[] только благодаря тому,
    // что в него передан массив нужного типа, у которого через reflection
    // можно спросить фактический тип и создать другой такой же массив.
    // Метод toArray() без параметров так сделать не может,
    // поэтому возвращает Object[].

    // конвертирование массива в коллекцию
    // Способ1
    // String[] array = {"A", "B", "C"};
    // Set<String> set1 = new HashSet<>(Arrays.asList(array));v
    // Способ2
    // Set<String> set2 = new HashSet<>();
    // Collections.addAll(set2, array);
}
