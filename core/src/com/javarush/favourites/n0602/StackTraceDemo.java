package com.javarush.favourites.n0602;

/*
Стек-трейс длиной 10 вызовов
*/

public class StackTraceDemo {
    public static void main(String[] args) {
        //int stackTraceLength = method1().length - method10().length + 1;
        int meth1Len = method1().length;
        int meth10Len = method10().length;
        int stackTraceLength = meth1Len - meth10Len + 1;
        //int stackTraceLength = method1().length;
        System.out.println("method1().length = " + meth1Len);
        System.out.println("method10().length = " + meth10Len);
        System.out.println(
            "Глубина stackTrace = method1().length - method10().length + 1 = "
                + stackTraceLength);
    }

    public static StackTraceElement[] method1() {
        System.out.println("inside method1()");
        return method2();
    }

    public static StackTraceElement[] method2() {
        System.out.println("inside method2()");
        return method3();
    }

    public static StackTraceElement[] method3() {
        System.out.println("inside method3()");
        return method4();
    }

    public static StackTraceElement[] method4() {
        System.out.println("inside method4()");
        return method5();
    }

    public static StackTraceElement[] method5() {
        System.out.println("inside method5()");
        return method6();
    }

    public static StackTraceElement[] method6() {
        System.out.println("inside method6()");
        return method7();
    }

    public static StackTraceElement[] method7() {
        System.out.println("inside method7()");
        return method8();
    }

    public static StackTraceElement[] method8() {
        System.out.println("inside method8()");
        return method9();
    }

    public static StackTraceElement[] method9() {
        System.out.println("inside method9()");
        return method10();
    }

    public static StackTraceElement[] method10() {
        StackTraceElement[] traceElement = Thread.currentThread().getStackTrace();
        System.out.printf(
            "\nInside meth10. traceElement.length = %s. " +
                "Content of StackTrace:\n", traceElement.length);
        for (StackTraceElement stackTraceElement : traceElement) {
            System.out.println(stackTraceElement);
        }
        return traceElement;
    }
}
