package com.eduprof.tikhomirov;

import java.io.*;

public class CopyFiles
{
    private static final String INPUT =
        "D:\\input.txt";
    private static final String OUTPUT =
        "D:\\output.txt";

    public static void main(String[] args)
    {
        copyLines(INPUT, OUTPUT);
    }

    public static void copyLines(String inputFile, String outFile)
    {
        try (BufferedReader reader = new BufferedReader(
            new FileReader(inputFile));
            Writer writer = new FileWriter(outFile))
        {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.write(" (" + line.length() + " characters)");
                writer.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
