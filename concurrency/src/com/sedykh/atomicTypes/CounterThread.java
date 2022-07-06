package com.sedykh.atomicTypes;

public class CounterThread implements Runnable
{
    // не слишком распространенная практика, лучше в конструкторе
    private final Thread self = new Thread(this);

    public void start()
    {
        self.start();
    }

    public void join()
    {
        try {
            self.join();
        } catch (InterruptedException ignored) { }
    }

    @Override
    public void run()
    {
        int i;
        for (i = 0; i < GlobalData.STEPS; i++) {
            // синхронизация в цикле замедляет весь цикл!
            // синхронизация по методу
            GlobalData.value++;
            GlobalData.aValue.getAndIncrement();
        }
        System.out.println("i = " + i);
    }
}
