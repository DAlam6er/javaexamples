package com.javarush.favourites.n0605;

/* 
Stopwatch (Секундомер)
*/

public class StopWatch
{
    public static volatile boolean isStopped = false;

    public static void main(String[] args) throws InterruptedException {
        Runner ivanov = new Runner("Ivanov", 4);    // 4 шага/с
        Runner petrov = new Runner("Petrov", 2);    // 2 шага/с
        //на старт!
        //внимание!
        //марш!
        ivanov.start();
        petrov.start();
        Thread.sleep(2000);     // стоп
        isStopped = true;
        Thread.sleep(1000);
    }

    public static class Stopwatch extends Thread {
        private final Runner owner;
        private int stepNumber;

        public Stopwatch(Runner runner) {
            this.owner = runner;
        }

        @Override
        public void run() {
            try {
                while (!isStopped) {
                    doStep();
                }
            } catch (InterruptedException ignored) { }
        }

        //  Метод doStep учитывает скорость бегуна.
        //  Если скорость бегуна 2 шага в секунду,
        //  метод должен работать пол секунды;
        //  Если скорость бегуна 4 шага в секунду,
        //  метод должен работать четверть секунды.
        private void doStep() throws InterruptedException {
            stepNumber++;
            Thread.sleep(1000L/ owner.getSpeed());
            System.out.println(
                owner.getName() + " делает шаг №" + stepNumber + "!");
        }
    }

    public static class Runner {
        Stopwatch stopwatch;
        private final String name;
        private final int speed;

        public Runner(String name, int speed) {
            this.name = name;
            this.speed = speed;
            this.stopwatch = new Stopwatch(this);
        }

        public String getName() {
            return name;
        }

        public int getSpeed() {
            return speed;
        }

        public void start() {
            stopwatch.start();
        }
    }
}
