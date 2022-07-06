package com.specialist.bodrov.oop;

import java.util.ArrayList;
import java.util.Scanner;

public class OOPLab {
    public final static String NEW_HUMAN = "Enter new Human?[e - to exit]";
    public final static String ENTER_NAME = "Enter the name";
    public final static String ENTER_AGE = "Enter the age";

    public static void main(String[] args) {

        ArrayList<Human> people = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        String name;
        String input;


        while (!"e".equals(readLine(scanner, NEW_HUMAN))){
            name = readLine(scanner, ENTER_NAME);
            int age = -1;
            while (age < 0) {
                try {
                    age = Integer.parseInt(readLine(scanner, ENTER_AGE));
                } catch (NumberFormatException e) {
                    System.out.println("Wrong number");
                }

                if (age < 0 || age > 200){
                    System.out.println("Age must be positive and less than 200 years");
                }
            }
            people.add(new Human(name, age));
        }

        for (Human h : people){
            System.out.println(h.getName() + " " + h.getAge());
        }

    }

    public static String readLine(Scanner scanner, String message){
        System.out.println(message);
        return scanner.nextLine();
    }
}
