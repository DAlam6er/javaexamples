package com.specialist.bodrov.oop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TryWithResources {

    public static void main(String[] args) {

        try(BufferedReader reader =
                    new BufferedReader(new InputStreamReader(System.in))){


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
