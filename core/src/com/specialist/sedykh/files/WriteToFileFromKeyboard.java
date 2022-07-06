package com.specialist.sedykh.files;

import java.io.*;

public class WriteToFileFromKeyboard
{
    public static void main(String[] args) {
        /*
            Запись в файл с клавиатуры с использованием BufferedOutputStream
         */
        /*
        try (BufferedReader br =
                 new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream bos =
            new BufferedOutputStream(new FileOutputStream(br.readLine()))
        )
        {
            while (true) {
                String line = br.readLine() + System.lineSeparator();
                byte[] buffer = line.getBytes();
                bos.write(buffer, 0, buffer.length);
                if (("exit" + System.lineSeparator()).equals(line)) break;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         */

        /*
            Запись в файл с клавиатуры с использованием BufferedWriter
         */
        try (BufferedReader br =
                 new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw =
                 new BufferedWriter(new FileWriter(br.readLine()))
        )
        {
            while (true) {
                String line = br.readLine() + System.lineSeparator();
                bw.write(line);
                if (("exit" + System.lineSeparator()).equals(line)) break;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
