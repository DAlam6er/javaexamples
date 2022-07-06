package com.headfirstjava.Annex;

// Перечисление считается специальным видом классов
enum Members { JERRY, BOBBY, PHIL }

public class EnumSimpleTest
{
    // переменная имеет тип Members, и может принимать только 3 значения
    public static Members selectedBandMember;

    public static void main(String[] args)
    {
        int random = (int) (Math.random() * 3);
        // переменная имеет тип Members, и может принимать только 3 значения
        selectedBandMember = Members.values()[random];
        switch (selectedBandMember) {
            case JERRY -> System.out.println("Hello from Jerry!");
            case BOBBY -> System.out.println("Hello from Bobby!");
            case PHIL -> System.out.println("Hello from Phil!");
        }

        Members n = Members.BOBBY;
        if (n.equals(Members.JERRY)) {
            System.out.println("Джеррррри!");
        }
        if (n == Members.BOBBY) {
            System.out.println("Rat Dog");
        }

        Members ifName = Members.PHIL;
        switch (ifName) {
            case JERRY -> System.out.println("Пусть споет");
            case PHIL -> System.out.println("углубляйся");
            case BOBBY -> System.out.println("Кэссиди!");
        }
    }
}

