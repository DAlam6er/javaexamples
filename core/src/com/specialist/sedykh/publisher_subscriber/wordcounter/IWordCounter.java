package com.specialist.sedykh.publisher_subscriber.wordcounter;

/**
 * Контракт, обеспечивающий паттерн Издатель-Подписчик.
 *
 * Метод counted - событие, которое Издатель (объект класса WordCounted)
 * может рассылать своим Подписчикам.
 */

public interface IWordCounter
{
    void counted(Object sender, int size);
}
