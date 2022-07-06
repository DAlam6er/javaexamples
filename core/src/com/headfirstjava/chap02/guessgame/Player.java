package com.headfirstjava.chap02.guessgame;

public class Player
{
    // здесь хранится вариант числа
    private int number = 0;

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    public void guess()
    {
        number = (int) (Math.random() * 10);
        System.out.println("Думаю, это число " + number);
    }
}
