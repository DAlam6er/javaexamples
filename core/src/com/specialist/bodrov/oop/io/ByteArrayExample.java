package com.specialist.bodrov.oop.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class ByteArrayExample {

    public static void main(String[] args) {
        byte[] b = {1,2,3};

        System.out.println(Arrays.toString(b));

        int c;
        try (InputStream is = new ByteArrayInputStream(b)){
            while ((c = is.read()) != -1){
                System.out.println(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
