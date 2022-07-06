package com.stepik.javabasecourse.logging;

import java.io.IOException;
import java.util.Random;
import java.util.logging.*;

/*
Возможности:
1) Вывод подробного протокола работы программы
2) Сбор статистики сервером о работе клиентов
Преимущества:
1) Точечная настройка логирования (включение/отключение на уровне отдельных пакетов/классов).
2) Настройка уровня детальности
3) Настройка места, куда логи будут писаться
4) Настройка формата, в котором логи будут вестись (полный отладочный/режим промышленной эксплуатации).
 */
public class LogDemo
{
    // Логгер именуют полным именем класса: com.stepik.javabasecourse.logging.LogDemo
    // Сделано это для иерархической обработки
    private static final Logger LOGGER =
        Logger.getLogger(LogDemo.class.getName());

    public static void main(String[] args)
    {
        // OFF, SEVERE, WARNING, INFO,
        // CONFIG, FINE, FINER, FINEST, ALL
        // - степени серьёзности сообщения
        LOGGER.log(Level.INFO, "I'm logging");

        // на каждый уровень логирования есть одноименный метод
        // он вбрасывает сообщение соответствующего уровня
        LOGGER.warning("We have a problem!");
        // Логгер можно сконфигурировать так, чтобы он игнорировал сообщения ниже заданного
        // Пример: Логер настроенные на уровень WARNING
        // будет принимать сообщения уровня WARNING и SEVERE и игнорировать всё остальные
        // Настройка делается или в коде .setLevel(Level.WARNING)
        // или в конфигурационном файле

        // Добавление динамической информации,
        // значение параметра метода или текущее состояние объекта
        int x = new Random().nextInt(100);
        int y = new Random().nextInt(100);
        // Способ 1: конкантенация
        // - есть недостаток для работы программ под большой нагрузкой
        // из-за постоянной конкатенации строк, даже если Level отключен
        LOGGER.log(Level.FINEST, "Current value of x is " + x);
        // Способ 2 Передача строки с указанием места подстановки
        LOGGER.log(Level.FINEST, "Current value of x is {0}", x);
        // для нескольких параметров
        LOGGER.log(Level.FINEST,
            "Point coordinates are ({0}, {1})", new Object[]{x, y});

        // Распечатка в логе стек-трейса исключения
        Exception e = new Exception();
        LOGGER.log(Level.SEVERE, "Unexpected exception", e);
        // Тот факт что логгер использует только константные строки
        // с местами для подстановки позволяет провести локализацию

        // Обработчик сообщения определяет, куда будет записано сообщение
        // Наследники абстрактного класса Handler:
        // java.util.logging.ConsoleHandler
        // java.util.logging.FileHandler
        // java.util.logging.SocketHandler

        // Хендлер задаётся в конфигурации или прикрепляется к логгреру
        // вызовом метода логгера .addHandler(...)

        // Формат вывода сообщения в лог
        // java.util.logging.Formatter
        // Handler имеет ссылку на форматтер и делигирует ему всю работу
        // по превращению залогированного сообщения в окончательный вид
        // для записи в файл или для передачи для сети
        // java.util.logging.SimpleFormatter - человекочитаемый вид
        // java.util.logging.XMLFormatter - машиночитаемый вид
        Handler handler;
        try {
            handler = new FileHandler("log.xml");
        } catch (IOException ex) {
            handler = new ConsoleHandler();
        }
        Formatter formatter = new XMLFormatter();
        handler.setFormatter(formatter);
        handler.setLevel(Level.WARNING);
        LOGGER.addHandler(handler);

        LOGGER.log(Level.INFO, "test info");        // вывод в консоль
        LOGGER.log(Level.WARNING, "test warning");  // вывод в консоль и файл
    }
}
