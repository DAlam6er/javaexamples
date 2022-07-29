package com.specialist.sedykh.observable_collection;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Objects;

public class Demo
{
    public static void main(String[] args)
    {
        // Старую программу переводим в новую программу на JavaFX
        // Переписываем её блоками, выкидывая по частям старую логику

        // Дано: старая коллекция, хранящая людей
        ArrayList<Person> oldList = new ArrayList<>();
        // В старую коллекцию продолжают вноситься данные
        oldList.add(new Person("Name1", 20));
        oldList.add(new Person("Name2", 30));

        // Необходимо добавить новую современную коллекцию
        // Внос данных и удаление осуществлялось через новую коллекцию
        // Но для работы некой математики, привязанной к старой коллекции
        // осуществлялось еще и обновление oldList
        ObservableList<Person> fxList = FXCollections.observableArrayList(oldList);
        // Создадим слушателя - продолжение концепции MVC

        // InvalidationListener - это обработчик события,
        // кот. вызывается каждый раз, когда изменяется коллекция,
        // и когда изменение коллекции может привести к ее некорректном наполнению
        // т.е. он проверяет, корректные ли данные были введены
        // fxList.addListener(new InvalidationListener() listener);
        fxList.addListener(new ListChangeListener<>()
        {
            // аргумент метода - произошедшее изменение.
            // Change - это коллекция изменений, РАЗБИТЫХ ПО ГРУППАМ,
            // т.е. это ГРУППА изменений, а не единичное изменение
            @Override
            public void onChanged(Change<? extends Person> change)
            {
                // снаружи while работаем со всей коллекцией change
                while (change.next()) {
                    // внутри while работаем с отдельным элементом коллекции
                    // это упрощение for-each
                    // Внутри каждого события смотрим, что было добавлено, а что было удалено
                    // Change сам по себе разбит на события,
                    // внутри каждого события есть то, что было добавлено
                    // и то, что было удалено
                    // и добавленных и удаленных данных МНОГО
                    // Таким образом, change - список СПИСКОВ изменений
                    // Н-р подключились 3 клиента, каждый из которых что-то удалил и добавил
                    // Имеем 3 элемента коллекции, каждый элемент представляет из себя ГРУППУ событий
                    if (change.wasAdded()) {
                        //.getAddedSubList() возращает подсписок добавленных в change элементов
                        for (Person person : change.getAddedSubList()) {
                            // person передается по ссылке.
                            // может оказаться так, что старый код несовместим с новым
                            // и может получиться так,
                            // что если в новом коде будут удаляться данные,
                            // то они по ссылке удалятся и из старого кода
                            // что приведёт к некорректной работе кода.
                            //oldList.add(person);

                            // будем передавать данные вручную!
                            // создадим КОПИЮ передаваемого объекта
                            // чтобы разорвать связь между новыми и старыми данными
                            // и избежать ситуации, когда одни и те же данные хранятся в старой и новой коллекции
                            oldList.add(new Person(person.name, person.age));
                        }
                    } else if (change.wasRemoved()) {
                        for (Person person : change.getRemoved()) {
                            int i = 0;
                            // в реальной БД будем искать по индексу
                            for (Person p : oldList) {
                                if (p.equals(person)) {
                                    break;
                                }
                                i++;
                            }
                            // Обработка ситуации, когда в старом списке
                            // человек, удаленный из нового списка не найден
                            if (i == oldList.size()) {
                                System.out.println("Person was not found!");
                                break;
                            }
                            oldList.remove(i);
                            System.out.println("Removed: " + person);
                        }
                    }
                }
            }
        });

        fxList.add(new Person("NewName", 33));
        fxList.remove(0);
        // Изменение возраста не является изменением коллекции
        // человек с индексом (0) хранится в новом списке по ссылке,
        // поэтому в старом списке его возраст тоже изменится!
        fxList.get(0).age++;        // было 30, стало 31
        // человек с индексом (2) хранится в новом списке по значению,
        // поэтому в старом списке его возраст НЕ изменится!
        fxList.get(1).age++;

        // Математика: вывод данных на экран через СТАРУЮ КОЛЛЕКЦИЮ
        System.out.println("Old collection:");
        for (Person person : oldList) {
            System.out.println(person);
        }

        // для отладки
        System.out.println("\nNew collection:");
        for (Person person : fxList) {
            System.out.println(person);
        }
    }
}

// Вспомогательный класс - имитация БД
// БД - массив ЗАПИСЕЙ (или структура)
// Запись - набор РАЗНОТИПНЫХ данных
// В понятии Запись данные называются ПОЛЯМИ
// с Java 1.17 вернули понятие структуры - Record
// Запись в Java - еще одна разновидность класса.
class Person
{
    String name;
    int age;

    // Для отладки
    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    // Для отладки-вывода
    @Override
    public String toString()
    {
        return "Person{" + "name=" + name + ", age=" + age + '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, age);
    }
}
