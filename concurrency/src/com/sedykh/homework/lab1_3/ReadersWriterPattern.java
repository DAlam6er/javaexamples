package com.sedykh.homework.lab1_3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadersWriterPattern
{

    public static void main(String[] args) throws Exception
    {
        Data d = new Data();

        ExecutorService es = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 5; i++)
            es.submit(new WorkWData(d));

        TimeUnit.SECONDS.sleep(3);
        es.shutdown();
        es.awaitTermination(10000, TimeUnit.MILLISECONDS);
    }
}

class WorkWData implements Runnable
{
    Data obj;

    WorkWData(Data d)
    {
        obj = d;
    }

    public void run()
    {
        int n;
        n = obj.read();
        System.out.println(
            "First read" + " " + Thread.currentThread().getName() +
            " " + n);
        obj.write();
        System.out.println(
            "Write ... " + " " + Thread.currentThread().getName()+
            " " + n);
        n = obj.read();
        System.out.println(
            "Second read" + " " + Thread.currentThread().getName() +
            " " + n);
    }
}

class Data
{
    private int count = 0;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock rl = lock.readLock();
    private final Lock wl = lock.writeLock();

    int read()
    {
        try {
            rl.lock();
            int n = count;
            TimeUnit.MILLISECONDS.sleep(400);
            count = n;
        }
        catch (InterruptedException ignored) { }
        finally {
            rl.unlock();
        }

        return count;
    }

    void write()
    {
        try {
            wl.lock();
            int n = count;
            TimeUnit.MILLISECONDS.sleep(400);
            n++;
            count = n;
        }
        catch (InterruptedException ignored) { }
        finally {
            wl.unlock();
        }
    }
}
