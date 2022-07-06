package com.specialist.sedykh.homework.lab2_3_4_5;

/**
 * Контракт, обеспечивающий паттерн Издатель-Подписчик.
 *
 * Метод counted - событие, которое Издатель (объект класса WordCounted)
 * может рассылать своим подписчикам.
 */

public interface IWordCounter
{
    void counted(Object sender, int size);
}
