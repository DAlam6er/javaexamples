package com.specialist.sedykh.patterns.singleton;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CalendarDemo
{
    public static void main(String[] args)
    {
        Calendar sys = Calendar.getInstance();
        System.out.println("Работа с экземпляром Calendar:");
        System.out.println(sys);
        System.out.println(sys.get(Calendar.DAY_OF_MONTH));
        System.out.printf("%1$tY %1$td\n", sys);
        System.out.printf("%1$tD\n", sys);

        System.out.println("Работа со ссылкой типа Date:");
        Date date = sys.getTime();
        System.out.println(date);
        date = new Date();
        System.out.println(date);

        // еще один синглтон - позволяет форматировать дату в нужном виде
        // процесс форматирования даты
        DateFormat df = DateFormat.getDateInstance();
        System.out.println("Работа с экземпляром DateFormat:");
        System.out.println(df.format(date));
        df = DateFormat.getDateInstance(
            DateFormat.SHORT, new Locale("en", "US"));
        System.out.println(df.format(date));

        System.out.println(DateFormat.getDateInstance(
            DateFormat.LONG, new Locale("fr", "FR"))
            .format(sys.getTime()));

    }
}
