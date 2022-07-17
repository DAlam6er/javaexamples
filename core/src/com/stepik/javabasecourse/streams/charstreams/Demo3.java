package com.stepik.javabasecourse.streams.charstreams;

import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Demo3
{
    // Форматированный ввод/вывод значений разного типа - надстройка над Reader, Writer

    // Форматированный вывод
    // класс PrintWriter extends Writer
    // PrintWriter конвертирует в строки объекты и спускает на нижележащий Writer
    // конструктор:
    //      PrintWriter(Writer out)
    // методы:
    //      void print(int i)
    //      void println(Object obj)
    //      PrintWriter printf(String format, Object ... args)
    //      boolean checkError() - внутренний флаг ошибки

    // PrintStream - еще один класс, похожий на PrintWriter
    // PrintStream extends FilterOutputStream
    // отличие в том, что
    //      оборачивает OutputStream, а не Writer
    //      PrintStream - это OutputStream
    //      делает 2 преобразования:
    //          из примитивных типов и объектов - в строку
    //          из строки - в байты, передаваемые в OutputStream
    // получается гибрид OutputStream + PrintWriter
    // PrintStream extends FilterOutputStream
    // конструктор:
    //      PrintStream(OutputStream out)
    // методы:
    //      void print(int i)
    //      void println(Object obj)
    //      PrintWriter printf(String format, Object ... args)
    //      boolean checkError()

    // Аналог PrintWriter и PrintStream для удобного чтения из потока символов
    public static void main(String[] args)
    {
        // java.io.StreamTokenizer
        // разбирает поток на слова и числа
        StreamTokenizer streamTokenizer =
            new StreamTokenizer(new StringReader("Hello world"));

        // java.util.StringTokenizer
        StringTokenizer stringTokenizer = new StringTokenizer("Hello world");

        Reader reader = new StringReader("abc|true|1,1e3|-42");
        Scanner scanner = new Scanner(reader)
            .useDelimiter("\\|")
            .useLocale(Locale.forLanguageTag("ru"));

        // парсинг примитивных типов и строк
        String token = scanner.next();
        boolean bool = scanner.nextBoolean();
        double dbl = scanner.nextDouble();
        int integer = scanner.nextInt();

        System.out.println(token);
        System.out.println(bool);
        System.out.println(dbl);
        System.out.println(integer);
    }
}
