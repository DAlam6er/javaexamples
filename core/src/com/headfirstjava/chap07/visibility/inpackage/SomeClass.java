package com.headfirstjava.chap07.visibility.inpackage;

public class SomeClass
{
    public static void main(String[] args)
    {
        ParentClass parentClass = new ParentClass();
        //System.out.println(subClass.privateField); // NOK
        System.out.println(parentClass.defaultField); // OK
        System.out.println(parentClass.protectedField); // OK
        System.out.println(parentClass.publicField); // OK
    }
}
