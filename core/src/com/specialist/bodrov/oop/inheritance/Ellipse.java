package com.specialist.bodrov.oop.inheritance;

import java.util.Objects;

public class Ellipse extends Shape implements Scalable{

    private double r1;
    private double r2;

    public Ellipse(int x, int y) {
        super(x, y);
    }

    public Ellipse(int x,
                   int y,
                   double r1,
                   double r2) {
        super(x, y);
        setR1(r1);
        setR2(r2);
    }

    public double getR1() {
        return r1;
    }

    public void setR1(double r1) {
        this.r1 = r1;
    }

    public double getR2() {
        return r2;
    }

    public void setR2(double r2) {
        this.r2 = r2;
    }

    @Override
    public double area(){
        return Math.PI*getR1()*getR2();
    }

    @Override
    public String toString() {
        return "Ellipse{" +
                "r1=" + getR1() +
                ", r2=" + getR2() +
                ", x=" + getX() +
                ", y=" + getY() +
                '}';
    }

    @Override
    public void scale(double n) {
        setR1(getR1()*n);
        setR2(getR2()*n);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ellipse ellipse = (Ellipse) o;
        return Double.compare(ellipse.getR1(), getR1()) == 0 &&
                Double.compare(ellipse.getR2(), getR2()) == 0 &&
                Double.compare(ellipse.getX(), getX()) == 0 &&
                Double.compare(ellipse.getY(), getY()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getR1(), getR2(), getX(), getY());
    }
}
