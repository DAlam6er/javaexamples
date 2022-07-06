package com.specialist.bodrov.oop.io;

import java.io.*;

public class CopyBytes {

    private static final String INPUT =
            "C:\\Users\\student\\Desktop\\java-2021\\input.txt";

    private static final String OUTPUT = "output.txt";

    public static void main(String[] args) {

        try (InputStream in = new FileInputStream(INPUT);
             OutputStream out = new FileOutputStream(OUTPUT)){

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (IOException e){
            e.printStackTrace();
        }


    }
}

