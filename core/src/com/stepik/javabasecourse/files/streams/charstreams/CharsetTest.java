package com.stepik.javabasecourse.files.streams.charstreams;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

public class CharsetTest
{
    public static void main(String[] args)
    {
        try(Writer writer = new OutputStreamWriter(System.out, StandardCharsets.US_ASCII)) {
            writer.write("Я");
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода");
        }
    }
}
