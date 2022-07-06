package com.specialist.bodrov.oop.inheritance;

import java.util.ArrayList;

public class Lab {

    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(0,0,25));
        shapes.add(new Square(10, 10, 50));
        shapes.add(new Point(15,15));

        for (Shape s : shapes){
            System.out.println(s);
        }

        for (Shape s : shapes){
            if (s instanceof Scalable ) {
                Scalable scalable = (Scalable) s;
                scalable.scale(2);
            }
        }
        System.out.println("---");

        for (Shape s : shapes){
            System.out.println(s);
        }



    }
}
