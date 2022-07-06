package com.sedykh.runnableThreads;

public class App
{
    public static void main(String[] args) throws InterruptedException
    {
        DemoThread th1 = new DemoThread();
        DemoThread th2 = new DemoThread();
        /*
        for (int i = 0; i < 10; i++) {
            System.out.println("main() - " + i);
            // не гарантирует синхронизации так,
            // что потоки будут выполняться один за другим,
            // реальная задержка 100,000005 (например)
            Thread.sleep(100);
        }
        */
        System.out.println("Thread1 counter = " + th1.join());
        System.out.println("Thread2 counter = " + th2.join());

        System.out.println("End of main()");
    }
}
