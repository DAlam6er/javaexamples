package com.sedykh.interruptThreads;

public class ThreadCounter implements Runnable
{
    private final Thread self;
    private long counter;
    // volatile запрещает оптимизацию по данной переменной
    private volatile boolean canWork;

    public ThreadCounter()
    {
        self = new Thread(this);
        counter = 0;
    }

    public long start()
    {
        canWork = true;
        self.start();
        return counter;
    }

    public long stop()
    {
        canWork = false;
        return counter;
    }

    public long interrupt()
    {
        System.out.println("Sending interrupt, counter = " + counter);
        self.interrupt(); // будет работать только с BLOCKED, WAITING, TIMED_WAITING
        return counter;
    }

    public long join(int ms)
    {
        System.out.println("join invoked, counter = " + counter);
        try {
            self.join(ms);
        } catch (InterruptedException e) {
            return -1; // never get here!
        }
        return counter;
    }

    @Override
    public void run()
    {
        // Если блок try-catch помещается в while, обязательно нужен break
        /*
        while (true) {
            counter++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("You will not stop me!!!");
                break;  // без него поток никогда не завершится
            }
        }
         */

        // здесь break не нужен, т.к. while помещен в блок try-catch
        /*
        try {
            while (true) {
                counter++;
                Thread.sleep(100); // тайм-аут 100 мс
            }
        } catch (InterruptedException e) {
            System.out.println("You will not stop me!!!");
        }
         */

        while(canWork) {
            counter++;
        }
    }
}
