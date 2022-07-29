package com.specialist.sedykh.io;

import java.io.File;
import java.io.IOException;

public class FilesDemo
{
    public static void main(String[] args)
    {
        File file = new File("test.txt");
        try {
            file.createNewFile(); // потенциально опасный метод
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }

        File dir = new File(".");
        File[] files = dir.listFiles(currentFile -> currentFile.isFile());
        for (File f : files) {
            System.out.println(f.getName());
        }
    }
}
