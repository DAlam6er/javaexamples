package com.specialist.sedykh;

public class StringBuilderDemo
{
    public static void main(String[] args)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append(' ');
        sb.append("World");
        sb.append('!');

        System.out.println(sb);
    }
}
