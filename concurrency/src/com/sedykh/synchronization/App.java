package com.sedykh.synchronization;

public class App
{
    static int x = 0;
    static final Object mon = new Object();

    public static void main(String[] args) throws InterruptedException
    {
        // ----------------------------------------------------------------
        // Синхронизация по монитору
        // ----------------------------------------------------------------
        final int steps = 1000;
        final int thNumber = 5; // number of threads
        // Monitor mon = new Monitor();

        // из локального анонимного класса доступ есть только к static fields
        // синхронизация по монитору
        Runnable runner2 = new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < steps; i++) {
                    // любой код между { и } будет синхронизирован
                    synchronized (mon) {
                        // сюда может обратиться только 1 поток
                        // mon.x++;
                        x++;
                    }
                }
            }
        };

        Thread[] threads = new Thread[thNumber];
        // for each - нельзя, только для чтения
        // создаем и стартуем все потоки
        for (int i = 0; i < thNumber; i++) {
            threads[i] = new Thread(runner2);
            threads[i].start();
        }

        // join в другом цикле, т.к. join блокирующий вызов
        for (int i = 0; i < thNumber; i++) {
            threads[i].join();
        }

        // System.out.println("monitor.x = " + mon.x);
        System.out.println("monitor.x = " + x);

        // ----------------------------------------------------------------
        // Синхронизация по методу (гораздо хуже). Всегда привязана к классу
        // ----------------------------------------------------------------
        Test test = new Test();
        Runnable runner1 = new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < steps; i++) {
                    // здесь блок синхронизации не нужен,
                    // т.к. метод синхронизированный
                    test.increment();
                }
            }
        };

        for (int i = 0; i < thNumber; i++) {
            threads[i] = new Thread(runner1);
            threads[i].start();
        }

        for (int i = 0; i < thNumber; i++) {
            threads[i].join();
        }

        System.out.println("test.x = " + test.getX());
    }
}

// Вспомогательный класс нужен для синхронизации по методу
class Test
{
    private int x;

    public int getX()
    {
        return x;
    }

    // синхронизация по методу,
    // х гарантированно инкрементируется в каждом потоке
    synchronized void increment()
    {
        x++;
    }
}

class Monitor
{
    int x; // x виден только внутри package
}
