package com.headfirstjava.chap07.visibility.outpackage;

import com.headfirstjava.chap07.visibility.inpackage.ParentClass;

public class SubClass extends ParentClass
{
    public static void main(String[] args)
    {
        SubClass subClass = new SubClass();
        //System.out.println(subClass.privateField); // NOK
        //System.out.println(subClass.defaultField); // NOK
        System.out.println(subClass.protectedField); // OK
        System.out.println(subClass.publicField); // OK

    }

    private void subMethod()
    {
        // this.privateMethod(); // private method NOK
        this.protectedMethod(); // OK
        protectedMethod(); // OK
        ParentClass parentClass = new ParentClass();
        //parentClass.privateMethod(); // private method NOK
        // Дочерний класс за пределами пакета не имеет доступа
        // к защищенным методам, но может получить эти методы
        // в результате наследования
        //parentClass.protectedMethod(); // protected method NOK
        parentClass.publicMethod(); // OK
    }
}
