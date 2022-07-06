package com.specialist.bodrov.base;



public class Methods {

    public static void main(String[] args) {
        int result = sum(2,2);
        System.out.println();
        System.out.println(hello("Victor"));
        System.out.println(hello());
        System.out.println(hello("Admin", "Guest"));
        System.out.println(hello("Admin", "Guest","Victor","!!!","wegfweg"));

        int number = 9;
        increment(number);
        System.out.println("number= " +number);

        Int num = new Int();
        num.value = 9;
        increment(num);
        System.out.println("num= " + num.value);
    }

    public static int sum(int a, int b){
        return a + b;
    }

    public static String hello(String name){
        return "Hola, " + name + "!";
    }

    public static String hello(){
        return hello("user");
    }

    public static String hello(String name1, String name2){
        return hello(name1 + ", "+ name2);
    }

    public static String hello(String... names){
        return hello(String.join(", ", names));
    }

    public static void increment(int n){
        ++n;
    }

    public static void increment(Int n){
        n.value++;
    }
}

class Int {
    int value;
}