package com.headfirstjava.chap06.sinkthesite;

// StringTest class for DotComBust class
// Тестовый код пишется с позиции, что методы тестируемого класса
// уже реализованы
public class DotComBustTestDrive
{
    public static void main(String[] args)
    {
        DotComBust bust = new DotComBust();

        bust.setUpGame();
        // Тестируем метод setUpGame().
        // Если он отработал корректно, то объекты DotCom получили
        // имена и размещение на доске 7x7
        System.out.printf("Имена сайтов: %s, %s, %s\n",
            bust.getDotComsList().get(0).getName(),
            bust.getDotComsList().get(1).getName(),
            bust.getDotComsList().get(2).getName());
        System.out.printf("Местоположения начала сайтов: %s, %s, %s\n",
            bust.getDotComsList().get(0).getLocationCells().get(0),
            bust.getDotComsList().get(1).getLocationCells().get(0),
            bust.getDotComsList().get(2).getLocationCells().get(0));

        bust.startPlaying();
        // Тестируем метод startPlaying():
        // По окончании его отработки, не должно остаться ни одного DotCom
        System.out.printf("Список сайтов пуст: %s\n",
            bust.getDotComsList().isEmpty());

        // Тестируем метод checkUserGuess() путем ввода с клавиатуры значения
        bust.checkUserGuess(bust.getHelper().getUserInput("Ваш ход: "));

        // Тестируем метод finishGame() с малым количеством ходов
        bust.setNumOfGuesses(1);
        bust.finishGame();
        // Тестируем метод finishGame() с большим количеством ходов
        bust.setNumOfGuesses(100);
        bust.finishGame();
    }
}
