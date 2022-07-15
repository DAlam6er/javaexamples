package com.stepik.javabasecourse.files.streams.bytestreams;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/*
Напишите метод, читающий входной поток и вычисляющий контрольную сумму прочитанных данных.
Контрольная сумма данных вычисляется по следующему алгоритму:
Контрольная сумма представляет собой число типа int.
Контрольная сумма пустого набора данных равна нулю.
Контрольная сумма непустого набора данных вычисляется
по следующей рекуррентной формуле:
C_{n+1}=rotateLeft(C_n) xor b_{n+1} ,
где
    C_n — контрольная сумма первых n байт данных,
    rotateLeft — циклический сдвиг бит числа на один бит влево, (Integer.rotateLeft)
    b_n — n-ный байт данных.
Поскольку метод не открывал данный InputStream, то и закрывать его он не должен.
Выброшенное из методов InputStream исключение должно выбрасываться из метода.

Пример
На вход подан InputStream, последовательно возвращающий три байта:
0x33 0x45 0x01.
В качестве контрольной суммы должно быть возвращено число 71.
 */
public class CheckSumOfStream
{
    public static void main(String[] args)
    {
        int result = -1;
        try (InputStream is =
                 new ByteArrayInputStream(new byte[] {0x33, 0x45, 0x01}))
        {
            result = checkSumOfStream(is);
        } catch (IOException e) {
            System.out.println("Произошла ошибка ввода/вывода");
        }
        System.out.println(result);
    }

    public static int checkSumOfStream(InputStream inputStream)
        throws IOException
    {
        int read;
        int sum = 0;
        while ((read = inputStream.read()) != -1) {
            sum = Integer.rotateLeft(sum, 1) ^ read;
        }
        return sum;
    }
}
