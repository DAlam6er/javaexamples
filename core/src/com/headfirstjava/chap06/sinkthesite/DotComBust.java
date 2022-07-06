package com.headfirstjava.chap06.sinkthesite;

import java.util.ArrayList;

public class DotComBust
{
    private final GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;

    protected GameHelper getHelper()
    {
        return helper;
    }

    protected ArrayList<DotCom> getDotComsList()
    {
        return dotComsList;
    }

    protected void setDotComsList(ArrayList<DotCom> dotComsList)
    {
        this.dotComsList = dotComsList;
    }

    protected int getNumOfGuesses()
    {
        return numOfGuesses;
    }

    protected void setNumOfGuesses(int numOfGuesses)
    {
        this.numOfGuesses = numOfGuesses;
    }

    protected void setUpGame()
    {
        // Создадим несколько "сайтов" и присвоим им адреса
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);

        System.out.println("Ваша цель — потопить три \"сайта\":");
        System.out.printf("%s, %s, %s\n", one.getName(), two.getName(), three.getName());
        System.out.println(
            "Постарайтесь потопить их за минимальное количество ходов!");

        for (DotCom dotComToSet : dotComsList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }

    protected void startPlaying()
    {
        while (!dotComsList.isEmpty()) {
            String userGuess = helper.getUserInput("Сделайте ход:");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    protected void checkUserGuess(String userGuess)
    {
        numOfGuesses++;
        String result = "Мимо";

        for (DotCom dotComTest : dotComsList) {
            result = dotComTest.checkYourself(userGuess);
            if ("Попал".equals(result)) {
                break;
            }
            if ("Потопил".equals(result)) {
                dotComsList.remove(dotComTest);
                break;
            }
        }
        System.out.println(result);
    }

    protected void finishGame()
    {
        System.out.println("Все \"сайты\" ушли ко дну! " +
            "Ваши акции теперь ничего не стоят.");
        if (numOfGuesses <= 18) {
            System.out.println("Это заняло у вас всего " +
                numOfGuesses + " попыток.");
            System.out.println("Вы успели выбраться до того, " +
                "как ваши вложения утонули.");
        } else {
            System.out.println("Это заняло у вас довольно много времени — " +
                numOfGuesses + " попыток.");
            System.out.println("Рыбы водят хороводы вокруг ваших вложений.");
        }
    }

    public static void main(String[] args)
    {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
}
