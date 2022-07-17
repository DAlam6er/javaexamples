package com.stepik.javabasecourse.io;

import java.io.File;
import java.io.IOException;

public class Demo
{
    public static void main(String[] args)
    {
        // on Windows:
        File javaExecutable = new File("C:\\jdk1.8\\bin\\java.exe");
        File netWorkFolder = new File("\\\\server\\share");

        // on Unix:
        File lsExecutable = new File("/usr/bin/ls");

        // Сборка пути
        String sourceDirName = "src";
        String mainFileName = "Main.java";

        String mainFilePath = sourceDirName + File.separator + mainFileName;
        //String mainFilePath = sourceDirName + File.separatorChar + mainFileName;

        // Будет подставлен разделитель в зависимости от ОС
        File mainFile = new File(sourceDirName, mainFileName);

        // Абсолютные и относительные пути
        File absoluteFile = new File("/usr/bin/java");
        absoluteFile.isAbsolute(); // true
        absoluteFile.getAbsolutePath(); // /usr/bin/java

        File relativeFile = new File("readme.txt");
        relativeFile.isAbsolute();  // false
        relativeFile.getAbsolutePath(); // /home/stepic/readme.txt
        relativeFile.getAbsoluteFile(); // return File

        // Разбор пути
        File file = new File("/usr/bin/java");
        String path = file.getPath();       // /usr/bin/java
        String name = file.getName();       // java
        String parent = file.getParent();   // /usr/bin
        File parentFile = file.getParentFile();

        // Канонические пути
        // Задача сравнить, указывают ли два экземпляра класса File на 1 и тот же файл на диске
        // symlink - символьная ссылка
        File file1 = new File("./prj/../symlink.txt");

        try {
            // "/home/stepic/readme.txt"
            // требует обращения к диску
            String canonicalPath = file.getCanonicalPath();
            File canonicalFile = file.getCanonicalFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // В каноническом пути разрешаются(приводятся) точки и символические ссылки
        // Приведя два пути к каноническому виду, их можно сравнивать как строки
    }
}
