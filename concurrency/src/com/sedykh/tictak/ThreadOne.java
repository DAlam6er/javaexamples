package com.sedykh.tictak;

public class ThreadOne extends Thread
{
    private final Object monitor;

    public ThreadOne(Object monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run () {
        try
        {
            for (int i = 0; i < TicTak.num; i++) {
                synchronized (monitor) {
                    System.out.print(1 + " - ");
                    monitor.notify();
                    if (i < TicTak.num - 1) {
                        monitor.wait();
                    }
                }
            }
        }
        catch (InterruptedException ignored) { }
    }
}

