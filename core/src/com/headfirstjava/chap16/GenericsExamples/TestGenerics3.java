package com.headfirstjava.chap16.GenericsExamples;

import java.util.ArrayList;

public class TestGenerics3
{
    public static void main(String[] args)
    {
        new TestGenerics3().go();
    }

    public void go()
    {
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Dog());
        animals.add(new Cat());
        animals.add(new Dog());
        System.out.println(
            "Ниже передается список животных (как кошек, так и собак):");
        takeAnimals(animals);

        ArrayList<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        dogs.add(new Dog());
        System.out.println(
            "\nНиже передается список собак:");
        takeAnimals(dogs);
    }

    /*
    Способ создать аргумент для метода, способного принимать
    ArrayList любого дочернего от Animal типа
    с помощью заполнителя
    */
    //public void takeAnimals(ArrayList<? extends Animal> animals)
    // Альтернативный синтаксис (удобен при использовании 2 и более аргументов):
    public <T extends Animal> void takeAnimals(ArrayList<T> animals)
    {
        // Ошибка времени компиляции!
        // incompatible types:
        // Cat cannot be converted to capture#1 of ? extends Animal
        // animals.add(new Cat());
        for (Animal animal : animals) {
            animal.eat();
        }
    }
}
