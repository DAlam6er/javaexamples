package com.stepik.javabasecourse.files.nio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Demo2
{
    public static void main(String[] args)
    {
        Path path = Paths.get("src/com/stepik/javabasecourse/files/nio/PECS.java");

        // ReadableByteChannel - аналог InputStream
        // WritableByteChannel - аналог OutputStream
        try (ReadableByteChannel in = FileChannel.open(path);
             WritableByteChannel out = Channels.newChannel(System.out))
        {
            // аналог массива
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            // read - неблокирующий метод, позволяет прочитать столько данных,
            // сколько можно и не ждать
            // если в канале нет ни одного доступного для чтения байта
            // метод сразу возвращает управление, ничего не делая и не ожидая

            while (in.read(buffer) >= 0 || buffer.position() != 0) {
                buffer.flip();
                // если канал не готов ничего принять,
                // метод возвращает управление, ничего не ожидая
                out.write(buffer);
                buffer.compact();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        /*
        try (InputStream in = Files.newInputStream(path);
             OutputStream out = System.out)
        {
            byte[] buffer = new byte[1024];
            int bytesRead;
            // read - блокирующий метод чтения
            while ((bytesRead = in.read(buffer)) > 0) {
                // write - блокирующий метод записи
                out.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
         */
    }
}
