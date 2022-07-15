package com.stepik.javabasecourse.functionalinterfaces;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class TernaryOperator
{
    public static void main(String[] args)
    {
        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        // Результирующая функция будет для нулевых ссылок на String возвращать 0,
        // а для ненулевых ссылок возвращать длину строки.
        Function<String, Integer> safeStringLength =
            ternaryOperator(condition, ifTrue, ifFalse);

        String str1 = null;
        int len1 = safeStringLength.apply(str1);
        String str2 = "Крокодил";
        int len2 = safeStringLength.apply(str2);
        System.out.printf("Длина строки %s равна %d\n", str1, len1);
        System.out.printf("Длина строки %s равна %d\n", str2, len2);
    }

    // Function<T, U> принимает аргумент типа T и возвращает значение типа U.
    public static<T, U> Function<T, U> ternaryOperator(
        Predicate<? super T> condition,
        Function<? super T, ? extends U> ifTrue,
        Function<? super T, ? extends U> ifFalse
    )
    {
        return x -> condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);
    }

    /*
    В задаче был дополнительный вопрос про сигнатуру метода ternaryOperator().
    Почему он объявлен именно так, а не более простым способом,
    без всяких <? super T> и <? extends U>?

    Можно ведь было объявить его так:
    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<T> condition,
            Function<T, U> ifTrue,
            Function<T, U> ifFalse)

     В этом случае код из примера бы не скомпилировался.
     <? super T> -> <T>
     В Java типы Predicate<Object> и Predicate<String> несовместимы,
     поэтому нельзя передать Predicate<Object> в метод, ожидающий Predicate<String>.
     <? extends U> -> <T>
     несовместимыми являются типы Function<Object, String>
                                и Function<Object, CharSequence>.
     */
}
