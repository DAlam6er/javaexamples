package com.specialist.sedykh.polymorph;

public class PolymorphDemo
{
    public static void main(String[] args)
    {
        Rect r1 = new Rect(-3, 2, 2, 3, "Rectangle-0");
        Circle c1 = new Circle(2, -1, 10, "Circle-0");

//        System.out.println(r1);
//        System.out.println(c1);

        Shape[] shapes =
            {r1, c1, new Rect(2,4, 1,5, "Rectangle-1")};

        for (Shape shape : shapes) {
            System.out.println(shape);
        }

//        printAreas(shapes);
        for (Shape shape : shapes) {
            System.out.println(shape.area());
        }
    }

    private static void printAreas(Shape[] shapes)
    {
        for (Shape shape : shapes) {
            if (shape instanceof Rect) {
                System.out.println(((Rect) shape).area());
            } else if (shape instanceof Circle) {
                System.out.println(((Circle) shape).area());
            }
        }
    }
}
