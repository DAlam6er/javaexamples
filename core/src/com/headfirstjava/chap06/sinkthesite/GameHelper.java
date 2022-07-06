package com.headfirstjava.chap06.sinkthesite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;

public class GameHelper
{
    private static final String ALPHABET = "abcdefg";
    private final int gridLength = 7;
    private final int gridSize = 49;
    private final int[] grid = new int[gridSize];
    private int comCount = 0;

    /**
     * Принимает данные пользовательского ввода
     * @param promt приглашение к вводу
     * @return Строка, считанная из командной строки
     */
    public String getUserInput(String promt)
    {
        String inputLine = null;
        System.out.println(promt + " ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        assert inputLine != null;
        return inputLine.toLowerCase();
    }

    /**
     * Создание ячеек с адресами объектов DotCom
     * @param comSize размер, занимаемый DotCom
     * @return массив адресов объекта DotCom
     */
    public ArrayList<String> placeDotCom(int comSize)
    {

        ArrayList<String> alphaCells = new ArrayList<String>();
        String[] alphacoords = new String[comSize];             // Хранит координаты типа f6
        String temp = null;                                     // Временная координата для конкатенации
        int[] coords = new int[comSize];                        // Координаты текущего сайта
        int attempts = 0;                                       // Счетчик текущих попыток
        boolean success = false;                                // Нашли подходящее местоположение?
        int location = 0;                                       // Текущее начальное местоположение

        comCount++;                                             // n-й сайт для размещения
        int incr = 1;                                           // устанавливаем горизонтальный инкремент
        if ((comCount % 2) == 1) {                              // Если нечетный (размещаем вертикально)
            incr = gridLength;                                  // Устанавливаем вертикальный инкремент
        }

        while (!success & attempts++ < 200) {                   // Главный поисковый цикл (32)
            location = (int) (Math.random() * gridSize);        // Получаем случайную стартовую точку
            System.out.print("Пробуем " + location + " ");
            int x = 0;                                          // n-я позиция в "сайте", который нужно разместить
            success = true;                                     // Предполагаем успешный исход
            while (success && x < comSize) {                    // Ищем соседнюю неиспользованную ячейку
                if (grid[location] == 0) {                      // Если еще не используется
                    coords[x++] = location;                     // Сохраняем местоположение
                    location += incr;                           // Пробуем следующую соседнюю ячейку
                    if (location >= gridSize) {                 // Вышли за рамки - низ
                        success = false;                        // Неудача
                    }
                    if (x > 0 && (location % gridLength == 0)) { // Вышли за рамки - правый край
                        success = false;                         // Неудача
                    }
                } else {                                         // Нашли уже использующееся местоположение
                    System.out.print("Используется " + location);
                    success = false;                             // Неудача
                }
            }
        }
        int x = 0;                                               // Переводим местоположение в символьные координаты
        int row = 0;
        int column = 0;
        System.out.print("\n");
        while (x < comSize) {
            grid[coords[x]] = 1;                                // Помечаем ячейки на главной сетке как "использованные"
            row = (int) (coords[x] / gridLength);               // Получаем значение строки
            column = coords[x] % gridLength;                    // Получаем числовое значение столбца
            temp = String.valueOf(ALPHABET.charAt(column));     // Преобразуем его в строковый символ

            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
            System.out.print("      coord" + x + " = " + alphaCells.get(x-1) + " ");
        }
        System.out.print("\n");
        return alphaCells;
    }
}
