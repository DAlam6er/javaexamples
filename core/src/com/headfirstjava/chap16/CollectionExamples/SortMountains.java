package com.headfirstjava.chap16.CollectionExamples;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class SortMountains
{
    LinkedList<Mountain> mtn = new LinkedList<>();

    static class NameCompare implements Comparator<Mountain>
    {
        @Override
        public int compare(Mountain m1, Mountain m2)
        {
            return m1.getName().compareTo(m2.getName());
        }
    }

    static class HeightCompare implements Comparator<Mountain>
    {
        @Override
        public int compare(Mountain m1, Mountain m2)
        {
            return Integer.compare(m1.getHeight(), m2.getHeight());
        }
    }

    public static void main(String[] args)
    {
        new SortMountains().go();
    }

    public void go()
    {
        mtn.add(new Mountain("Лонг-Рейндж", 14255));
        mtn.add(new Mountain("Эльберт", 14433));
        mtn.add(new Mountain("Марун", 14156));
        mtn.add(new Mountain("Касл", 14265));

        System.out.println("В порядке добавления:\n" + mtn);

        NameCompare nc = new NameCompare();
        Collections.sort(mtn, nc);
        System.out.println("По названию:\n" + mtn);

        HeightCompare hc = new HeightCompare();
        Collections.sort(mtn, hc.reversed());
        System.out.println("По высоте (в порядке убывания):\n" + mtn);
    }
}

class Mountain
{
    private final String name;
    private final int height;

    public Mountain(String name, int height)
    {
        this.name = name;
        this.height = height;
    }

    public String getName()
    {
        return name;
    }

    public int getHeight()
    {
        return height;
    }

    @Override
    public String toString()
    {
        return String.format("%s %d", name, height);
    }
}
