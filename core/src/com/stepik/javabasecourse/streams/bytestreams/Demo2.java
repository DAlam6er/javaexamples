package com.stepik.javabasecourse.streams.bytestreams;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Demo2
{
    public static void main(String[] args)
    {
        // for io
        try (InputStream iois = new FileInputStream(new File("in.txt")))
        {
            // ...
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода");
        }

        try (OutputStream ioos = new FileOutputStream(new File("out.txt")))
        {
            // ...
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода");
        }

        // for nio
        // Конкретный класс потока неизвестен, з-т от того на какую ФС указывает путь
        try (InputStream niois = Files.newInputStream(Paths.get("in.txt")))
        {
            // ...
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода");
        }

        try (OutputStream nioos = Files.newOutputStream(Paths.get("out.txt")))
        {
            // ...
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода");
        }
    }
}
