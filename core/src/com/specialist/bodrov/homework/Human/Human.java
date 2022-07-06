package com.specialist.bodrov.homework.Human;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Human
{
    public enum Sex
    {
        MALE,
        FEMALE
    }
    private String lastName;
    private String firstName;
    private String patronymic;
    private Sex sex;
    private Date dob;

    public Human(
        String surname, String name, String patronymic, 
        String sex, String dob
    ) throws ParseException
    {
        setLastName(surname);
        setFirstName(name);
        setPatronymic(patronymic);
        setSex(sex);
        setDob(dob);
    }

    public void setSex(String sex)
    {
        switch (sex.toUpperCase()) {
            case "MALE" -> this.sex = Sex.MALE;
            case "FEMALE" -> this.sex = Sex.FEMALE;
            default ->
                throw new IllegalArgumentException(
                    "Please enter appropriate sex (male/female)."
                );
        }
    }

    public void setPatronymic(String patronymic)
    {
        this.patronymic = patronymic;
    }

    public void setDob(String dob) throws ParseException
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        try {
            this.dob = formatter.parse(dob);
        } catch (ParseException e) {
            System.out.println("Please enter appropriate date of birth!");
        }
    }

    public void setFirstName(String name)
    {
        this.firstName = name;
    }

    public void setLastName(String surname)
    {
        this.lastName = surname;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public String getPatronymic()
    {
        return this.patronymic;
    }

    public String getSex()
    {
        return this.sex.name();
    }

    public String getDob()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
        return formatter.format(dob);
    }

    @Override
    public String toString()
    {
        return getLastName() + " " + getFirstName() + " " + getPatronymic() +
            " " + getSex() + " " + getDob();
    }
}
