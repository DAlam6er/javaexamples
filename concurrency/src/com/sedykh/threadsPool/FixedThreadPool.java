package com.sedykh.threadsPool;

import java.util.concurrent.*;

public class FixedThreadPool
{
    public static void main(String[] args)
        throws ExecutionException, InterruptedException
    {
        // класс-утилита Executors, исполнителей 5
        ExecutorService exec = Executors.newFixedThreadPool(5);

        // 12 задач
        for (int i = 0; i < 12; i++) {
            // передаем задачу - submit
            // Callable в отличие от Runnable может передать результат работы
            exec.submit(new Callable<String>()
            {
                @Override
                public String call() throws Exception
                {
                    // программа будет работать 3 секунды (5+5+2=12 задач)
                    Thread.sleep(1000); // имитация работы
                    System.out.println(Thread.currentThread().getName() +
                        " - working");
                    return Thread.currentThread().getName();
                }
            });
        }
        // Больше задач не будет - не путать с shutdownNow()
        exec.shutdown();
        System.out.println("end of main()");
    }
}
