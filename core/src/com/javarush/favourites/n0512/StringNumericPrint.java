package com.javarush.favourites.n0512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/* 
Разные методы для разных типов
*/

public class StringNumericPrint
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        String key;
        try {
            while (!"exit".equals(key = br.readLine())) {
                if (isNumeric(key)) {
                    if (key.contains(".")) {
                        print(Double.parseDouble(key));
                    } else {
                        int intKey = Integer.parseInt(key);
                        if (intKey > 0 && intKey < 128) {
                            print(Short.parseShort(key));
                        } else {
                            print(Integer.parseInt(key));
                        }
                    }
                } else {
                    print(key);
                }
            }
        } catch (NumberFormatException ex) {
            System.out.println("Число не может быть корректно преобразовано");
        }
        br.close();
    }

    public static boolean isNumeric(String strNum)
    {
        String regex = "-?\\d+(\\.\\d+)?";
        Pattern pattern = Pattern.compile(regex);
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
