package com.stepik.javabasecourse.files.streams.bytestreams;

import java.io.*;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class DeflaterInflaterStream
{
    public static void main(String[] args)
    {
        byte[] originalData = {1, 2, 3, 4, 5};

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        // Сжатие данных на лету по алгоритму Deflate
        try (OutputStream dos = new DeflaterOutputStream(os)) {
            dos.write(originalData);
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода");
        }

        byte[] deflatedData = os.toByteArray();

        // распаковка данных
        try (InputStream iis = new InflaterInputStream(
            new ByteArrayInputStream(deflatedData)))
        {
            int read;
            while ((read = iis.read()) >= 0) {
                System.out.printf("%02x ", read);
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода");
        }
    }
}
