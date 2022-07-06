package com.javarush.favourites.n0510;

enum DayOfWeek
{
    // константы со статическим доступом
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY
}

class ScholarSchedule
{

    private DayOfWeek dayOfWeek;
    // другие поля

    public DayOfWeek getDayOfWeek()
    {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}

class Scholar
{
    ScholarSchedule schedule;
    private boolean goToSchool;

    public void wakeUp()
    {
        if (this.schedule.getDayOfWeek() == DayOfWeek.SUNDAY) {
            System.out.println("Ура, можно поспать ещё!");
            goToSchool = false;
        } else {
            System.out.println("Блин, опять в школу :(");
            goToSchool = true;
        }
    }

    public boolean isGoToSchool()
    {
        return goToSchool;
    }
}

public class EnumTestDrive {
    public static void main(String[] args)
    {
        Scholar scholar = new Scholar();
        scholar.schedule = new ScholarSchedule();
        scholar.schedule.setDayOfWeek(DayOfWeek.MONDAY);
        scholar.wakeUp();
        System.out.println("goToSchool = " + scholar.isGoToSchool());
    }
}
