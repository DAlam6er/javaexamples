package com.stepik.javabasecourse.streams.charstreams;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Demo
{
    // базовый абстрактный уровень
    // Ввод данных:
    // java.io.Reader
    // Те же методы, что у InputStream:
    //      int read() - возвращает int, со значащими 2 младшими байтами
    //      int read(char cbuf[])
    //      abstract int read(char cbuf[], int off, int len)
    //      long skip(long n)
    //      abstract void close()

    // Вывод данных:
    // java.io.Writer
    // Те же методы, что у OutputStream:
    //      void write(int c)
    //      void write(char cbuf[])
    //      abstract void write(char cbuf[], int off, int len)
    //      abstract void flush()
    //      abstract void close()
    // Новые методы по сравнению с OutputStream
    //      void write(String str)
    //      void write(String str, int off, int len)

    public static void main(String[] args) throws IOException
    {
        // Превращаем произвольный поток байтов в поток символов
        InputStream inputStream =
            new ByteArrayInputStream(new byte[]{65, 66, 67});
        Reader reader = new InputStreamReader(inputStream, "UTF-8");

        // UTF-8 кодирует каждый символ последовательностью от 1 до 4 байт
        // платформонезависимость - все JVM поддерживают
        Charset charset = StandardCharsets.UTF_8;
        // не гарантируется наличие кодировки в JVM
        Charset charset1 = Charset.forName("Windows-1251");

        // Кодировка по умолчанию Зависит от ОС, настроек и параметров запуска JVM
        // на нее не следует полагаться для создания переносимых программ
        System.out.println(Charset.defaultCharset());

        OutputStream outputStream = System.out;
        Writer writer = new OutputStreamWriter(outputStream, charset);

        // Для чтения и записи текстовых файлов
        // Недостаток: кодировку можно указывать только с java 11
        Reader reader1 = new FileReader("in.txt", StandardCharsets.UTF_8);
        reader1.close();
        Writer writer1 = new FileWriter("out.txt", StandardCharsets.UTF_8);
        writer1.close();

        // Способ указать кодировку для чтения/записи файлов до java 11
        Reader reader2 = new InputStreamReader(
            new FileInputStream("in.txt"), StandardCharsets.UTF_8);

        Writer writer2 = new OutputStreamWriter(
            new FileOutputStream("out.txt"), StandardCharsets.UTF_8);

        // Для чтения символов из массива символов или строки в памяти
        Reader reader3 = new CharArrayReader(new char[]{'a', 'b', 'c'});
        Reader reader4 = new StringReader("Hello World");

        // Для записи в массив символов или строку
        CharArrayWriter writer3 = new CharArrayWriter();
        writer3.write("Test");
        char[] resultArray = writer3.toCharArray();

        StringWriter writer4 = new StringWriter();
        writer4.write("Test");
    }
}
