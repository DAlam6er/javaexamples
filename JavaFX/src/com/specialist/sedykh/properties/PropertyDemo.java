package com.specialist.sedykh.properties;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class PropertyDemo
{
    public static void main(String[] args)
    {
        Person p = new Person();
        // Меняем значение возраста
        p.setAge(20.5);
        // Необходимо увидеть изменение возраста без печати этого факта в main

        // ---------------------------------------------
        DoubleProperty dp = new SimpleDoubleProperty();
        // привязываем свойство dp К свойству age (пользуемся геттером свойства - ageProperty())
        dp.bind(p.ageProperty());
        System.out.println("dp = " + dp.get());

        // java.lang.RuntimeException: A bound value cannot be set.
        // dp.set(10.8);


    }
}

class Person
{
    // SimpleDoubleProperty - заглушка для стандартного свойства
    // готовая реализация с настройками по умолчанию
    // На случай, если мы не хотим создавать свою собственную реализацию
    // и привязывать ее к нужному классу СРАЗУ
    private final DoubleProperty age = new SimpleDoubleProperty();

    // при создании Person в КОНСТРУКТОРЕ будем создавать его с Listener'ом
    public Person()
    {
        // здесь ChangeListener параметризован Number, а не Double
        // DoubleProperty сам накладывает ограничения на ChangeListener<T>
        // т.е. наблюдаемое значение становится другого типа
        // ChangeListener написан для Object, а не для ObjectProperty
        // Представляет собой максимальной близкий к Object
        // и максимально подходящий нам класс - а это Number
        // КОГДА МЫ ПРОГРАММИРУЕМ РЕАЛИЗАЦИЮ ПАРАМЕТРИЗОВАННОГО ИНТЕРФЕЙСА
        // ВСЕГДА ИСПОЛЬЗУЕМ ТОТ КЛАСС, ЧТО БЛИЖЕ ВСЕГО К OBJECT И К НАШЕМУ КЛАССУ ПО СМЫСЛУ
        // Double нельзя, иначе параметризация будет некорректна

        // сначала вызываем InvalidationListener и делаем проверку,
        // если всё ок - вызываем ChangeListener
        age.addListener(new ChangeListener<Number>()
        {
            @Override
            public void changed
                // observableValue - само наблюдаемое значение,
                // oldValue - старое значение
                // newValue - новое значение - будут переданы как результат изменения observableValue
                (ObservableValue<? extends Number> observableValue,
                 Number oldValue, Number newValue)
            {
                System.out.println("oldValue = " + oldValue +
                    ", newValue = " + newValue);
                // observableValue возвращает сами данные в изменении
                System.out.println("observableValue = " + observableValue);
            }
        });
    }

    // Не будем работать с возрастом как со свойством, а как с обычным double
    public double getAge()
    {
        return age.get();
    }

    // геттер для свойства
    // пишем на всякий случай
    // используется только внутри кода, работающего непосредственно с самими свойствами,
    // поэтому это не является нарушением инкапсуляции
    public DoubleProperty ageProperty()
    {
        return age;
    }

    public void setAge(double age)
    {
        this.age.set(age);
    }
}
