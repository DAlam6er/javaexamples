package com.specialist.bodrov.oop.inheritance;

import java.time.LocalDate;

public class Rectangle extends Shape implements Scalable, Cloneable {

    private double w;
    private double h;
    private LocalDate date;


    public Rectangle(int x,
                     int y,
                     double w,
                     double h) {
        super(x, y);
        setW(w);
        setH(h);
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    @Override
    public double area(){
        return getW()*getH();
    }

    @Override
    public void scale(double factor) {
        setW(getW()*factor);
        setH(getH()*factor);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "w=" + getW() +
                ", h=" + getH() +
                ", x=" + getX() +
                ", y=" + getY() +
                '}';
    }

    @Override
    protected Rectangle clone() throws CloneNotSupportedException {
        return (Rectangle)super.clone();
    }
}
