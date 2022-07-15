package com.stepik.javabasecourse.functionalinterfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class Demo2
{
    // Способы инстанцирования функционального интерфейса:
    // 1. Объявить класс (в случае переиспользования в коде несколько раз)
    class IntSquare implements IntUnaryOperator
    {
        @Override
        public int applyAsInt(int operand)
        {
            return operand * operand;
        }
    }

    public static void main(String[] args)
    {
        // 2. Использовать лямбда-выражение
        // Компилятор знает ожидаемый интерфейс,
        // поэтому не требует повторения имени интерфейса, метода,
        // типов параметров, типов возвращаемого значения справа от знака =
        IntUnaryOperator square1 = x -> x * x;
        IntUnaryOperator square2 = x -> {
            // тело метода
            return x * x;
        };

        IntConsumer print = x -> System.out.print(x);
        IntUnaryOperator cube = x -> x * x * x;

        int a = 15;
        System.out.printf("Куб %d равен %d\n", a, cube.applyAsInt(a));

        // К каким переменным можно обращаться внутри лямбда-выражения:
        //      к параметрам лямбды
        //      объявлять и обращаться к созданным переменным внутри тела лямбды
        //      к полям класса, внутри котого объявлена лямбда (чтение + запись)
        //      к переменным того метода, где создана лямбда (переменные обязаны быть ЭФФЕКТИВНО ФИНАЛЬНЫМИ) - только чтение
        //      то есть значение у таких переменных должно быть присвоено
        //      ровно 1 раз до создания лямбды, после чего меняться оно уже не может
        //      отсюда следует, что из лямбды нельзя присваивать новые значения переменным, содержащего его метода
        class Test
        {
            private int counter;

            public void foo()
            {
                IntUnaryOperator square = x -> x * x;
                IntSupplier sequence = () -> counter++;
                int bonus = 10;
                IntUnaryOperator bonusAdder = (x) -> x + bonus;
                // чтобы обойти ограничение на изменение переменной, используют трюк с массивом единичной длины
                // ссылка на массив является эффективно финальной, однако на содержимое массива это не распространяется
                int[] counter = new int[]{0};
                IntSupplier sequence2 = () -> counter[0]++;
            }
        }

        LinkToMethod();
        defaultMethods();
    }

    public static void LinkToMethod()
    {
        // 3. Инстанцировать функциональный интерфейс с помощью ссылки на метод
        // ссылаемся на статический метод Класс::имяСтатическогоМетода
        ToIntFunction<String> intParser = Integer::parseInt;
        System.out.println(intParser.applyAsInt("12"));

        // ссылаемся на НЕстатический метод Объект::имяНестатическогоМетода
        Consumer<Object> printer = System.out::println;
        printer.accept("Тестовая строка");

        // ещё один способ сослаться на нестатический метод
        // Класс::имяНестатическогоМетода
        // но тогда первый передаваемый в месте вызова функционального интерфейса параметр
        // будет тем самым объектом, на которым данный нестатический метод будет вызван
        Function<Object, String> objectToString = Object::toString;
        List<String> list = Arrays.asList("a", "b", "c");
        System.out.println(objectToString.apply(list));

        // ссылаемся на конструктор Класс::new
        IntFunction<String[]> arrayAllocator = String[]::new;
    }

    // Default-методы функциональных интерфейсов позволяют получить интересный функционал
    public static void defaultMethods()
    {
        // Проверка на нечетность
        IntPredicate isOdd = x -> x % 2 != 0;
        // Проверка на четность - обратный предикату isOdd
        IntPredicate isEven = isOdd.negate();

        // IntPredicate p1 = ..., p2 = ...;
        // IntPredicate p3 = p1.and(p2);

        List<Object> objects = new ArrayList<>();
        // Consumer #1
        Consumer<Object> collector = objects::add;

        // Consumer #2
        Consumer<Object> printer = System.out::println;

        // Объединенный Consumer - будет выполнен сначала первый, потом второй
        Consumer<Object> combinedConsumer = collector.andThen(printer);

        combinedConsumer.accept(42);

        // Отличие andThen от compose
        DoubleUnaryOperator square = x -> x * x;
        DoubleUnaryOperator sin = Math::sin;

        DoubleUnaryOperator complexFunction1 = sin.andThen(square); // sin^2(x)
        DoubleUnaryOperator complexFunction2 = sin.compose(square); // sin(x^2)

        // Функция сравнения двух аргументов, по их абсолютной величине
        // Вариант 1
        Comparator<Double> absoluteValueComparator =
            (a, b) -> Double.compare(Math.abs(a), Math.abs(b));
        System.out.println(absoluteValueComparator.compare(-13d, 4d)); // 1

        // Вариант 2
        // Math::abs - будет применяться к каждому элементу перед сравнением
        // Double::compare - будет применяться к результатам предыдущего метода
        // для получения финального результата
        Comparator<Double> absoluteValueComparator2 =
            Comparator.comparing(Math::abs, Double::compare);
    }
}
