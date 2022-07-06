package com.specialist.bodrov.oop.io;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFile {

    public static final String INPUT = "input.txt";
    public static final String OUTPUT = "output.txt";
    public static final String ZIP_FILE = "compressed.zip";

    public static void main(String[] args) {


        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(ZIP_FILE));
             InputStream fis1 = new FileInputStream(INPUT);
             InputStream fis2 = new FileInputStream(OUTPUT)) {

            ZipEntry zipEntry1 = new ZipEntry(INPUT);
            ZipEntry zipEntry2 = new ZipEntry(OUTPUT);

            byte[] array = new byte[1024];

            int len;

            zipOut.putNextEntry(zipEntry1);
            while ((len = fis1.read(array)) != -1) {
                zipOut.write(array, 0, len);
            }

            zipOut.putNextEntry(zipEntry2);
            while ((len = fis2.read(array)) != -1) {
                zipOut.write(array, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
