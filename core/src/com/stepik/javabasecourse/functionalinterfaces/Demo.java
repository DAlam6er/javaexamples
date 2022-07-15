package com.stepik.javabasecourse.functionalinterfaces;

import java.io.File;
import java.io.FileFilter;
import java.util.Optional;

public class Demo
{
    public static void main(String[] args)
    {
        File directory =
            new File("./src/com/stepik/javabasecourse/files/io");
        Optional<File[]> javaSourceFiles = Optional.ofNullable(
            directory.listFiles(new FileFilter()
        {
            // здесь используется функциональный интерфейс
            // в метод передается кусок программной логики
            // то метод объявляется как принимающий экземпляр какого-то класса или интерфейса
            @Override
            public boolean accept(File file)
            {
                // логика фильтрации
                return file.getName().endsWith(".java");
            }
        }));

        for (File srcFile :
            javaSourceFiles.orElseThrow(ArrayIndexOutOfBoundsException::new))
        {
            System.out.println(srcFile.getName());
        }
    }
}


