package com.specialist.bodrov.oop.intarraylist;

public class App {

    public static void main(String[] args) {

            IntArrayList list = new IntArrayList();
            IntArrayList list2 = new IntArrayList();

            System.out.println(list);
            list.add(0);
            list.add(1);
            list.add(2);
            System.out.println(list);
            list.remove(0);
            System.out.println(list);
            list.add(3);
            list.add(4);
            System.out.println(list);
            list.remove(2);
            System.out.println(list);
            list.add(5);
            System.out.println(list);
            System.out.println(list.get(3));
            list.remove(3);
            System.out.println(list);

            list = new IntArrayList();
//            list.get(3);

            list2.add(9);
            list2.add(9);
            list2.add(9);

            System.out.println(list2);


    }
}
