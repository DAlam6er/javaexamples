package com.stepik.javabasecourse.collections;

public interface CollectionDemo<E> extends Iterable<E>
{
    // Здесь не специфицирован ни способ хранения элементов,
    // ни ограничение на их уникальность,
    // ни ожидаемая эффективность тех или иных операций
    int size();

    boolean isEmpty();

    // используют equals
    boolean contains(Object o);
    boolean add(E e);
    boolean remove(Object o);   // возвращает, найден ли был удаляемый элемент
    // очистка всех элементов коллекции
    void clear();
}
