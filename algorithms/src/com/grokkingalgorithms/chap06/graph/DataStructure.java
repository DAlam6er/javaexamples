package com.grokkingalgorithms.chap06.graph;

public interface DataStructure<T>
{
    void push(T data);
    T pop();
    T peek();
    boolean isEmpty();
}
