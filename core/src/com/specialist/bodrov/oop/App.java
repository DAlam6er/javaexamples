package com.specialist.bodrov.oop;

public class App {

    public static void main(String[] args) {
//        Class.forName("ru.specialist.java.oop.Human");
        Human ivan = new Human();
        ivan.setName("Ivan");
        ivan.setAge(30);

        Human masha = new Human("Masha", 25);


        System.out.println(ivan);
        System.out.println(ivan.getName() + " " + ivan.getAge());
        ivan.sayName();

        System.out.println(masha);
        System.out.println(masha.getName() + " " + masha.getAge());
        masha.sayName();

        Human igor = new Human("Igor");
        System.out.println(igor.getName() + " " + igor.getAge());
        System.out.println("---");


        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1 == s2);



    }
}
