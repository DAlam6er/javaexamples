package com.stepik.javabasecourse.streams.charstreams;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ReadInputStream
{
    public static void main(String[] args)
    {
        InputStream is = new ByteArrayInputStream(
            new byte[]{48, 49, 50, 51});
        String result = null;
        try {
            result = readAsString(is, StandardCharsets.US_ASCII);
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода");
        }
        System.out.println(result);
    }

    public static String readAsString(InputStream inputStream, Charset charset)
        throws IOException
    {
        // Вариант 1
        /*
        StringBuilder sb = new StringBuilder();
        int read;
        try (InputStreamReader br =
                 new InputStreamReader(inputStream, charset))
        {
            while ((read = br.read()) >= 0) {
                sb.append((char)read);
            }
            return sb.toString();
        }
         */

        // Вариант 2
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream())
        {
            int read;
            while ((read = inputStream.read()) != -1) {
                outputStream.write(read);
            }
            return outputStream.toString(charset);
        }
    }
}
