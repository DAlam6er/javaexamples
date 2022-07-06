package com.javarush.favourites.n0701;


public class FinalizeTestDrive
{
    private String name;
    private static int cnt = 0;
    public FinalizeTestDrive(String name) {
        this.name = name;
    }

    public FinalizeTestDrive() { }

    public static void main(String[] args) throws Throwable {

        for (int i = 0 ; i < 1000_000; i++) {

            FinalizeTestDrive test = new FinalizeTestDrive();
            test = null;//вот здесь первый объект становится доступен сборщику мусора
        }
        System.out.printf("finalize() был вызван %d раз!\n", cnt);
    }

    // Depricated since java 1.9
    @Override
    protected void finalize() throws Throwable {
        cnt++;
        //System.out.println("Объект Cat уничтожен!");
    }
}