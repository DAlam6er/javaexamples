package com.stepik.javabasecourse.datatypes;
// В Григорианском календаре год является високосным в двух случаях:
// либо он кратен 4, но при этом не кратен 100, либо кратен 400.
// Реализуйте метод, вычисляющий количество високосных лет
// с начала нашей эры (первого года) до заданного года включительно.
public class LeapYearCount
{
    public static void main(String[] args)
    {
        System.out.println(leapYearCount(2022));
    }

    public static int leapYearCount(int year) {
        return year/4 - year/100 + year/400;
    }
}
