package com.stepik.javabasecourse.generics;

import java.math.BigDecimal;
import java.util.Optional;

public class OptionalMethods
{
    public static void main(String[] args)
    {
        Optional<String> foo = Optional.empty();
        Optional<String> bar = Optional.of("bar");
        Optional<String> baz = Optional.ofNullable("baz");

        Optional<CharSequence> optionalCharSequence =
            Optional.<CharSequence>ofNullable("baz");

        // Конструктор закрытый, поэтому так создать экземпляр нельзя
        // <> - diamond-оператор, работает вместе с new
        // Optional<String> newOptional = new Optional<>("foobar");

        // Скомпилируется
        Number number = Integer.valueOf(1);
        Number[] numberArray = new Integer[10];

        Optional<Integer> optionalInt = Optional.of(1);
        Optional<Number> optionalNumber = Optional.empty();
        // Не скомпилируется, с т.зр. компиляторы типы несовместимы
        //optionalNumber = optionalInt;
        // Так делать, нельзя, иначе при наличии метода set у optionalNumber
        // была бы возможна операция, заменяющая содержащийся в нем элемент
        // на BigDecimal и тем самым нарушить ограничение,
        // заданное при создании контейнера
        // optionalNumber.set(new BigDecimal("3.14"));

        // В случае с массивами JVM защищает от подобной ошибки
        // java.lang.ArrayStoreException
        // numberArray[0] = new BigDecimal(String.valueOf(1));
    }
}
