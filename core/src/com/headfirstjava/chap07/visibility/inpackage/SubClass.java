package com.headfirstjava.chap07.visibility.inpackage;

public class SubClass extends ParentClass
{
    public static void main(String[] args)
    {
        SubClass subClass = new SubClass();
        //System.out.println(subClass.privateField); // NOK
        System.out.println(subClass.defaultField); // OK
        System.out.println(subClass.protectedField); // OK
        System.out.println(subClass.publicField); // OK
    }
}
