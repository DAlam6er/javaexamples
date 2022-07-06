package com.javarush.favourites.n0605;

/* 
Аэропорт
*/

import java.util.concurrent.TimeUnit;

public class Aeroport
{
    public static volatile Runway RUNWAY = new Runway();   // взлетная полоса

    public static void main(String[] args) throws InterruptedException {
        new Plane("Самолет #1");
        new Plane("Самолет #2");
        new Plane("Самолет #3");
    }

    private static void waiting() {
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void takingOff() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) { }
    }

    public static class Plane extends Thread {
        public Plane(String name) {
            super(name);
            start();
        }

        @Override
        public void run() {
            boolean isAlreadyTakenOff = false;
            while (!isAlreadyTakenOff) {
                // если взлетная полоса свободна, занимаем ее
                if (RUNWAY.trySetTakingOffPlane(this)) {
                    System.out.println(getName() + " взлетает");
                    takingOff();// взлетает
                    System.out.println(getName() + " уже в небе");
                    isAlreadyTakenOff = true;
                    RUNWAY.setTakingOffPlane(null);
                // если взлетная полоса занята самолетом
                } else if (!this.equals(RUNWAY.getTakingOffPlane())) {
                    System.out.println(getName() + " ожидает");
                    waiting(); // ожидает
                }
            }
        }
    }

    public static class Runway { // взлетная полоса
        private Thread t;

        public Thread getTakingOffPlane() {
            return t;
        }

        public void setTakingOffPlane(Thread t) {
            synchronized (this) {
                this.t = t;
            }
        }

        public boolean trySetTakingOffPlane(Thread t) {
            synchronized (this) {
                if (this.t == null) {
                    this.t = t;
                    return true;
                }
                return false;
            }
        }
    }
}

