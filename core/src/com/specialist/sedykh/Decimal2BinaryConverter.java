package com.specialist.sedykh;

public class Decimal2BinaryConverter
{
    public static String getBinary(int num)
    {
        int i, j;
        StringBuilder str = new StringBuilder();
        for (i = 0,j = 0; i <= 31; i++) {
            if ((num & 1) == 1) {
                str.append("1");
            } else {
                str.append("0");
            }
            num >>= 1;
            if (i == 3 + j*4) {
                str.append(" ");
                j++;
            }
        }
        return str.reverse().toString();
    }

    public static void main(String[] args)
    {
        int num = 56;
        System.out.println(getBinary(num));
    }
}
