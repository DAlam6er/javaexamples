package com.headfirstjava.chap16.GenericsExamples;

import java.util.ArrayList;
import java.util.List;

public class TestGenerics4
{
    public static void main(String[] args)
    {
        // ArrayList<Dog> dogs1 = new ArrayList<Animal>();    // Complile error
        // ArrayList<Animal> animals1 = new ArrayList<Dog>(); // Complile error
        List<Animal> list = new ArrayList<Animal>();
        ArrayList<Dog> dogs = new ArrayList<Dog>();
        // ArrayList<Animal> animals = dogs;                  // Complile error
        List<Dog> dogList = dogs;
        ArrayList<Object> objects = new ArrayList<Object>();
        List<Object> objList = objects;
        // ArrayList<Object> objs = new ArrayList<Dog>();     // Complile error
        // dogList = list;                                    // Complile error
        // list = dogList;                                    // Complile error
    }
}
