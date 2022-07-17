package com.stepik.javabasecourse.streams.bytestreams;

import java.io.*;

public class Demo
{
    // ----------------------------------------------------------------
    // Ввод данных
    // ----------------------------------------------------------------
    // java.io
    // public abstract class InputStream implements Closeable
    // Из него можно читать по байту или блоками байтов

    // по 1 байту:
    //      public abstract int read() throws IOException
    // Читает из входного потока 1 байт, возвращает int - считанный байт
    // Возвращает int, а не byte, т.к. 0...255 + (конец потока -1) = 257 значений
    // Чтобы получить прочитанное значение, не равное -1, приводим к byte (byte)

    // блоками байтов - читает из потока число байт, равное размеру массива
    // byte[] b - массив, в который мы записываем считанные байты
    // вариант №1
    //      public int read(byte[] b) throws IOException {
    //          return read(b, 0, b.length);
    //      }
    // вариант №2
    // off - индекс массива, начиная с которого этот массив нужно заполнять
    // len - число байт, которое нужно считать из входного потока и записать в массив
    // Возвращает фактически считанное количество байт, м.б. меньше запрошенного len
    // Ровно столько, сколько вернул read было записано в массив b,
    // и ровно столько мы можем дальше использовать
    // Если вернулось -1 - это конец потока.
    //      public int read(byte[] b, int off, int len) throws IOException {
    //          ...
    //      }

    // Пропускает n байт из входного потока
    // Возвращает фактическое количество байт, которое удалось пропустить (<= n)
    //      public long skip (long n) throws IOException

    // метод public int available () throws IOException
    // Он возвращает количество байт, которые из InputStream
    // можно прочитать прямо сейчас, не блокируясь.

    // ----------------------------------------------------------------
    // Вывод данных
    // ----------------------------------------------------------------
    // java.io
    // public abstract class OutputStream implements Closeable, Flushable
    // В него можно писать по 1 байту или блоками
    // write() не гарантирует, что данные тут же будут переданы ОС для обработки

    // по 1 байту - пишет в поток младшие 8 бит от переданного значения b
    //      public abstract void write(int b) throws IOException

    // запись блоками байтов
    // вариант №1 - пишет весь массив целиком в поток
    //      public void write(byte[] b) throws IOException {
    //          write(b, 0, b.length;
    //      }
    // вариант №2 - пишет указанное количество байт массива,
    // начиная с указанного индекса
    //      public void write(byte[] b, int off, int len) throws IOException {
    //          ...
    //      }

    // flush() - сбрасывает возможные промежуточные буфера,
    // где конкретная реализация OutputStream может накапливать данные перед передачей ОС
    // вызывать flush() перед close() не требуется, т.к. последний его сам вызывает
    // public void flush() throws IOException

    public static void main(String[] args)
    {
        // Копирование InputStream -> OutputStream
        int totalBytesWritten = 0;
        byte[] src = new byte[4096];    // источник для InputStream
        byte[] buf = new byte[1024];    // временный буфер размером 1 Кб
        byte[] result;
        int blocksize;                  // количество прочитанных байт
        try (InputStream is = new ByteArrayInputStream(src);
             OutputStream os = new ByteArrayOutputStream())
        {
            while ((blocksize = is.read(buf)) > 0) {
                os.write(buf, 0, blocksize);
                System.out.println("blocksize: " + blocksize);
                totalBytesWritten += blocksize;
            }
            if (os instanceof ByteArrayOutputStream) {
                result = ((ByteArrayOutputStream) os).toByteArray();
            }
            System.out.println("Total bytes written = " + totalBytesWritten);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
