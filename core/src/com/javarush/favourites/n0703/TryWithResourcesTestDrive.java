package com.javarush.favourites.n0703;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/*
Если ресурсов много
*/

public class TryWithResourcesTestDrive
{
    public static void main(String[] args) throws IOException
    {

        try (Scanner scanner = new Scanner(System.in);
             BufferedReader bufferedReader =
                 Files.newBufferedReader(Path.of(scanner.nextLine())))
        {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Something went wrong : " + e);
        }
    }
}
