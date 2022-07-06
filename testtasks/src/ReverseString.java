/*
Написать метод, который разворачивает строку в обратном порядке
и замерить время работы этого метода на 1000, 10 000, 100 000 повторений.
оформить надо в виде stand alone java приложения с консольным вводом строки.
результатом работы должны быть строка, развернутая строка и 3 цифры (время работы).
 */
public class ReverseString
{
    private String originalString;
    private String reversedString;

    public static void main(String[] args)
    {
        String str = "Лошадь";
        System.out.println(reverse(str));
    }

    public static String reverse(String string)
    {
        long start = System.currentTimeMillis();

        long finish = System.currentTimeMillis();
        return String.format("%03d", finish - start);
    }
}
