package com.specialist.bodrov.base;

import java.nio.charset.Charset;
import java.util.Arrays;

public class StringExamples {

    public static void main(String[] args) {
        int i = 1;
        char c = 'A';
        String s = "Hello";
        String nullPointer = null;
        Integer integer = null;


        s.toUpperCase();
        System.out.println(s);
        System.out.println(s.toUpperCase());

        Object o1 = new Object();
        Object o2 = new Object();

        System.out.println(o1 == o2);
        o1 = o2;
        System.out.println(o1 == o2);
        System.out.println("---");

        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println("---");

        Integer int1 = 128;
        Integer int2 = 128;
        System.out.println(int1 == int2);

        int1 = 127;
        int2 = 127;
        System.out.println(int1 == int2);
        System.out.println("---");

        System.out.println("hello".indexOf('h'));
        System.out.println("hello".indexOf('l'));
        System.out.println("hello".lastIndexOf('l'));
        System.out.println("helllo".lastIndexOf('l'));

        byte[] bArray = "hello".getBytes(Charset.forName("UTF-8"));
        System.out.println(Arrays.toString(bArray));
        System.out.println(new String(bArray, Charset.forName("UTF-8")));

        int число = 1;
        String str = "hello";
        System.out.println(str.substring(0, 4));
        System.out.println("hello".replace('l','L'));

        String result = "Hello" + " everyone!";
        System.out.println(str);
        System.out.println(result);

        StringBuilder strNumbers = new StringBuilder();
        for (int j = 1; j <= 10; j++) {
            strNumbers.append(j).append(", ");
        }
//        strNumbers.delete(strNumbers.length() - 2, strNumbers.length());
        strNumbers.replace(strNumbers.length() - 2, strNumbers.length(), ".");
        System.out.println(strNumbers);
        System.out.println("---");

        String newString = "hello";
        newString = "hello2";
        System.out.println(newString.length());
        System.out.println("---");

        String emptyString = "";
        System.out.println(emptyString.length());
        System.out.println("" == null);

        String nullString = null;
        Object o3 = null;
        System.out.println(nullString == o3);
        System.out.println();
        System.out.println("---");
        StringBuilder sb1 = new StringBuilder("abc");
        StringBuilder sb2 = new StringBuilder("abc");

        System.out.println(sb1);
        System.out.println(sb2);
        System.out.println(sb1 == sb2);
        System.out.println(sb1.equals(sb2));
        System.out.println("---");

        System.out.println("".isEmpty());
        System.out.println("     \t\n".isBlank());
        System.out.println("aaa\nbbb\nccc");

        System.out.println(Arrays.toString("hello".toCharArray()));
        System.out.println("---");
        String regex = "\\d*";
        System.out.println("263236".matches(regex));
        System.out.println("62.235".matches(regex));
        System.out.println("a932".matches(regex));
        System.out.println("---");

        String[] splitedString = "Hello, my name is Victor, Are you?".split(",");

        System.out.println(Arrays.toString(splitedString));
        for (String stringElement : splitedString) {
            System.out.println(stringElement.trim());
        }





    }
}
