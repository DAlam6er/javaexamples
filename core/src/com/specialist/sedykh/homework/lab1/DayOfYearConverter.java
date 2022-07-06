package com.specialist.sedykh.homework.lab1;

public class DayOfYearConverter
{
    public static void main(String[] args)
    {
        int year = 1999;
        int dayNum = 327;
        int[] daysInMonths =
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] months = {
            "January", "February", "March", "April",
            "May", "June", "July", "August",
            "September", "October", "November", "December"
        };
        int monthNum = 0;

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
