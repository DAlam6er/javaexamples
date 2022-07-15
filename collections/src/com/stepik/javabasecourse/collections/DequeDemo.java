package com.stepik.javabasecourse.collections;

// Двусторонняя очередь, можно добавлять и удалять элементы как в хвосте, так и в голове
public interface DequeDemo<E> extends QueueDemo<E>
{
    void addFirst(E e);
    void addLast(E e);

    boolean offerFirst(E e);
    boolean offerLast(E e);

    E removeFirst();
    E removeLast();

    // ** Реализации Deque **
    // Deque<Object> deque1  = new ArrayDeque<>();
    // Deque<Integer> deque2 = new LinkedList<>();

    // deque2.offerLast(1);
    // deque2.offerLast(2);
    // deque2.offerLast(3);

    // Integer element;
    // while ((element = deque2.pollFirst()) != null) {
    //     System.out.println(element);
    // }
}
