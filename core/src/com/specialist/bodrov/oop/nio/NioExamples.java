package com.specialist.bodrov.oop.nio;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class NioExamples {

    public static void main(String[] args) {
        Path input = Path.of("input.txt");
        Path output = Path.of("output.txt");

        System.out.println(input.getClass().getSimpleName());
        System.out.println("hello".getClass());

        try {
            Files.copy(input, output, StandardCopyOption.REPLACE_EXISTING);
            Files.writeString(output, System.lineSeparator()
                    + "zzz", StandardOpenOption.APPEND);

            List<String> lines = Files.readAllLines(output);
            System.out.println(lines);
            System.out.println(lines.getClass().getCanonicalName());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
