package com.stepik.javabasecourse;

public class GetCallerClassAndMethodName
{
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        m1();
    }

    static void m1() {
        System.out.println(getCallerClassAndMethodName());
        m2();
    }

    static void m2() {
        System.out.println(getCallerClassAndMethodName());
        m3();
    }

    static void m3() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName()
    {
        StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        String ClassMethodName;
        try {
            ClassMethodName = String.format("%s#%s",
                ste[3].getClassName(), ste[3].getMethodName());
        } catch (ArrayIndexOutOfBoundsException ex) {
            ClassMethodName = null;
        }
        return ClassMethodName;
    }
}
