package com.stepik.javabasecourse.generics;

import java.util.ArrayList;
import java.util.List;

public class PECSDemo
{
    public static void main(String[] args)
    {
        List<? super Exception> consumerExceptions = new ArrayList<>();
        // Эта строка не скомпилируется: если List будет типизирован Exception'ами
        // то невозможно будет добавить в него предков - экземпляров Throwable
        // consumerExceptions.add(new Throwable());

        // Добавлять потомков можно, <? super Exception> гарантирует, что в листе не будет дочерних классов ниже Exception
        consumerExceptions.add(new Exception());
        consumerExceptions.add(new RuntimeException());

        // Эта строка кода не скомпилируется без явного приведения типа - компилятор следит за безопасностью типов
        // Exception exception = consumerExceptions.get(0);
        Object exception = consumerExceptions.get(0);
        Exception exception1 = (Exception) consumerExceptions.get(0);

        List<? extends Exception> supplierExceptions = new ArrayList<>();
        // Эта строка кода не скомпилируется - нельзя добавить в лист потомков ссылку на родительский класс
        // supplierExceptions.add(new Throwable());
        // Эта строка кода не скомпилируется - компилятор не знает, что кроется под <? extends Exception>
        // по его мнению там может лежать какой-нибудь класс, находящийся в самом низу иерархии наследования,
        // что возвращает нас к предыдущему пункту: нельзя в список потомков добавлять ссылку на предка
        //supplierExceptions.add(new RuntimeException());

    }
}
