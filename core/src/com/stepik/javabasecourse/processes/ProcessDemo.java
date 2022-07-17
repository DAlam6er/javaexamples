package com.stepik.javabasecourse.processes;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ProcessDemo
{
    public static void main(String[] args)
    {
        // подготовительная работа по запуску внешнего процесса
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder
            .command("cmd.exe", "/c", "dir C:\\Users\\Антон")                // команда
            .directory(new File("D:\\Prog"))                        // рабочая директория
            .redirectInput(ProcessBuilder.Redirect.from(                    // куда будет подключаться стандартный поток ввода
                new File("NUL")))
            .redirectOutput(ProcessBuilder.Redirect.PIPE)                   // куда будет подключаться стандартный поток вывода
            .redirectError(ProcessBuilder.Redirect.INHERIT);                // куда будет подключаться стандартный поток ошибок
        // Redirect.PIPE - между java-процессом и запускаемым процессом
        // в этом случае в java программе получим явно этот поток,
        // и сможем из него читать или в него писать

        // Redirect.INHERIT - новый процесс наследует поток java-процесса
        // т.о. всё, что новый процесс выведет в std err, попадет в std err java-процесса

        // Redirect.from - перенаправить поток из файла
        // направляем на вход запущенному процессу содержимое /dev/null - пустой

        Process process = null;
        try {
            // стартуем новый процесс
            process = processBuilder.start();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        try (BufferedReader br = new BufferedReader(
            // то, что для запускаемого процесса является потоком вывода
            // со стороны java-потока является потоком ввода и наоборот
            new InputStreamReader(process.getInputStream(), "CP866")))
        {
            // реализуем "руками" INHERIT:
            // принимаем всё, что запущенный процесс выводит
            // и записываем это в поток стандартного вывода java-процесса
            br.lines().forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        int exitValue = 0;
        try {
            // дожидаемся завершения работы дочернего процесса
            // и получаем его код возврата
            exitValue = process.waitFor();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        if (exitValue != 0) {
            System.err.println("Subprocess terminated abnormally");
        }
    }
}
