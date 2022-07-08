package com.stepik.javabasecourse.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Demo
{
    public static void main(String[] args)
    {
        // аналог java.io.File - это java.nio.file.Path
        Path path = Paths.get("prj/stepic");
        // nio -> io
        File fromPath = path.toFile();
        // io -> nio
        Path fromFile = fromPath.toPath();

        // Разбор пути
        Path java = Paths.get("/usr/bin/java");
        java.isAbsolute();      // true
        java.getFileName();     // java
        java.getParent();       // /usr/bin

        java.getNameCount();    // 3
        java.getName(1);   // bin - получение компонента пути по индексу
        java.resolveSibling("javap");   // /usr/bin/javap
        java.startsWith("/usr");    // true - проверка, является ли один путь префиксом другого
        Paths.get("/usr").relativize(java); // bin/java - вычисление относительного пути между 2 местами в ФС

        // Работа с файлами
        // В интерфейсе Path в отличие от File нет методов доступа к ФС
        Files.exists(java);     // true
        Files.isRegularFile(java);
        try {
            Files.size(java);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.getLastModifiedTime(java).toMillis();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.copy(
                java, Paths.get("/usr/bin/java_copy"),
                StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Работа с директориями
        Path usrbin = Paths.get("/usr/bin");
        Files.exists(usrbin);
        Files.isDirectory(usrbin);

        // Получение содержимого директории
        // Позволяет обрабатывать большие директории в потоковом режиме небольшими порциями
        // usrbin - фильтр
        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(usrbin))
        {
            for (Path child : dirStream) {
                System.out.println(child);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Создать директории
        Path dir = Paths.get("a/b/c/d");
        try {
            Files.createDirectory(dir);     // как mkdir() в File
        } catch (IOException e) {
            e.printStackTrace();
        }
        // создать директорию и все родительские директории
        try {
            Files.createDirectories(dir);   // как mkdirs() в File
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Рекурсивное удаление
        Path directory = Paths.get("/tmp");
        try {
            // SimpleFileVisitor - объект, реализующий FileVisitor
            Files.walkFileTree(directory, new SimpleFileVisitor<Path>()
            {
                // Метод, вызываемый после того, как файл был найден
                @Override
                public FileVisitResult visitFile
                    (Path file, BasicFileAttributes attrs) throws IOException
                {
                    Files.delete(file);
                    // Возвращаемое значение - что делать дальше
                    return FileVisitResult.CONTINUE;
                }

                // Метод, вызываемый после выхода из директории
                @Override
                public FileVisitResult postVisitDirectory
                    (Path dir, IOException exc) throws IOException
                {
                    if (exc == null) {
                        Files.delete(dir);
                        // Возвращаемое значение - что делать дальше
                        return FileVisitResult.CONTINUE;
                    } else {
                        throw exc;
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Реализация виртуальной ФС
        Path zipPath = Paths.get("jdk1.8.0_60/src.zip");

        try (FileSystem zipfs = FileSystems.newFileSystem(zipPath))
        {
            for (Path rootDirectory : zipfs.getRootDirectories()) {
                Files.walkFileTree(path, new SimpleFileVisitor<>() {
                    @Override
                    public FileVisitResult visitFile
                        (Path file, BasicFileAttributes attrs) throws IOException
                    {
                        System.out.println(file);
                        return FileVisitResult.CONTINUE;
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
