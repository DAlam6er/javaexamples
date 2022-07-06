package com.specialist.bodrov.base;

public class SumWithArgs {
    public static void main(String[] args) {
        if (args.length < 2){
            System.out.println("Too few arguments");
        } else {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            System.out.println(a + b);
        }
    }
}
