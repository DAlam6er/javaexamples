package com.javarush.favourites.n0605;

/* 
Big Ben clock
*/

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class LondonClock
{
    public static volatile boolean isStopped = false;

    public static void main(String[] args) throws InterruptedException {
        new Clock("Лондон", 23, 59, 57);
        Thread.sleep(4_000);
        isStopped = true;
        Thread.sleep(1_000);
    }

    public static class Clock extends Thread {
        private final String cityName;
        private int hours;
        private int minutes;
        private int seconds;

        public Clock(String cityName, int hours, int minutes, int seconds)
        {
            this.cityName = cityName;
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
            start();
        }

        @Override
        public void run() {
            try {
                while (!isStopped) {
                    printTime();
                }
            } catch (InterruptedException ignored) { }
        }

        private void printTime() throws InterruptedException {
            Calendar calendar = Calendar.getInstance();
            calendar.set(
                0, Calendar.JANUARY, 1, hours, minutes, seconds);
            TimeUnit.SECONDS.sleep(1);
            calendar.add(Calendar.SECOND, 1);
            hours = calendar.get(Calendar.HOUR_OF_DAY);
            minutes = calendar.get(Calendar.MINUTE);
            seconds = calendar.get(Calendar.SECOND);

            if (hours == 0 && minutes == 0 && seconds == 0) {
                System.out.printf("В г. %s сейчас полночь!%n", cityName);
            } else {
                System.out.printf("В г. %s сейчас %d:%d:%d!%n",
                    cityName, hours, minutes, seconds);
            }
        }
    }
}
