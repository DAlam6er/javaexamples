package com.specialist.sedykh;

public class DayOfYearConverter
{
    public static void main(String[] args)
    {
        final int[] daysInMonths =
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        final String[] months = {
            "January", "February", "March", "April",
            "May", "June", "July", "August",
            "September", "October", "November", "December"
        };
        int monthNum = 0;

        final int year = 1999;
        int dayNum = 327; // 327-й день 1999 года - это 23-е ноября

        boolean isLeapYear =
            (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);

        for (int days : daysInMonths) {
            if (isLeapYear && monthNum == 1) days++;
            if (dayNum <= days) break;
            dayNum -= days;
            monthNum++;
        }

        System.out.println(months[monthNum] + " " + dayNum);
    }
}
