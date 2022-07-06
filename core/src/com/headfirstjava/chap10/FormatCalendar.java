package com.headfirstjava.chap10;

import java.util.Calendar;
import java.util.Date;

public class FormatCalendar
{
    public static void main(String[] args)
    {
        // форматируем аргумент в виде десятичного числа,
        // разделенного пробелами(запятыми в американской локали)
        String s = String.format("%, d", 1000000000);
        System.out.println(s);
        // форматируем аргумент в виде дробного числа,
        // разделенного пробелами(запятыми в американской локали)
        // с точностью два десятичных знака
        s = String.format("Мне нужно исправить %,.2f ошибки.", 476578.09876);
        System.out.println(s);
        // Возможные типы данных в спецификаторе: %d, %f, %x, %c
        System.out.println();

        // полное представление даты и времени
        String d = String.format("%tc", new Date());
        System.out.println(d);
        // просто время в формате AM/PM
        d = String.format("%tr", new Date());
        System.out.println(d);

        // день недели, число и месяц
        Date today = new Date();
        d = String.format("%tA, %td %tB", today, today, today);
        System.out.println(d);
        // угловая скобка < - флаг в спецификаторе,
        // который говорит методу "используй предыдущий аргумент еще раз"
        d = String.format("%tA, %<td %<tB", today);
        System.out.println(d);

        Calendar c = Calendar.getInstance();
        // month: 0 - January
        c.set(2004, 0, 7, 15,40);
        System.out.println(c.getTime());

        long day1 = c.getTimeInMillis();
        day1 += 1000 * 60 * 60; // +1 час
        // установить время для объекта CalendarDemo, основываясь на мс
        c.setTimeInMillis(day1);
        System.out.println("Новый час: " + c.get(Calendar.HOUR_OF_DAY));
        // добавить или вычесть время из поля календаря
        c.add(Calendar.DATE, 35); // +35 дней
        System.out.println("После добавления 35 дней:\n" + c.getTime());
        // добавить или вычесть время без изменения старших полей
        c.roll(Calendar.DATE, 35); // прокрутить 35 дней
        System.out.println("После прокручивания 35 дней:\n" + c.getTime());

        c.set(Calendar.DATE, 1);
        System.out.println("После установки даты в 1:\n" + c.getTime());
    }
}
