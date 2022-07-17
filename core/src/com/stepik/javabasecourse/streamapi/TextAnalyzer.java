package com.stepik.javabasecourse.streamapi;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextAnalyzer
{
    public static void main(String[] args)
    {
        /*
        String input =
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Sed sodales consectetur purus at faucibus. " +
                "Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. " +
                "Morbi lacinia velit blandit tincidunt efficitur. " +
                "Vestibulum eget metus imperdiet sapien laoreet faucibus. " +
                "Nunc eget vehicula mauris, ac auctor lorem. " +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Integer vel odio nec mi tempor dignissim.";

        InputStream testStream =
            new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));

        textAnalyzer(testStream);
         */
        textAnalyzer(System.in);
    }

    // Вариант 1
    public static void textAnalyzer(InputStream inputStream)
    {
        try (BufferedReader br =
                 new BufferedReader(new InputStreamReader(inputStream))) {

            HashMap<String, Integer> result = new HashMap<>();
            br.lines()
                .flatMap(str -> Stream.of(str.split("[\\p{Punct}\\s]+")))
                .map(String::toLowerCase)
                .forEach(str -> {
                    if (result.containsKey(str)) {
                        result.put(str, result.get(str) + 1);
                    } else {
                        result.put(str, 1);
                    }
                });

            result.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    if (Objects.equals(e1.getValue(), e2.getValue())) {
                        return e1.getKey().compareTo(e2.getKey());
                    } else {
                        return e2.getValue().compareTo(e1.getValue());
                    }
                })
                .limit(10)
                .forEach(e -> System.out.println(e.getKey()));


            /*
            br.lines()
                .map(line ->
                    line.toLowerCase()
                        .replaceAll("\\p{Punct}", " ")
                        .split("\\s+"))
                .flatMap(Arrays::stream)
                .collect(
                    Collectors.groupingBy(Function.identity(),
                    Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.naturalOrder()))
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .map(entry -> entry.getKey())
                .forEach(System.out::println);
             */
        } catch (IOException ignored) {
        }
    }

    // Вариант 2
    public static void textAnalyzer2(InputStream inputStream)
    {
        try (BufferedReader br =
                 new BufferedReader(new InputStreamReader(inputStream))) {
            br.lines()
                .map(line ->
                    line.toLowerCase()
                        .replaceAll("\\p{Punct}", " ")
                        .split("\\s+"))
                .flatMap(Arrays::stream)
                .collect(
                    Collectors.groupingBy(Function.identity(),
                        Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.naturalOrder()))
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);
        } catch (IOException ignored) {
        }
    }

    // Вариант 3
    public static void textAnalyzer3(InputStream inputStream)
    {
        // Для чтения входного потока используем Scanner.
        // Поскольку словами мы считаем последовательности символов,
        // состоящие из букв или цифр, то в качестве разделителя слов Scanner'у
        // указываем регулярное выражение, означающее
        // "один или более символ, не являющийся ни буквой, ни цифрой"
        Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8)
            .useDelimiter("[^\\p{L}\\d]+");

        // Пройдем по всем словам входного потока и составим Map<String, Integer>,
        // где ключом является слово, преобразованное в нижний регистр,
        // а значением - частота этого слова.
        Map<String, Integer> freqMap = new HashMap<>();
        scanner.forEachRemaining(
            s -> freqMap.merge(s.toLowerCase(), 1, Integer::sum));

        freqMap.entrySet().stream()
            .sorted(descendingFrequencyOrder())
            .limit(10)
            .map(Map.Entry::getKey)
            .forEach(System.out::println);
    }

    private static Comparator<Map.Entry<String, Integer>>
    descendingFrequencyOrder()
    {
        // Нам нужен Comparator, который сначала упорядочивает пары
        // по частоте (по убыванию),
        // а затем по слову (в алфавитном порядке). Так и напишем:

        return Comparator.
            <Map.Entry<String, Integer>>comparingInt(Map.Entry::getValue)
            .reversed()
            .thenComparing(Map.Entry::getKey);
    }
}
