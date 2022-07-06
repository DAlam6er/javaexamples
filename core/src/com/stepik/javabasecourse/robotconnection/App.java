package com.stepik.javabasecourse.robotconnection;

import java.util.Random;

// Задача — реализовать метод который устанавливает соединение с роботом,
// отдает ему команду на перемещение в заданную точку
// и затем закрывает соединение,
// выполняя при необходимости повтор этой последовательности до трех раз.
public class App
{
    public static void main(String[] args)
    {
        RobotConnectionManager rcm = new RobotConnectionManagerImpl();
        moveRobot(rcm, 1, 1);
    }

    public static void moveRobot(
        RobotConnectionManager robotConnectionManager, int toX, int toY)
    {
        int attempt = 1;
        while (attempt < 4) {
            System.out.println("Попытка установить соединение № " + attempt);
            try (RobotConnection con = robotConnectionManager.getConnection())
            {
                con.moveRobotTo(toX, toY);
                break;
            } catch (RobotConnectionException ex) {
                System.out.println(ex.getMessage());
                if (ex.getStackTrace()[0].getMethodName().equals("close")) {
                    break;
                }
                attempt++;
                if (attempt > 3) {
                    throw new RobotConnectionException(
                        ex.getMessage(), ex.getCause());
                }
            }
        }
        System.out.println("Число попыток установления соединения: "
            + attempt);
    }
}

class RobotConnectionImpl implements RobotConnection
{
    RobotConnection connection;

    public RobotConnectionImpl()
    {
        if (new Random().nextBoolean()) {
            System.out.println("Соединение установлено");
        } else {
            throw new RobotConnectionException("Попытка соединения провалилась");
        }
    }

    @Override
    public void moveRobotTo(int x, int y)
    {
        System.out.printf(
            "Робот переместился в точку с координатами (%d, %d)\n", x, y);
    }

    @Override
    public void close()
    {
        if (new Random().nextBoolean()) {
            System.out.println("Соединение разорвано");
        } else {
            throw new RobotConnectionException("Ошибка закрытия соединения");
        }
    }
}

class RobotConnectionManagerImpl implements RobotConnectionManager
{
    @Override
    public RobotConnection getConnection()
    {
        return new RobotConnectionImpl();
    }
}
