package com.regexpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test
{
    public static void main(String[] args)
    {
        Pattern p1 = Pattern.compile("[x-z^\\p{Digit}]");
        Matcher m = p1.matcher("z5");
        print(m);
    }

    static void print(Matcher m)
    {
        while (m.find()) {
            System.out.printf("%d: %s\n", m.start(), m.group());
        }
    }
}
