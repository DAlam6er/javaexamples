package com.stepik.javabasecourse.streamapi;

public class Palindrome
{
    public static boolean isPalindrome(String s)
    {
        StringBuilder leftToRight = new StringBuilder();
        s.chars()
            .filter(Character::isLetterOrDigit)
            .map(Character::toLowerCase)
            // appendCodePoint - добавляет в string builder символы по кодам
            .forEach(leftToRight::appendCodePoint);

        StringBuilder rightToLeft = new StringBuilder(leftToRight).reverse();

        return leftToRight.toString().equals(rightToLeft.toString());
    }
}
