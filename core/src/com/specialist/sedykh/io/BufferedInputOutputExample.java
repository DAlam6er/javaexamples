package com.specialist.sedykh.io;

import java.io.*;

public class BufferedInputOutputExample
{
    public static void main(String[] args)
    {
        try (InputStream inputStream = new FileInputStream("string.txt");
             BufferedInputStream buffer = new BufferedInputStream(inputStream))
        {
            while (buffer.available() > 0) {
                char c = (char) buffer.read();
                System.out.println("Был прочитан символ " + c);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (FileOutputStream outputStream =
                 new FileOutputStream("IloveJava.txt");
             BufferedOutputStream bufferedStream =
                 new BufferedOutputStream(outputStream))
        {
            // Преобразуем строку в массив байтов и запишем в файл
            String text = "I love Java!";
            byte[] buffer = text.getBytes();

            bufferedStream.write(buffer, 0, buffer.length);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
