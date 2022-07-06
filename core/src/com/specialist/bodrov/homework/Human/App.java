package com.specialist.bodrov.homework.Human;

import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    public final static String NEW_HUMAN =
        "Enter a new human [e - to exit]: ";
    public final static String ENTER_SURNAME =
        "Enter the surname of the new human:";
    public final static String ENTER_NAME =
        "Enter the name of the new human:";
    public final static String ENTER_PATRONYMIC =
        "Enter the patronymic of the new human:";
    public final static String ENTER_SEX =
        "Enter the sex of the new human:";
    public final static String ENTER_DOB =
        "Enter the date of birth of the new human (format \"dd.MM.yyyy\"):";
    public static void main(String[] args)
    {
        ArrayList<Human> people = new ArrayList<>();
        Scanner scanner = null;
        String surname, name, patronymic, sex, dob;
        try {
            scanner = new Scanner(System.in);
            while(!"e".equals(readline(scanner, NEW_HUMAN,false))) {
                surname = readline(scanner, ENTER_SURNAME, true);
                name = readline(scanner, ENTER_NAME, true);
                patronymic = readline(scanner, ENTER_PATRONYMIC, true);
                sex = readline(scanner, ENTER_SEX, true);
                dob = readline(scanner, ENTER_DOB,true);
                people.add(new Human(surname, name, patronymic, sex, dob));
            }
            System.out.println("\nContent of the list \"People\":");
            for (Human h : people) {
                System.out.println(h.toString());
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (scanner != null)
                scanner.close();
        }
    }

    public static String readline(Scanner scanner, String message, boolean newline)
    {
        if (newline) {
            System.out.println(message);
        } else {
            System.out.print(message);
        }
        return scanner.nextLine();
    }
}
