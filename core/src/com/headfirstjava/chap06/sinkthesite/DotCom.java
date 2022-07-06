package com.headfirstjava.chap06.sinkthesite;

import java.util.ArrayList;

public class DotCom
{
    private ArrayList<String> locationCells;
    private String name;

    protected void setLocationCells(ArrayList<String> locs)
    {
        locationCells = locs;
    }

    public ArrayList<String> getLocationCells()
    {
        return locationCells;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public String checkYourself(String userInput)
    {
        String result = "Мимо";
        int index = locationCells.indexOf(userInput);

        if (index >= 0) {
            locationCells.remove(index);
            if (locationCells.isEmpty()) {
                result = "Потопил";
                System.out.println("Ой! Вы потопили " + name + "    :-(");
            } else {
                result = "Попал";
            }
        }
        return result;
    }
}
