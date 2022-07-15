package com.stepik.javabasecourse.files.streams.bytestreams;

import java.io.*;
import java.util.Arrays;

public class EndOfLine
{
    public static void main(String[] args)
    {
        try (InputStream is =
                 new ByteArrayInputStream(
                     new byte[]{65, 66, 13, 13, 10, 10, 13, 67, 13, 13}))
        {
            byte[] result = convertCRLF(is);
            System.out.println(Arrays.toString(result));

            System.out.write(result);
            System.out.flush();
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода");
        }
    }

    public static byte[] convertCRLF(InputStream is) throws IOException
    {
        final byte CR = 13;
        final byte LF = 10;
        // Вариант 1 - флаговая переменная
        /*
        int read;
        boolean crFlag = false;

        try (ByteArrayOutputStream osResult = new ByteArrayOutputStream())
        {
            while ((read = is.read()) != -1) {
                if (crFlag && read != LF) {
                    crFlag = false;
                    osResult.write(CR);
                }

                if (read == CR && is.available() > 0) {
                    crFlag = true;
                    continue;
                }

                if (read == LF) {
                    crFlag = false;
                }

                osResult.write(read);
            }
            return osResult.toByteArray();
        }
         */

        // Вариант 2 - сокращенный
        int curByte, prevByte;
        prevByte = is.read();
        try (ByteArrayOutputStream osResult = new ByteArrayOutputStream())
        {
            while (prevByte >= 0) {
                curByte = is.read();
                if (prevByte != CR || curByte != LF) {
                    osResult.write(prevByte);
                }
                prevByte = curByte;
            }
            return osResult.toByteArray();
        }
    }
}
