package com.javamanual;

class Queue
{
    int n;
    synchronized int get()
    {
        System.out.println("Got: " + n);
        return n;
    }

    synchronized void put(int n)
    {
        this.n = n;
        System.out.println("Sent: " + n);
    }
}

class Producer implements Runnable
{
    Queue queue;

    Producer(Queue queue)
    {
        this.queue = queue;
        new Thread(this, "Producer").start();
    }

    @Override
    public void run()
    {
        int i = 0;
        while (true) {
            queue.put(i++);
        }
    }
}

class Consumer implements Runnable
{
    Queue queue;

    Consumer(Queue queue)
    {
        this.queue = queue;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run()
    {
        while (true) {
            queue.get();
        }
    }
}

public class WrongProducerConsumer
{
    public static void main(String[] args)
    {
        Queue queue = new Queue();
        new Producer(queue);
        new Consumer(queue);
        System.out.println("Press Control+C to interrupt.");
    }
}
