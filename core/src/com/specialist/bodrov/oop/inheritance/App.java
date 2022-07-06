package com.specialist.bodrov.oop.inheritance;

import java.time.LocalDate;
import java.util.*;

public class App {


    public static void main(String[] args) throws CloneNotSupportedException {
        Circle c = new Circle(0, 10);
        c.setR(10.5);
//        Shape s = new Shape(0 ,3);
        Shape s = c;
//        Circle c1 = s;

        System.out.println(s.getX());
        System.out.println(s.getY());
        System.out.println(c);
        System.out.println(s);

        Object o = new Random().nextBoolean() ? "!!!" : c;
        System.out.println(o);

        System.out.println(Arrays.toString(c.getClass().getDeclaredFields()));
        System.out.println(Arrays.toString(c.getClass()
                .getSuperclass()
                .getDeclaredFields()));

        Shape s1 = new Random().nextBoolean()
                ? new Circle(0, 10, 10)
                : new Rectangle(0,10,20,20);
        System.out.println(s1);
        System.out.println(s1.area());

        System.out.println("---");

        Rectangle r1 = new Rectangle(0, 0, 20, 20);
        System.out.println(r1);
        System.out.println(r1.area());
        r1.scale(2);

        System.out.println(r1);
        System.out.println(r1.area());

        Circle c1 = new Circle(0,0,25);
        System.out.println(c1);
        System.out.println(c1.area());

        c1.scale(0.5);
        System.out.println(c1);
        System.out.println(c1.area());


        System.out.println("---");


        Shape s2 = new Random().nextBoolean()
                ? new Circle(0, 10, 10)
                : new Rectangle(0,10,20,20);

        if (s2 instanceof Rectangle) {
            Rectangle r2 = (Rectangle) s2;
            System.out.println("It's a Rectangle! And it's width=" + r2.getW());
        } else if (s2 instanceof Circle){
            Circle c2 = (Circle)s2;
            System.out.println("Circle! And it's radius=" + c2.getR());
        }

        if (s2 instanceof Scalable){
            System.out.println("It's also instance of Scalable");
        }

        Object o1 = c1;
        o1 = "12412";
        o1 = LocalDate.now();

        Shape s3 = c1;
//        Shape s3 = "235235";
        Scalable scalable = c1;
//        scalable = s3;
        if (s3 instanceof Scalable){
            scalable = (Scalable)s3;
        }


        System.out.println(c1);
        c1.scale();
        System.out.println(c1);

        List<Shape> shapes = new ArrayList<>();
        shapes.add(c1);
        shapes.add(r1);

        for (Shape shape : shapes){
            System.out.println(shape);
        }
        System.out.println("---");

        System.out.println(r1);
        Rectangle r2 = r1.clone();
        System.out.println(r2);
        System.out.println(r1 == r2);
    }


}
