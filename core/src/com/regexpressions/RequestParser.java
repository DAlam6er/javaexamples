package com.regexpressions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Парсер реквестов
Ввод: http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод: lvl view name

Ввод: http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод: obj name
       double: 3.14
*/

public class RequestParser
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
        String url = reader.readLine();
        Pattern pattern = Pattern.compile(
            "((?<=\\?)\\w*)|((?<=&)\\w*)|((?<=obj=)\\w*\\.?\\w*)");
        Matcher matcher = pattern.matcher(url);
        List<String> list = new ArrayList<>();
        while (matcher.find()) {
            list.add(matcher.group());
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i != list.size() - 1) {
                System.out.print(" ");
            } else {
                System.out.println();
            }
            if ("obj".equals(list.get(i))) i++;
        }
        for (int i = 0; i < list.size(); i++) {
            if ("obj".equals(list.get(i))) {
                if (isNumber(list.get(++i))) {
                    alert(Double.parseDouble(list.get(i)));
                } else {
                    alert(list.get(i));
                }
            }
        }
    }

    public static boolean isNumber(String strNum)
    {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }


    public static void alert(double value)
    {
        System.out.println("double: " + value);
    }

    public static void alert(String value)
    {
        System.out.println("String: " + value);
    }
}
