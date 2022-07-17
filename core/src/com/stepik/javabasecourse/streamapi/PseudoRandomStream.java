package com.stepik.javabasecourse.streamapi;

import java.util.stream.IntStream;

public class PseudoRandomStream
{
    public static void main(String[] args)
    {
        pseudoRandomStream(13)
            .limit(20)
            .forEach(v -> System.out.printf("%d ", v));
    }

    public static IntStream pseudoRandomStream(int seed)
    {
        return IntStream.iterate(seed, n -> n * n / 10 % 1000);
    }
}
