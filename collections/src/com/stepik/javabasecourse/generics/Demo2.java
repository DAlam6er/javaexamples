package com.stepik.javabasecourse.generics;

import java.util.Optional;

public class Demo2
{
    public static void main(String[] args)
    {
        // is null allowed?
        //String text = ???

        // import org.jetbrains.annotations.NotNull;
        // import org.jetbrains.annotations.Nullable;
        // недостаток - не входит в стандартную библиотеку
        // компилятор не может их использовать для проверки корректности кода
        // @Nullable String nullableText = null;
        // @NotNull String nonNullText = "hello!";

        // Optional решает проблему на уровне системы типов
        // Два несовместимых типа. Компилятор их не перепутает
        String text = "bar";
        Optional<String> optionalText = Optional.of("baz");

        // Обёртка в виде Optional позволяет писать код без if
        Optional<String> baz = Optional.of("baz");
        baz.ifPresent(System.out::println);
        /*
        if (s != null) {
            System.out.println(s);
        }
         */

        Optional<String> bar = Optional.empty();    // Optional пустой, но не null
        String value = bar.orElse("bar");
        // Эквивалентно
        /*
        String newValue = "some data";
        value = newValue != null ? newValue : "bar";
         */

    }
}
