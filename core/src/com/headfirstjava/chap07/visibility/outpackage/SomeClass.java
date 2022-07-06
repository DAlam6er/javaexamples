package com.headfirstjava.chap07.visibility.outpackage;

import com.headfirstjava.chap07.visibility.inpackage.ParentClass;

public class SomeClass
{
    public static void main(String[] args)
    {
        ParentClass parentClass = new ParentClass();
        //System.out.println(subClass.privateField); // NOK
        //System.out.println(parentClass.defaultField); // NOK
        //System.out.println(parentClass.protectedField); // NOK
        System.out.println(parentClass.publicField); // OK
    }
}
