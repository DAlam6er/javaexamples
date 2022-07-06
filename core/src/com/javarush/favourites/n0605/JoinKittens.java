package com.javarush.favourites.n0605;

/* 
Расставь вызовы методов join()
*/

public class JoinKittens
{
    public static void main(String[] args) throws InterruptedException {
        new Cat("Мурка");
        new Cat("Пушинка");
    }

    private static void investigateWorld() {
        try {
            Thread.sleep(200);
            System.out.printf(
                "%s гуляет\n", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class Cat extends Thread {
        protected Kitten kitten1;
        protected Kitten kitten2;

        public Cat(String name) {
            super(name);
            kitten1 = new Kitten("Котенок 1, мама - " + getName());
            kitten2 = new Kitten("Котенок 2, мама - " + getName());
            this.start();
        }

        @Override
        public void run() {
            System.out.println(getName() + " родила 2 котят");
            try {
                initAllKittens();
            } catch (InterruptedException ignored) {}
            System.out.printf(
                "%s: Все котята в корзинке. %<s собрала их назад\n",
                getName());
        }

        private void initAllKittens() throws InterruptedException {
            kitten1.start();
            kitten1.join();     // Дожидаемся окончания гуляния котёнка 1
            kitten2.start();
            kitten2.join();     // Дожидаемся окончания гуляния котёнка 2
        }
    }

    public static class Kitten extends Thread {
        public Kitten(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println(getName() + ", вылез из корзинки");
            investigateWorld();
        }
    }
}
