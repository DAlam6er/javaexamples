package headfirstjava.chap16.GenericsExamples;

import java.util.ArrayList;

public class TestGenerics2
{
    public static void main(String[] args)
    {
        new TestGenerics2().go();
    }

    public void go()
    {
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Dog());
        animals.add(new Cat());
        animals.add(new Dog());
        takeAnimals(animals);

        ArrayList<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        dogs.add(new Dog());

        // Ошибка времени компиляции
        // ArrayList<Dog> cannot be converted to ArrayList<Animal>
        // NOK - incompatible types!!
        // takeAnimals(dogs);
    }

    // Полиморфический метод - принимает в качестве параметра родителя
    public void takeAnimals(ArrayList<Animal> animals)
    {
        // Если бы компилятор разрешал методу принимать ArrayList<Dog>
        // то возникала бы опасность, что в методе takeAnimals()
        // кто-то мог бы написать что-нибудь типа:
        // animals.add(new Cat());
        // - что привело бы к ситуации,
        // когда передаём список собак, а в списке откуда-то взялась кошка
        // т.о. обеспечивается БЕЗОПАСНОСТЬ типов
        for (Animal animal : animals) {
            animal.eat();
        }
    }
}
