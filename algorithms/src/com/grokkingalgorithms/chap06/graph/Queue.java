package com.grokkingalgorithms.chap06.graph;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Implementation of FIFO data structure type
 */
public class Queue<T> implements DataStructure<T>
{
    private static final int SIZE = 10;
    private Object[] array;
    private int tail;
    private int count; // number of elements in queue

    public Queue()
    {
        array = new Object[SIZE];
        tail = -1;
        count = 0;
    }

    // Safe because push(T) is type checked
    @SuppressWarnings("unchecked")
    private T element()
    {
        return (T) array[0];
    }

    @Override
    public void push(T data)
    {
        if (tail == SIZE - 1)
        {
            int newSize = 2 * array.length;
            array = Arrays.copyOf(array, newSize);
        }
        array[++tail] = data;
        count++;
    }

    @Override
    public T pop()
    {
        if (isEmpty()) throw new EmptyStackException();
        T tmp = element();
        System.arraycopy(
            array, 1, array, 0, array.length - 1);
        count--;
        tail--;
        return tmp;
    }

    @Override
    public T peek()
    {
        if (isEmpty()) throw new EmptyStackException();
        return element();
    }

    @Override
    public boolean isEmpty()
    {
        return (count == 0);
    }
}