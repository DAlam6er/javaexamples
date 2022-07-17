package com.stepik.javabasecourse.streams.bytestreams;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class SocketDemo
{
    public static void main(String[] args)
    {
        try (Socket socket = new Socket("ya.ru", 80))
        {
            OutputStream os = socket.getOutputStream();
            os.write("GET / HTTP/1.0\r\n\r\n".getBytes(StandardCharsets.UTF_8));
            os.flush();

            InputStream is = socket.getInputStream();
            int read;
            while ((read = is.read()) >= 0) {
                System.out.print((char) read);
            }
            System.out.println();
        } catch (UnknownHostException e) {
            System.out.println("Хост не найден!");
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода");
        }
    }
}
