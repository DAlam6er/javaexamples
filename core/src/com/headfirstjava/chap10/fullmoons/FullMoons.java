package com.headfirstjava.chap10.fullmoons;

import java.util.*;
import static java.lang.System.out;

public class FullMoons
{
    static int DAY_IM = 1000 * 60 * 60 * 24; // мс в 1 сутках
    public static void main(String[] args)
    {
        Calendar c = Calendar.getInstance();
        c.set(2004, 0, 7, 15, 40);

        long day1 = c.getTimeInMillis();
        for (int x = 0; x < 230; x++) {
            day1 += (DAY_IM * 29.52);
            c.setTimeInMillis(day1);
            out.printf("Полнолуние было в %tA, %<td %<tB %<tY\n", c);
        }
    }
}
