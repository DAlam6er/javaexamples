package com.sedykh.atomicTypes;

import java.util.concurrent.atomic.AtomicInteger;

public class GlobalData // коллекция глобальных переменных
{
    public static int value;
    public static AtomicInteger aValue = new AtomicInteger();
    public static final int STEPS = 1000;
}
