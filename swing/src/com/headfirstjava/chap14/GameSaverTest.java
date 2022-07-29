package com.headfirstjava.chap14;

import java.io.*;

public class GameSaverTest
{
    public static void main(String[] args)
    {
        GameCharacter one = new GameCharacter(
            50, "Elf",
            new String[]{"bow", "sword", "brass knuckles"});
        GameCharacter two = new GameCharacter(
            200, "Troll", new String[]{"bare hands", "big ax"});
        GameCharacter three = new GameCharacter(
            120, "Sorcerer", new String[]{"spells", "invisibility"});

        try (ObjectOutputStream os = new ObjectOutputStream(
            new FileOutputStream("Game.ser")))
        {
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Присвоим null объектам, чтобы к ним нельзя было обратиться из кучи
        one = null;
        two = null;
        three = null;

        try (ObjectInputStream is = new ObjectInputStream(
            new FileInputStream("Game.ser")))
        {
            GameCharacter oneRestore = (GameCharacter) is.readObject();
            GameCharacter twoRestore = (GameCharacter) is.readObject();
            GameCharacter threeRestore = (GameCharacter) is.readObject();

            System.out.println("Type of the first: " + oneRestore.getType());
            System.out.println("Type of the second: " + twoRestore.getType());
            System.out.println("Type of the third: " + threeRestore.getType());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

class GameCharacter implements Serializable
{
    int power;
    String type;
    String[] weapons;

    public GameCharacter(int power, String type, String[] weapons)
    {
        this.power = power;
        this.type = type;
        this.weapons = weapons;
    }

    public int getPower()
    {
        return power;
    }

    public String getType()
    {
        return type;
    }

    public String getWeapons()
    {
        StringBuilder weaponList = new StringBuilder();
        for (int i = 0; i < weapons.length; i++) {
            weaponList.append(weapons[i]).append(" ");
        }
        return weaponList.toString();
    }

}
