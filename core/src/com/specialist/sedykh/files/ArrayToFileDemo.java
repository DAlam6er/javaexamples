package com.specialist.sedykh.files;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class ArrayToFileDemo
{
    public static void main(String[] args)
    {
        int[] m = new int[100];
        Random rnd = new Random();
        for (int i = 0; i < m.length; i++) {
            m[i] = rnd.nextInt(1000);
        }

        writeArrayToFile(m, "array");
        File file = new File("array");
        System.out.println(Arrays.toString(readArrayFromFile(file)));
    }

    private static void writeArrayToFile(int[] m, String name)
    {
        try (DataOutputStream dos = new DataOutputStream(
            new BufferedOutputStream(new FileOutputStream(name))))
        {
            // Пишем заголовок о числе элементов для упрощения чтения файла
            dos.writeInt(m.length);
            for (int mi : m) {
                dos.writeInt(mi);
            }
        } catch (IOException ignored) { }
    }

    private static int[] readArrayFromFile(File file)
    {

        int[] res = null;
        try (DataInputStream dis = new DataInputStream(
            new BufferedInputStream(
                new FileInputStream(file))))
        {
            // Читаем заголовок для инициализации массива
            res = new int[dis.readInt()];
            for (int i = 0; i < res.length; i++) {
                res[i] = dis.readInt();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return res;
    }
}
