package com.stepik.javabasecourse.io.File;

import java.io.File;
import java.io.IOException;

public class Demo2
{
    public static void main(String[] args)
    {
        // Работа с файлами
        // Существование объекта File не привязано к существованию файла на диске
        // Конструктор File ничего на диске не создает
        // т.о. путь может указывать на несуществующий файл или директорию
        File java = new File("/usr/bin/java");
        java.exists();      // true
        java.isFile();      // true
        java.isDirectory(); // false

        // если файл не существует, вернут нули
        java.length();      // 1536
        java.lastModified();// 1231914805000 (в мс с 1970 г)

        // Работа с директориями
        File usrbin = new File("/usr/bin");
        usrbin.exists();
        usrbin.isFile();
        usrbin.isDirectory();   // true

        // Содержимое директории
        // только на 1 уровень (null если она не существует)
        usrbin.list();        // String[]
        usrbin.listFiles();     // File[]

        // Фильтрация файлов
        // java.io.FileFilter
        // boolean accept(File pathname);
        // java.io.FilenameFilter
        // boolean accept(File dir, String name);
        // Фильтр, реализующий FileFilter или FilenameFilter:
        // f -> f.getName().endsWith(".java")
        File[] javaSourceFiles = usrbin.listFiles(f -> f.getName().endsWith(".java"));

        // Создание файла
        // используется редко, чаще всего не просто создаем файл. а пишем в него
        // гарантируется атомарность операции
        File file = new File("~/.aliases");
        try {
            boolean success = file.createNewFile();
        } catch (IOException e) {
            // handle error
        }

        // Создание директории
        File dir = new File("a/b/c/d");
        boolean success = dir.mkdir();      // максимум 1 директория
        boolean success2 = dir.mkdirs();    // создает все уровни вложенности

        // Удаление файла или директории (она обязана быть пустой)
        boolean success3 = file.delete();

        // Переименование/ перемещение (платформенно зависимое перемещение!)
        File targetFile = new File("~/.config/.aliases");
        boolean success4 = file.renameTo(targetFile);

        // Метода копирования из коробки нет!!!
    }
}
