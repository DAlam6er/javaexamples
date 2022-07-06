package com.headfirstjava.chap16.GenericsExamples;

public class TestGenerics1
{
    public static void main(String[] args)
    {
        new TestGenerics1().go();
    }

    public void go()
    {
        Animal[] animals = {new Dog(), new Cat(), new Cat()};
        Dog[] dogs = {new Dog(), new Dog(), new Dog()};
        // Полиморфизм в действии:
        System.out.println(
            "Ниже передается список животных (как кошек, так и собак):");
        takeAnimals(animals);
        System.out.println(
            "\nНиже передается список собак:");
        // Здесь никакой ошибки не будет
        takeAnimals(dogs);
    }

    // Полиморфический метод - принимает в качестве параметра родителя
    public void takeAnimals(Animal[] animals)
    {
        // Runtime error при передаче методу takeAnimals() массива Dog[]
        // с точки зрения компилятора - всё в порядке
        // animals[0] = new Cat();
        for (Animal animal : animals) {
            // Вызывать можно только те методы,
            // которые были объявлены в классе Animal,
            // т.к. именно он содержит массив, переданный в метод
            animal.eat();
        }
    }
}
