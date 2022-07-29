package com.stepik.javabasecourse.generics;

import java.util.Optional;

public class GenericRestrictions<X>
{
    public static void main(String[] args)
    {
        GenericRestrictions gr = new GenericRestrictions();
        gr.someMethod(new Object());
    }

    public void someMethod(Object obj)
    {
        // 'Object' cannot be safely cast to 'X'
        // boolean b2 = (obj instanceof X);

        // 'Object' cannot be safely cast to 'Optional<X>'
        // у компилятора нет возможности это проверить при компиляции, а
        // у виртуальной машины нет возможности это проверить во время исполнения.
        // boolean b1 = (obj instanceof Optional<X>);

        // Type parameter 'X' cannot be instantiated directly
        //X x5 = new X();

        // Unchecked cast: 'java.lang.Object' to 'X'
        X x1 = (X) obj;
        // Здесь объявляется только ссылка параметризованного типа, без создание экземпляра
        X x2;
        Optional<X> x3 = Optional.empty();
        // Здесь объявляется только ссылка на массив, но без создания экземпляра массива
        X[] x4;

    }
}
