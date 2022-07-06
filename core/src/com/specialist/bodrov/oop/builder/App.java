package com.specialist.bodrov.oop.builder;

public class App {


    public static void main(String[] args) {

        House house = new House.Builder()
                .setDoors(1)
                .setWalls(4)
                .setWindows(2)
                .build();

        System.out.println(house);
    }

}
