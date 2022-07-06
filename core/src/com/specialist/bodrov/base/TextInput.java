package com.specialist.bodrov.base;

import java.util.Scanner;

public class TextInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        int age;
        while (true){
            System.out.println("Enter the name?");
            name = scanner.nextLine();
            System.out.println("Enter the age?");
            age = Integer.parseInt(scanner.nextLine());
            System.out.println(name + " " + age);
            if ("exit".equals(name))
                break;
        }
    }
}
