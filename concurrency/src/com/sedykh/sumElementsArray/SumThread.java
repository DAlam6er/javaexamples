package com.sedykh.sumElementsArray;

public class SumThread extends Thread
{
    // положение потока относительно начала массива - смещение, с кот. начинаем
    private final int offset;

    public SumThread(int offset)
    {
        this.offset = offset;
    }

    @Override
    public void run()
    {
        for (int i = offset; i < GlobalData.ARRAY_SIZE;
             i += GlobalData.THREADS_COUNT)
        {
            GlobalData.results[offset] += GlobalData.array[i];
        }
    }
}
