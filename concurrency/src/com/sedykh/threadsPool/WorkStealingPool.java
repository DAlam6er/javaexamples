package com.sedykh.threadsPool;

import java.util.ArrayList;
import java.util.concurrent.*;

public class WorkStealingPool
{
    public static void main(String[] args)
        throws ExecutionException, InterruptedException
    {
        // строки будут заполнены исполнителями
        ArrayList<Future<String>> results = new ArrayList<>();
        // будет создано столько потоков, сколько ядер у процессора
        // pool построен на основе ForkJoinPool - многопоточная рекурсия
        ExecutorService exec = Executors.newWorkStealingPool();
        // 12 задач
        for (int i = 0; i < 12; i++) {
            // добавляем ссылки на ЕЩЁ не проинициализированные объекты
            results.add(exec.submit(new Callable<String>()
            {
                @Override
                public String call() throws Exception
                {
                    Thread.sleep(1000); // имитация работы
                    System.out.println(Thread.currentThread().getName() +
                        " - working");
                    return Thread.currentThread().getName();
                }
            }));
        }
        // Больше задач не будет - не путать с shutdownNow()
        exec.shutdown();
        for (Future<String> result : results) {
            // метод get() в данном случае блокирующий -
            // не даст продолжить исполнение main,
            // пока не получим ответ от задачи
            // get() генерирует 2 исключения
            // InterruptedException - если сами прерываем get
            // ExecutionException - если прервалось исполнение (shutdown)
            System.out.println(result.get() + " - sent result");
        }
        System.out.println("end of main()");
    }
}
