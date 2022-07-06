package com.grokkingalgorithms.chap06.graph;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<T> implements DataStructure<T>
{
    private static final int SIZE = 10;
    private int top;
    private Object[] array;

    public Stack()
    {
        array = new Object[SIZE];
        top = -1;
    }

    // Safe because push(T) is type checked
    @SuppressWarnings("unchecked")
    private T element(int index)
    {
        return (T) array[index];
    }

    @Override
    public void push(T v)
    {
        if ( top == array.length - 1) {
            int newSize = 2 * array.length;
            array = Arrays.copyOf(array, newSize);
        }
        array[++top] = v;
    }

    @Override
    public T pop()
    {
        if (isEmpty()) throw new EmptyStackException();
        return element(top--);
    }

    @Override
    public T peek()
    {
        return element(top);
    }

    @Override
    public boolean isEmpty()
    {
        return (top == -1);
    }

    @Override
    public String toString()
    {
        return String.format("%s; Stack top at %d",
            Arrays.toString(array),top);
    }
}
