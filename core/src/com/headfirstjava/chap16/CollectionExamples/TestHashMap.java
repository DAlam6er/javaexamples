package com.headfirstjava.chap16.CollectionExamples;

import java.util.HashMap;

public class TestHashMap
{
    public static void main(String[] args)
    {
        HashMap<String, Integer> scores = new HashMap<>();
        scores.put("Кэти", 42);
        scores.put("Берт", 343);
        scores.put("Скайлер", 420);
        System.out.println(scores);
        System.out.println(scores.get("Берт"));
    }
}
