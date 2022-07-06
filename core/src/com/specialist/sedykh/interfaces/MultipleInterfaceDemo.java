package com.specialist.sedykh.interfaces;

public class MultipleInterfaceDemo
{
    public interface Swimmable
    {
        default void canSwim()
        {
            System.out.println("I make an object float");
        }
    }

    public interface Submergible
    {
        default void canSwim()
        {
            System.out.println("I make a submersible object float");
        }
        void canDive();
    }

    public class Human implements Swimmable, Submergible
    {

        @Override
        public void canDive()
        {
            System.out.println("I can dive!");
        }

        @Override
        public void canSwim()
        {
            Swimmable.super.canSwim();
            Submergible.super.canSwim();
        }
    }

    public static void main(String[] args)
    {
        MultipleInterfaceDemo demo = new MultipleInterfaceDemo();
        MultipleInterfaceDemo.Human human = demo.new Human();

        human.canSwim();
    }
}
