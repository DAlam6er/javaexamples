package com.stepik.javabasecourse.generics;

import java.util.Objects;

class Pair<T, V>
{
    private final T first;
    private final V second;

    private Pair(T first, V second)
    {
        this.first = first;
        this.second = second;
    }

    public T getFirst()
    {
        return first;
    }

    public V getSecond()
    {
        return second;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o instanceof Pair) {
            return
                Objects.equals(this.first, ((Pair<?, ?>) o).first) &&
                Objects.equals(this.second, ((Pair<?, ?>) o).second);
        }
        return false;
    }

    public static <X, Y> Pair<X, Y> of(X value1, Y value2)
    {
        return new Pair<>(value1, value2);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(first, second);
    }

    public static void main(String[] args)
    {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst();
        String s = pair.getSecond();
        System.out.println(i);
        System.out.println(s);

        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2);
        System.out.println(mustBeTrue);
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode();
        System.out.println(mustAlsoBeTrue);
    }
}
