package com.stepik.javabasecourse.streamapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.*;

public class Demo
{
    // Stream - это последовательность элементов, потенциально бесконечная
    // с возможностью применять к ней простые или сложные многоэтапные преобразования
    // без использования циклов и условных операторов
    // Программа в результате имеет простую линейную структуру

    // От итератора отличается тем, что итератор - очень простой объект,
    // который умеет лишь выдавать элементы по одному. Stream гораздо более сложный
    // Он представляет собой не просто средство обхода элементов,
    // а СРЕДСТВО ОПИСАНИЯ АЛГОРИТМА обработки и преобразования последовательности элементов

    // От коллекции Stream отличается бесконечностью (т.к. не предполагает хранения всего набора элементов)
    // Коллекция позволяет получать индивидуальный доступ к элементу по индексу или ключу,
    // Stream такого не позволяет
    // Коллекцию можно менять, например через итератор, изменение содержимого Stream никак не влияет на источник,
    // откуда элементы Stream берутся

    // Stream - generic-интерфейс в пакете java.util.stream;
    // дополнительно есть IntStream, LongStream, DoubleStream для соответствующих примитивных типов
    public interface StreamDemo<T> extends BaseStream<T, StreamDemo<T>>
    {
        // методы Stream (их много)
    }

    public static void main(String[] args)
    {
        int sum = IntStream
            // 1 - первый элемент последовательности
            // n -> n + 1 - функция, вычисляющая следующий элемент последовательности
            // Возвращает IntStream представляющий из себя последовательность целых чисел, начиная с 1
            // Вычисляться эта последовательность еще не начала (Stream'ы ленивы)
            .iterate(1, n -> n + 1)
            // Метод добавляет преобразование - оставляем числа, которые делятся на 5 и не делятся на 2
            // Возвращается преобразованный IntStream
            .filter(n -> n % 5 == 0 && n % 2 != 0)
            // Из бесконечной последовательности берём только первые 10 элементов, КОТОРЫЕ ПРОШЛИ ФИЛЬТР: 5, 15, 25, 35 ...95
            .limit(10)
            // Возводим каждый элемент в квадрат: 5^2, 15^2, ... 95^2
            .map(n -> n * n)
            // Суммируем все элементы - спусковой крючок для начала работы Stream
            .sum();

        // Использование Stream состоит из 3 частей:
        // 1. *** Получение Stream *** (некоторые способы)
        //      1.1. При помощи метода .stream() из любой коллекции
        //      1.2. При помощи метода .lines() из BufferedReader - вернет поток строк из данного потока символов
        //      1.3. При помощи директории на диске - требует .close(): .list() .walk()
        //      1.4 При помощи метода .chars() из строки
        //      1.5 При помощи автоматической генерации. Внуть .generate() передается DoubleSupplier
        //      1.6 При помощи итерирования функции
        //      1.7 При помощи диапазона чисел
        //      1.8 При помощи конкатенации 2 других стримов
        //      1.9 При помощи пустого stream
        //      1.10 При помощи массива
        //      1.11 При помощи явного перечисления элементов

        // 1.1.
        Set<String> vocabulary = new HashSet<>(Arrays.asList("12", "13", "14"));
        Stream<String> stream1 = vocabulary.stream();

        // 1.2.
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Stream<String> stream2 = br.lines())
        {
            // code here ...
        } catch (IOException ignored) {}

        // 1.3.
        // .list() - вернёт содержимое директории на 1 уровень
        // .walk() - рекурсивно обойдёт поддиректории
        Path path = Paths.get(".");
        try (Stream<Path> stream3 = Files.list(path);
            Stream<Path> stream4 = Files.walk(path))
        {
            // code here ...
        } catch (IOException ignored) {}

        // 1.4.
        IntStream chars = "hello".chars();

        // 1.5.
        DoubleStream randomNumbers = DoubleStream.generate(Math::random);

        // 1.6.
        IntStream integers = IntStream.iterate(0, n -> n + 1);

        // 1.7.
        IntStream smallIntegers  = IntStream.range(0, 100);         // 0...99
        IntStream smallIntegers2 = IntStream.rangeClosed(0, 100);   //0...100

        // 1.8.
        IntStream combinedStream = IntStream.concat(smallIntegers, smallIntegers2);

        // 1.9.
        IntStream empty = IntStream.empty();

        // 1.10.
        double[] array = new double[]{2d, 3d, -5.4d};
        DoubleStream streamFromArray = Arrays.stream(array);

        // 1.11.
        IntStream streamOfElements = IntStream.of(2, 4, 6, 8, 10);

