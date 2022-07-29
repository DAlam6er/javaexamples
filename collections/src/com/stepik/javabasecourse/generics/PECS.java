package com.stepik.javabasecourse.generics;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

// класс java.util.Optional
// generic заданный на уровне класса используется для параметризации экземпляра
// поэтому недоступен в статических полях и методах
public final class PECS<T>
{
    // ограничения дженериков в java
    //      1) параметризация возможна только ссылочным типом
    //      2) внутри параметризованного класса или метода
    //          нельзя создавать экземпляр или массив T
    //          не работает проверка instanceof
    //      T obj = new T();                // нельзя
    //      T[] arr = new T[5];             // нельзя
    //      if (obj instance of T) {...}    // нельзя
    // Компилятор это не скомпилирует, т.к. внутри класса
    // про конкретное T с которым создали данный экземпляр ничего не известно

    // скомпилируется,
    // но не проверит, что b действительно является экземпляром T
    // T a = (T) b;

    private final T value;

    private PECS(T value)
    {
        this.value = Objects.requireNonNull(value);
    }

    // Как статический (обязательно) так и не статический (необязательно) можно
    // параметризовать отдельно от класса, объявив generic после модификаторв,
    // но перед именем возвращаемого типа
    // здесь параметр T совсем другое, не то, что указано в заголовке класса!
    public static <T> PECS<T> of(T value)
    {
        return new PECS<>(value);
    }

    public T get()
    {
        if (value == null) {
            throw new NoSuchElementException("No value present");
        }
        return value;
    }

    // Consumer - функциональный интерфейс с методом, принимающим параметр указанного типа
    // Optional<CharSequence> opt;
    // Consumer<Object> consumer;
    // accept - примет любой тип, т.к. consumer параметризован Object'ом,
    // однако
    // opt.ifPresent(consumer) - запрещено из-за несовместимости типов
    public void ifPresent(Consumer<T> consumer)
    {
        if (value != null) {
            consumer.accept(value);
        }
    }
    // Supplier<String> sup;
    // Optional<CharSequence> opt;
    // opt.orElseGet(sup) - тоже не выполнится, из-за несовместимости типов CharSequence и String
    // хотя по смыслу такая операция должна была быть разрешена
    public T orElseGet(Supplier<T> other)
    {
        return value != null ? value : other.get();
    }

    // с компилятором можно "договориться", используя не <T>,
    // а <? super T> или <? extends T>
    // void ifPresent(Consumer<? super T> consumer)
    // - метод принимает Consumer, принимающего объект любого супер-типа T

    // T orElseGet(Supplier<? extends T> other)
    // - метод принимает Supplier, принимающего объект любого подтипа T

    // тип T считается и своим супертипом, и подтипом
    //*********************************************************************
    // PECS: Producer Extends Consumer Super
    // Если нужно получать объекты откуда-то: <? extends T> - ограничены по верхней границе
    // Если нужно отдавать объекты потребителю:   <? super T> - ограничены по нижней границе
    //*********************************************************************
    // Class{n} extends Class{n-1} (Class1 extends Class0)

    // **Producer** является поставщиком данных (может их отдавать):
    // Producer ОТДАЕТ ТОЛЬКО ОБЪЕКТЫ СУПЕРКЛАССОВ
    // этот код скомпилируется
    /*
    public static void someMethod (ListDemo<? extends Class3> list) {
        Class2 class2 = list.get(0);
    }
     */

    // этот код НЕ СКОМПИЛИРУЕТСЯ,
    // т.к. на этапе компиляции неизвестно объекты какого класса будут содержаться в листе
    // Если это будет объект класса Class3,то получится, что
    // мы в переменную класса-потомка пытаемся положить объект класса-предка
    // Это недопустимо
    /*
    public static void someMethod (ListDemo<? extends Class3> list) {
        Class4 class4 = list.get(0);
    }
     */

    // **Producer** НИЧЕГО НЕ ПОЛУЧАЕТ
    //      1) негоже объекту-наследнику ссылаться на объект-предок - поэтому нельзя получить объекты суперклассов
    //         В ListDemo<Integer> list нельзя положить объект, имеющий тип Number.
    //      2) также нельзя получить объекты классов-наследников
    //         В момент компиляции JVM не знает, что во время выполнения программы
    //         будет скрываться под маской ListDemo<? extends Class3>


    // **Consumer** является потребителем данных (может их получать) и ничего не отдает
    // ListDemo<? extends Class3> - на деле может оказаться листом объектов самого «младшего» класса
    // ListDemo<? super Class3> гарантирует, что при любом раскладе
    // в листе будут объекты имеющие тип не «младше» класса Class3 (Class0, Class1, Class2, Class3)

    // этот код скомпилируется
    /*
    public static void someMethod (ListDemo<? super Class3> list) {
        list.add(new Class4());
    }
     */

    // этот код НЕ СКОМПИЛИРУЕТСЯ
    /*
    public static void someMethod (ListDemo<? super Class3> list) {
        list.add(new Class2());
        // т.к. ListDemo<? super Class3> может оказаться ListDemo<Class3>,
        // и попытка добавить предка в лист потомков будет запрещена
    }
     */
    // **Consumer** можеть отдать ТОЛЬКО Object, т.е.
    // Из коллекции, типизированной wildecard с нижней границей,
    // можно получить только объект класса Object
    // Потому что конкретный тип объекта, типизированного wildcard
    // будет известен только в момент выполнения программы,
    // а коллекция, состоящая из объектов-потомков, не может содержать объекты-предки.
    // Этот код НЕ СКОМПИЛИРУЕТСЯ
    /*
    public static void someMethod (ListDemo<? super Class3> list) {
        Class2 obj = list.get(0);
    }
     */
    // во время выполнения программы в метод будет передан ListDemo<Class1>
    // или вообще ListDemo<Object> (оба они соответствуют маске <? super Class3>)
    // а объект-потомок (Class2 obj) будет ссылаться на предка (list.get(0)). - ЧТО НЕДОПУСТИМО
    // Единственный способ этого избежать – получать из такого листа объект,
    // имеющий тип, общий для всех других объектов в Java,
    // то есть объект класса Object.

    // Если всё равно чем параметризован generic: <?>
    // Вопросительный знак говорит компилятору: коллекция чем-то параметризована,
    // но в данном месте кода мы не знаем, чем именно.
    // Чтобы не дать нам случайно нарушить параметризацию коллекции,
    // т.е. добавить в нее объект неправильного класса,
    // компилятор не разрешает ничего добавлять.
    // <?> эквивалентно <? extends Object>
    Optional<?> optional = Optional.of(1);
    Object value1 = optional.get();

    // Когда компилятор не видит конкретное значение generic-параметра T
    // он не может проконтролировать совместимость типов
    // и откажется это компилировать
    //Object value2 = optional.orElse(2);
}
