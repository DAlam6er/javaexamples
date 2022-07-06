package com.specialist.sedykh.patterns.singleton;

public class Singleton
{
    // Поле, хранящее объект Singleton - экземпляр
    // static - т.к. элемент кода привязан к КЛАССУ, а не объекту
    // final писать НЕЛЬЗЯ, т.к. instance может меняться (н-р настройки календаря)
    // volatile - запрет любой оптимизации на уровне кода
    private static volatile Singleton instance = null;
    private int x;

    private Singleton(int x) {
        this.x = x;
    }

    // синглтон с ленивой инициализацией
    // метод может быть вызван только одним потоком
    // Это медленно и неэффективно, т.к. запрещает читать instance (return instance)
    // нескольким потокам одновременно
    public static synchronized Singleton getInstance()
    {
        // ленивая инициализация
        if (instance == null) instance = new Singleton(0);
        return instance;
    }

    public static synchronized Singleton getInstance(int x)
    {
        // ленивая инициализация
        if (instance == null) instance = new Singleton(x);
        return instance;
    }

    public int getX()
    {
        return x;
    }
}
