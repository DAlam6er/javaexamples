package com.headfirstjava.Annex;

// Недостаток подхода: нельзя гарантировать,
// что переменная selectedBandMember всегда будет равна 1, 2 или 3
class EnumImitation
{
    public static final int JERRY = 1;
    public static final int BOBBY = 2;
    public static final int PHIL = 3;

    public static void main(String[] args)
    {
        // здесь намеренно допущена ошибка
        int selectedBandMember = (int) (Math.random() * 4) + 1;
        switch (selectedBandMember) {
            case JERRY -> System.out.println("Hello from Jerry!");
            case BOBBY -> System.out.println("Hello from Bobby!");
            case PHIL -> System.out.println("Hello from Phil!");
            default -> System.out.println("Unknown member of the band");
        }
    }
}



