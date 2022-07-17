package com.stepik.javabasecourse.streams.charstreams;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Demo2
{
    // добавление буферизации
    // public class BufferedReader extends Reader {
    //      public BufferedReader (Reader in)
    // Читает до символа, возвращающего конец строки (сам символ не возвращается)
    // Если дочитали до конца - возвращает null
    //      public String readLine()

    public static void main(String[] args)
    {
        // Прочитать построчно файл
        // Вариант 1 - BufferedReader
        try (BufferedReader br = new BufferedReader(
            new InputStreamReader(
                new FileInputStream("in.txt"), StandardCharsets.UTF_8)))
        {
            String line;
            while ((line = br.readLine()) != null) {
                // обработка строк файла
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода");
        }

        // Вариант 2 - с помощью nio Files.newBufferedReader
        try (BufferedReader br = Files.newBufferedReader(
            Paths.get("in.txt"), StandardCharsets.UTF_8))
        {
            String line;
            while ((line = br.readLine()) != null) {
                // обработка строк файла
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода");
        }

        // Вариант 3 - если файл небольшой
        try {
            List<String> lines = Files.readAllLines(
                Paths.get("in.txt"), StandardCharsets.UTF_8);

            for (String line : lines) {
                // обработка строк файла
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода");
        }

        // аналогично для BufferedWriter
        try (BufferedWriter writer = Files.newBufferedWriter(
            Paths.get("out.txt"), StandardCharsets.UTF_8))
        {
            writer.write("Hello");
            writer.newLine();   // разделитель строк на данной платформе
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода");
        }

        List<String> lines = Arrays.asList("Hello", "world");
        try {
            Files.write(Paths.get("out.txt"), lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода");
        }
    }
}
