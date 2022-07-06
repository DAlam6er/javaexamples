package com.specialist.bodrov.oop.io;

import java.io.*;

public class CopyCharacters {

    private static final String INPUT = "input.txt";

    private static final String OUTPUT = "output.txt";

    public static void main(String[] args) {

        try (Reader in = new FileReader(INPUT);
             Writer out = new FileWriter(OUTPUT)){

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (IOException e){
            e.printStackTrace();
        }


    }
}

