package com.eduprof.tikhomirov.pool;

import java.util.Arrays;
import java.util.Scanner;

public class Pool
{
    private double a;
    private double b;
    private double c;

    public Pool(double a, double b, double c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Pool(double[] dimensions)
    {
        this.a = dimensions[0];
        this.b = dimensions[1];
        this.c = dimensions[2];
    }

    public double getA()
    {
        return a;
    }

    public void setA(int a)
    {
        this.a = a;
    }

    public double getB()
    {
        return b;
    }

    public void setB(int b)
    {
        this.b = b;
    }

    public double getC()
    {
        return c;
    }

    public void setC(int c)
    {
        this.c = c;
    }

    public double getVolume()
    {
        return getA() * getB() * getC();
    }
}

class App
{
    public static void main(String[] args)
    {
        System.out.println(
            "Input pool dimensions [axbxc] in meters:");

        double[] dimensions = getFromScan();
        if (dimensions.length != 3) {
            System.out.println("Invalid number of arguments");
            return;
        }

        Pool pool = new Pool(dimensions);
        System.out.printf(
            "Volume of the pool: %.2f [liters]\n", 1e3 * pool.getVolume());
    }

    private static double[] getFromScan()
    {
        String str = new Scanner(System.in).nextLine();
        double[] numbers = new double[0];
        try {
            numbers =
                Arrays.stream(str.split("[\s,;xх]+"))
                    .mapToDouble(Double::parseDouble).toArray();
        } catch (NumberFormatException e) {
            System.out.println("Wrong data!");
        }
        return numbers;
    }
}