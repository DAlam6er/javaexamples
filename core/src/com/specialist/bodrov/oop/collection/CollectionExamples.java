package com.specialist.bodrov.oop.collection;

import com.specialist.bodrov.oop.datetime.Color;
import com.specialist.bodrov.oop.inheritance.Circle;

import java.util.*;

public class CollectionExamples {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(-5);
        arrayList.add(999);

        System.out.println(arrayList);

        Iterable<Integer> iterable = arrayList;
        Iterator<Integer> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        for (Integer integer : iterable) {
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.println("---");

        Collection<Integer> collection = arrayList;
        iterable = collection;

        collection.add(123);
        System.out.println(collection.size());
        collection.remove(1);
        System.out.println(collection);
        System.out.println(collection.contains(999));
        System.out.println("---");

        List<Integer> list = arrayList;
        Collections.sort(list);
        System.out.println(list);

        System.out.println(list.get(1));
        System.out.println(list.add(1));
        System.out.println(list);

        list.remove(1);
        System.out.println(list);
        list.remove((Object) 1);
        System.out.println(list);
        System.out.println("---");

        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(1);
        deque.push(2);
        deque.push(3);
        System.out.println(deque);
        System.out.println(deque.pop());
        System.out.println(deque.pop());
        deque.push(9);

        System.out.println(deque);
        System.out.println("---");

        Map<String, Integer> map = new HashMap<>();
        map.put("Lisa", 235235);
        map.put("John", 36346);
        map.put("John", 999);

        System.out.println(map);
        System.out.println(map.get("Lisa"));
        System.out.println("---");

        Map<Circle, Color> circleMap = new HashMap<>();
        circleMap.put(new Circle(1, 1, 1), Color.RED);
        circleMap.put(new Circle(2, 2, 2), Color.YELLOW);

        System.out.println(circleMap.get(new Circle(1, 1, 1)));
        System.out.println("---");

        Set<String> names = new HashSet<>();

        names.add("John");
        names.add("Lisa");
        names.add("Lisa");

        System.out.println(names.contains("John"));
        System.out.println(names.contains("Vasya"));

        System.out.println(names);


        Set<Circle> circles = new TreeSet<>();
        circles.add(new Circle(53, 45, 5));
        circles.add(new Circle(14, 11, 1));
        circles.add(new Circle(13, 63, 3));
        circles.add(new Circle(-34, 2345, 2));
        circles.add(new Circle(43, 55, 4));

        System.out.println(circles);
        System.out.println(circles.contains(new Circle(14, 11, 1)));

        System.out.println("Hello".hashCode());
        System.out.println("Helol".hashCode());


    }

}
