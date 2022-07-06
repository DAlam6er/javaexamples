package com.specialist.bodrov.homework.MyArrayList;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    /* Testing of MyIntList implementation */
    public static void main(String[] args) {
        String n;
        Scanner in = new Scanner(System.in);
        MyIntList mylist = new MyIntList();

        // testing .add() method implementation
        System.out.println("Input integer elements of the list, 'e' to stop:");
        while (true) {
            n = in.nextLine();
            if ("e".equals(n)) {
                break;
            }
            mylist.add(Integer.parseInt(n));
        }

        // testing .add(index, el) method implementation
        mylist.add(2,999);
        System.out.println(
            "Content of the list:\n" + Arrays.toString(mylist.toArray()));

        // testing .size() method implementation
        System.out.println(
            "Size of the resulting list is " + mylist.size());

        // testing .get() method implementation
        System.out.print("Input index of the element to get: ");
        System.out.println(
            "Required element is " + mylist.get(in.nextInt()));

        // testing .remove() method implementation


    }
}
