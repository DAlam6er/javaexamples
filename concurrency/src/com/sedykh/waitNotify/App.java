package com.sedykh.waitNotify;

public class App
{
    static final int STEPS = 100;

    public static void main(String[] args) throws InterruptedException
    {
        Monitor mon = new Monitor();

        Thread th1 = new Thread(() -> {
            for (int i = 0; i < STEPS; i++) {
                System.out.println("1 - " + i);
                if (i >= STEPS / 2) {
                    // синхронизация внутри if для экономии!
                    synchronized (mon) {
                        mon.step = i;
                        mon.notify();
                    }
                }
            }
        });

        Thread th2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try {
                    // лучше synchronized в try-catch,
                    // чтобы вывалиться из блока синхронизации,
                    // если что-то пойдет не так
                    synchronized (mon) {
                        // одна из проверок избыточна - if или while
                        // зато надёжно, учитывая все случаи с 1-м потоком
                        // while гарантирует, что мы не проснемся,
                        // до того как условие пройдет,
                        // чтобы вернуться в сон, если разбудили раньше времени
                        while (mon.step < STEPS / 2) {
                            mon.wait();
                        }
                    }
                } catch (InterruptedException ignored) {}

                for (int i = 0; i < STEPS; i++) {
                    System.out.println("2 - " + i);
                }
            }
        });

        th1.start();
        // Синхронизироваться с помощью sleep нельзя,
        // т.к. накапливается неточность
        //Thread.sleep(2);
        th2.start();

        th1.join();
        th2.join();
    }
}

class Monitor
{
    public volatile int step;
}