        // 2. Ноль или более промежуточных операций преобразования - их порядок важен
        //      2.1 filter(Predicate predicate)
        //              - фильтрация
        //      2.2 map(Function<? extends U> mapper)
        //              - принимает Function, которая из каждого элемента stream
        //                делает новый элемент потенциально другого типа
        //      2.3 flatMap(Function<? super T, ? extends Stream> mapper)
        //              - похожа на map(), но принимает функцию, возвращающую Stream
        //                далее flatMap() применяет эту функцию к каждому элементу Stream
        //                получает набор Stream'ов и конкатенирует их,
        //                получая на выходе один плоский IntStream
        //      2.4 distinct()
        //              - убирает из Stream дубликаты элементов
        //      2.5 sorted()
        //              - упорядочивает элементы Stream по возрастанию
        //                если внутри Stream находятся объекты,
        //                их можно передать внутрь метода Comparator
        //      2.6 skip(long n)
        //              - позволяет пропустить некоторое количество первых элементов
        //      2.7 limit(long maxsize)
        //              - ограничивает оставшиеся элементы заданным количеством
        // В качестве отладки, например, между 2.3 и 2.4 или 2.6 и 2.7
        // можно встроить промежуточный вывод элементов с помощью .peek(Consumer)
        IntStream testStream = IntStream.range(0, 60);
        IntStream intermediateStream = testStream
            .filter(n -> n > 50)
            .peek(e -> System.out.println("Filtered value: " + e))
            .mapToObj(Integer::toString)    // конвертируем число в строку java.util.function.IntFunction
            .flatMapToInt(s -> s.chars())   // принимает функцию, возвращающую Stream символов для каждой строки
            .distinct()
            .sorted()
            .skip(1)
            .peek(e -> System.out.println("Remained value: " + e))
            .limit(2);


        // 3. Терминальная операция, запускающая процесс вычисления,
        // результат вычисления которой станет полезным результатом
        // ВАЖНО: вызвать терминальную операцию на Stream можно только один раз
        // после однократного вызова терминальной операции Stream считается более непригодным к использованию
        // При повторном вызове терминальной операции будет выброшено исключение
        // IllegalStateException: stream has already been operated upon or closed
        // Если необходимо получить еще значения - нужно заново его конструировать
        // 3.1 forEach(Consumer action)
        //                  - Consumer получит все элементы, которые в Stream остались
        // 3.2 findFirst()  - возвращает первый в порядке следования элемент из Stream или empty OptionalInt
        // 3.3 findAny()    - возвращает элемент из Stream или empty OptionalInt
        // 3.4 allMatch(Predicate predicate)
        //                  - принимает предикат, возвращает true или false
        //                    в зависимости от того, все ли элементы stream отвечают условиям предиката
        //     anyMatch(Predicate predicate)
        //                  - хотя бы один удовлетворяет предикату
        //     noneMatch(Predicate predicate)
        //                  - ни один элемент не удовлетворяет предикату
        // 3.5 min(Comparator comp)
        //                  - возвращает минимальное значение в виде Optional объекта
        //     max(Comparator comp)
        //                  - возвращает максимальное значение в виде Optional объекта
        // 3.6 count()      - возвращает количество элементов, оставшихся в Stream после промежуточных операций
        // 3.7 sum()        - возвращает арифметическую сумму элементов
        // 3.8 collect(Collector)
        //                  - позволяет собрать элементы Stream в хранилище, н-р в список
        // 3.9 T reduce(T identity, BinaryOperator<T> accumulator)
        //                  - возвращает свёртку элементов Stream
        //                  - результат применения некоторого бинарного оператора
        //                    к каждой паре элементов Stream'а,
        //                    пока не останется один единственный элемент
        //                    который и возвращается в качестве результата reduce

        OptionalInt result = intermediateStream.findFirst();
        System.out.println(result);

        Arrays.stream(new double[]{.2, 0, -4.}).forEach(System.out::println);

        boolean allIntegersAreAtLeast60 = IntStream.of(4, 43, 130)
            .limit(2).allMatch(x -> x > 59);
        System.out.println(allIntegersAreAtLeast60);

        Optional<String> minString = List.of("Мама", "кот", "семья").stream()
            .min(Comparator.comparing(String::length, Integer::compare));
        System.out.println(minString);

        Path path1 = Paths.get("C:\\");
        try (Stream<Path> streamOfC = Files.list(path1)) {
            List<String> list = streamOfC.map(Path::toString).collect(Collectors.toList());
            list.forEach(System.out::println);
        } catch (IOException ignored) {}

        Stream<BigInteger> bigInts = Stream.of(BigInteger.ONE, BigInteger.TWO, BigInteger.TEN);
        BigInteger bigIntSum = bigInts.reduce(BigInteger.ZERO, BigInteger::add);

        // 4. Закрытие Stream - вызов метода close() - опционально, .
        // обязательно лишь в том случае, если Stream выделял системные ресурсы (содержимое файла, директории)
    }
}
