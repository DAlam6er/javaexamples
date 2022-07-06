package com.eduprof.tikhomirov;

import java.util.ArrayList;

public class Parent
{
    private String eyes;
    private String hair = "long";
    private String politics;


    public Parent()
    {
        this.setEyes("grey");
    }

    // Наследники не смогут менять цвет глаз
    private void setEyes(String eyes)
    {
        this.eyes = eyes;
    }

    // read-only property!
    public String getEyes()
    {
        return eyes;
    }

    // выключаем полиморфизм
    public final void setPolitics()
    {
        this.politics = "conservator";
        System.out.println("I will always be conservative, that's in my nature!");
    }

    public void cutMyHair()
    {
        System.out.println("I always wear long hair, like my father and his father!");
    }
}

    class Child extends Parent
    {
        @Override
        public void cutMyHair()
        {
            System.out.println("I prefer short hair");
        }
    }

    class App {
        public static void main (String[] args)
        {
            // здесь начинается полиморфизм
            Parent human = new Child();
            // вызов полиморфного кода
            human.cutMyHair(); // "I prefer short hair"
            // They will always be "grey" - kind of family curse
            System.out.println(human.getEyes());

            human = new Parent();
            human.cutMyHair(); // "I always wear long hair, like my father and his father!"
            System.out.println("-------------");

            // создаем коллекццию, типизируем её родительским классом
            ArrayList<Parent> list = new ArrayList<Parent>();
            list.add(new Parent());
            list.add(new Child());
            list.add(new Parent());
            list.add(new Child());
            // затем перебираем её, у каждого элемента будет своя реализация метода cutMyHair
            // это тоже пример полиморфизма
            for (Parent member : list) {
                member.cutMyHair();
            }
        }
    }