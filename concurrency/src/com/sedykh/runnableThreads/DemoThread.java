package com.sedykh.runnableThreads;

public class DemoThread implements Runnable
{
    private final Thread self; // собственный поток, отвечает за управление DemoThread как потоком
    private int counter;

    public DemoThread()
    {
        /*
        Создаем класс, который должен реализовывать многопоточность,
        Для того чтобы Thread self мог быть потоком для работы класса,
        в него нужно передать себя (свой собственный экземпляр), чтобы
        он мог работать с собой, как с потоком
         */
        self = new Thread(this,"RunnableDemo");
        self.start(); // Небезопасно! В сложных примерах так лучше не делать
    }

    public int join()
    {
        try {
            self.join();
        } catch (InterruptedException ignored) {}
        return counter;
    }

    @Override
    public void run()
    {
        for (counter = 0; counter < 10; counter++) {
            /*
            System.out.println(Thread.currentThread().getName() + " - " + counter);
            try {
                Thread.sleep(100); // без него никогда не получим Interrupted, т.е. цикл всегда отработает 10 раз
            } catch (InterruptedException e) {
                break;
            }*/
        }

    }
}
