package com.specialist.sedykh.interfaces;

import java.util.Arrays;

public class InterfaceDemo
{
    public static void main(String[] args)
    {
        Box[] boxes = {
            new Box(10,1,1),
            new Box(1,10,10),
            new Box(2,2,2)
        };

        Arrays.sort(boxes); // volume: using override "compareTo" implementing Comparable
        for (Box box : boxes) {
            System.out.println(box);
        }

        //by A: using Inner class implementing Comparator
//        Box.CompareByA cmp = new Box(0,0,0).new CompareByA();
//        Arrays.sort(boxes, cmp);

        //by A: using STATIC Inner class implementing Comparator
//        Arrays.sort(boxes, new Box.CompareByA());

        // by A: using local class
        // by A: using anonymous class inside method compareByA()
//        Arrays.sort(boxes, Box.compareByA());

        // by A: using anonymous class as an argument
//        Arrays.sort(boxes, new Comparator<Box>()
//        {
//            @Override
//            public int compare(Box b1, Box b2)
//            {
//                return b1.getA() - b2.getA();
//            }
//        });

        // by A: using lambda expression
        Arrays.sort(boxes, (b1, b2) -> b1.getA() - b2.getA());

        for (Box box : boxes) {
            System.out.println(box);
        }
    }
}
