package com.eduprof.tikhomirov.person;

public class Person
{
    private String fullName;
    private int age;

    public Person()
    {
        this.fullName = "John Doe";
        this.age = 18;
    }

    public Person(String fullName, int age)
    {
        this.fullName = fullName;
        this.age = age;
    }

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = (age < 0) ? - age : age;
    }

    public void move()
    {
        System.out.printf("%s двигается.\n", this.getFullName());
    }

    public void talk()
    {
        System.out.printf("%s говорит.\n", this.getFullName());
    }
}

class App
{
    public static void main(String[] args)
    {
        Person defaultPerson = new Person();
        Person concretePerson =
            new Person("Адриано Челентано", 84);
        defaultPerson.move();
        concretePerson.move();
        defaultPerson.talk();
        concretePerson.talk();
    }
}
