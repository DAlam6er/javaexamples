package com.javarush.favourites.n0509;

/* 
Значения по умолчанию
*/

import java.lang.reflect.Field;

public class GetAllFieldsValuesReflect
{
    public int intVar;
    public double doubleVar;
    public Double DoubleVar;
    public boolean booleanVar;
    public Object ObjectVar;
    public Exception ExceptionVar;
    public String StringVar;

    public static void main(String[] args) {
        GetAllFieldsValuesReflect solution = new GetAllFieldsValuesReflect();
        try {
            for (Field field : solution.getClass().getFields()) {
                System.out.println(field.get(solution));
            }
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }
}
