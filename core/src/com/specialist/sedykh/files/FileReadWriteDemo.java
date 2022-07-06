package com.specialist.sedykh.files;

import java.io.*;

public class FileReadWriteDemo
{
    public static void main(String[] args)
    {
        writeHelloToFile("hello.txt");

        String str = null;
        try {
            str = readFromFile("string.txt");
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFromFile(String pathName) throws IOException
    {
        // Unicode only!
//        BufferedReader reader = new BufferedReader(new FileReader(pathName));
        // any charsetName!
        BufferedReader reader =
            new BufferedReader(
                new InputStreamReader(
                    new FileInputStream(pathName), "utf8"
                )
            );
        return reader.readLine();

    }

    private static void writeHelloToFile(String pathName)
    {
        // исключение прямо в конструкторе
        try (FileWriter writer = new FileWriter(pathName)) {
            writer.write("Привет из Java!");
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
