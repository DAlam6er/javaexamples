package com.headfirstjava.chap16.GenericsExamples;

abstract class Animal
{
    void eat()
    {
        System.out.println("Животное ест.");
    }
}

class Dog extends Animal
{
    void bark() { }
}

class Cat extends Animal
{
    void meow() { }
}
