package com.sedykh.interruptThreads;

public class App
{
    public static void main(String[] args)
    {
        ThreadCounter thread = new ThreadCounter();

        System.out.println("start: " + thread.start());
        System.out.println("join : " + thread.join(2000)); // 2 с
        System.out.println("stop : " + thread.stop());
        //System.out.println("interrupt: " + thread.interrupt());
        System.out.println("end of main()");
    }
}
