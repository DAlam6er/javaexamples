package com.stepik.javabasecourse.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindMinMax
{
    public static void main(String[] args)
    {
        Stream stream = Arrays.stream(
            new Integer[]{10, 20, 1, 5, 8, 94, 1, -52, 0});
        Comparator<Integer> comparator = Integer::compare;
        BiConsumer<Integer, Integer> biConsumer = (min, max) ->
        {
            System.out.println(min);
            System.out.println(max);
        };
        findMinMax(stream, comparator, biConsumer);
    }

    public static <T> void findMinMax(
        Stream<? extends T> stream,
        Comparator<? super T> order,
        BiConsumer<? super T, ? super T> minMaxConsumer)
    {
        // Вариант 1
        // Недостаток — необходимость хранить в памяти все элементы стрима,
        // которых может быть очень много. Заранее неизвестно, сколько
        /*
        List<? extends T> list =
            new ArrayList<>(stream.collect(Collectors.toList()));
        if (!list.isEmpty()) {
            list.sort(order);
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        } else {
            minMaxConsumer.accept(null, null);
        }
         */

        // Вариант 2
        // Оптимальным решением является нахождение минимума и максимума
        // за один проход по стриму без использования
        // промежуточного хранилища элементов.
        MinMaxFinder<T> minMaxFinder = new MinMaxFinder<>(order);
        // minMaxFinder - Consumer, принимает объекты
        stream.forEach(minMaxFinder);

        minMaxConsumer.accept(minMaxFinder.min, minMaxFinder.max);
    }

    private static class MinMaxFinder<T> implements Consumer<T>
    {
        private final Comparator<? super T> order;
        T min;
        T max;

        private MinMaxFinder(Comparator<? super T> order)
        {
            this.order = order;
        }

        @Override
        public void accept(T t)
        {
            if (min == null || order.compare(t, min) < 0) {
                min = t;
            }
            if (max == null || order.compare(max, t) < 0) {
                max = t;
            }
        }
    }
}
