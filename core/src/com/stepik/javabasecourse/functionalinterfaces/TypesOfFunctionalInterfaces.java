package com.stepik.javabasecourse.functionalinterfaces;

public class TypesOfFunctionalInterfaces
{
    // *** Виды функциональных интерфейсов *** :
    // Consumer - потребитель, он получает на вход значение, что-то с ним делает, но ничего не возвращает.
    @FunctionalInterface
    public interface Consumer<T> // + IntConsumer, LongConsumer, DoubleConsumer, BiConsumer<T,U>: void accept(T, U)
    {
        void accept(T t);
    }

    // Supplier - поставщик, предоставляет значения, на вход ничего не принимает
    @FunctionalInterface
    public interface Supplier<T> // + BooleanSupplier, IntSupplier, LongSupplier, DoubleSupplier
    {
        T get();
    }

    // Predicate - утверждение, получает на вход значение и возвращает истину/ложь в зависимости от значения.
    @FunctionalInterface
    public interface Predicate<T> // + IntPredicate, LongPredicate, DoublePredicate, BiPredicate
    {
        boolean test(T t);
    }

    // Function - функция, принимает аргумент и возвращает значение какого-то типа, в общем случае другого
    @FunctionalInterface
    public interface Function<T, R> // + BiFunction, DoubleFunction: double -> T, LongToIntF: long -> int ...
    {
        R apply(T t);
    }

    // Operator - оператор, как функция, только принимает и возвращает значения одного типа.
    @FunctionalInterface
    public interface UnaryOperator<T> extends Function<T, T> // + BinaryOperator, IntOperator, LongOperator, DoubleOperator
    {
        // apply is inherited From Function
    }
}
