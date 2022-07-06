package com.specialist.bodrov.oop.inheritance;


public class Circle extends Ellipse implements Comparable<Circle>{

    public Circle(int x, int y) {
        super(x, y);
    }

    public Circle(int x, int y, double r) {
        super(x, y, r, r);
    }

    public double getR() {
        return getR1();
    }

    public void setR(double r) {
        setR1(r);
        setR2(r);
    }


    @Override
    public String toString() {
        return "Circle{" +
                "r=" + getR() +
                ", x=" + getX() +
                ", y=" + getY() +
                "}";
    }


    @Override
    public int compareTo(Circle o) {
        return (int)(getR() - o.getR());
    }
}
