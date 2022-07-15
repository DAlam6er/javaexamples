package com.stepik.javabasecourse.collections;

// Упорядоченное множество - обеспечивает обход итератором элементов
// в порядке возрастания их значения
public interface SortedSetDemo<E> extends SetDemo<E>
{
    SortedSetDemo<E> subSet(E fromElement, E toElement);

    // возвращает множество элементов меньших, чем переданный параметр
    // это не копия! Изменения отразятся на общем множестве
    SortedSetDemo<E> headSet(E toElement);

    // возвращает множество элементов больших, чем переданный параметр
    SortedSetDemo<E> tailSet(E fromElement);

    // наименьший элемент
    E first();
    // наибольший элемент
    E last();

    // Реализации SortedSet
    // TreeSet - самобалансирующее двоичное дерево поиска - красно-чёрное дерево
    // TreeSet должен уметь сравнивать элементы друг с другом
    //      элементы должны реализовывать java.lang.Comparable<T>
    //          c методом compareTo(T)
    //      либо сравниваем объекты, которые не умеют сравниваться друг с другом
    //          путем передачи в конструктор TreeSet'а
    //          java.util.Comparator<T> с методом compare(T, T)
    // SortedSetDemo<String> words = new TreeSet<>();
    // words.add("aaa");
    // words.add("bbb");
    // words.add("ccc");

    // words.headSet("bbb").clear();

    // ** Удаление дубликатов из списка
    // У каждого класса коллекции есть конструктор,
    // принимающий в качестве параметра другую коллекцию
    // ListDemo<String> list = new ArrayList<>();
    // list.add("aaa");
    // list.add("aaa");
    // list.add("bbb");
    // list.add("aaa");

    // SetDemo<String> set = new LinkedHashSet<>(list);
    // ListDemo<String> listWithoutDups = new ArrayList<>(set);
}
