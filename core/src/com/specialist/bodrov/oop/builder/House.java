package com.specialist.bodrov.oop.builder;

import java.time.LocalDateTime;

public class House {

    private int walls;
    private int doors;
    private int windows;
    private LocalDateTime creationTime;

    private House(){}

    public static class Builder {

        private House house;

        public Builder(){
            house = new House();
        }

        public Builder setWalls(int walls){
            house.walls = walls;
            return this;
        }

        public Builder setDoors(int doors){
            house.doors = doors;
            return this;
        }

        public Builder setWindows(int windows){
            house.windows = windows;
            return this;
        }

        public House build(){
            house.creationTime = LocalDateTime.now();
            return house;
        }

    }

    public int getWalls() {
        return walls;
    }

    public int getDoors() {
        return doors;
    }

    public int getWindows() {
        return windows;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    @Override
    public String toString() {
        return "House{" +
                "walls=" + walls +
                ", doors=" + doors +
                ", windows=" + windows +
                ", creationTime=" + creationTime +
                '}';
    }
}
