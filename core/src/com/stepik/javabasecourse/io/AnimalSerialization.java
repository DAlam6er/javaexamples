package com.stepik.javabasecourse.io;

import java.io.*;
import java.util.Objects;

public class AnimalSerialization
{
    public static void main(String[] args)
    {
        Animal[] animalM1 = {
            new Animal("Cat"), new Animal("Dog"), new Animal("Elephant"),
            new Animal("Cock"), new Animal("Bull"), new Animal("Ant"),
            new Animal("Tentecles"), new Animal("Worm")
        };
        System.out.println("Размер исходного массива: " + animalM1.length);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeInt(animalM1.length);
            for (Animal animal : animalM1) {
                oos.writeObject(animal);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Animal[] animalM2 = deserializeAnimalArray(bos.toByteArray());
        System.out.println("Размер десериализованного массива: " +
            animalM2.length);
        System.out.println("Содержимое десериализованного массива:");
        for (Animal animal : animalM2) {
            System.out.println("\t" + animal);
        }
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        Animal[] animals = null;
        try (ObjectInputStream ois =
                 new ObjectInputStream(new ByteArrayInputStream(data))) {
            animals = new Animal[ois.readInt()];
            for (int i = 0; i < animals.length; i++) {
                animals[i] = (Animal) ois.readObject();
            }
        } catch (IOException | ClassNotFoundException |
                 ClassCastException | NullPointerException e) {
            throw new IllegalArgumentException(e);
        }
        return animals;
    }

    static class Animal implements Serializable
    {
        private final String name;

        public Animal(String name)
        {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj)
        {
            if (obj instanceof Animal) {
                return Objects.equals(name, ((Animal) obj).name);
            }
            return false;
        }

        @Override
        public String toString()
        {
            return name;
        }
    }
}
