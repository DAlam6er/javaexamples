package com.headfirstjava.chap15.dailyadvice;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyAdviceServer
{
    String[] adviceList = {
        "Ешьте меньшими порциями",
        "Купите облегающие джинсы. Нет, они не делают вас полнее.",
        "Два слова: не годится",
        "Будьте честнее хотя бы сегодня. Скажите своему начальнику все, " +
            "что вы *на самом деле* о нем думаете.",
        "Возможно, вам стоит подобрать другую причёску"
    };

    public void go()
    {
        System.out.println("Старт сервера...");
        // Приложение отслеживает клиентские запросы на порту 4242
        // на том же компьютере, где выполняется данный код
        try (ServerSocket serverSocket = new ServerSocket(4242))
        {
            // сервер входит в постоянный цикл,
            // ожидая клиентских подключений и обслуживая их
            while (true) {
                // Метод accept() блокирует приложение до тех пор,
                // пока не поступит запрос
                Socket clientSocket = serverSocket.accept();
                System.out.println("Получен запрос от клиента на порту 4242");

                PrintWriter writer = new PrintWriter(
                    clientSocket.getOutputStream());
                System.out.println("This socket port is: " +
                    clientSocket.getLocalPort());
                String advice = getAdvice();
                writer.println(advice);
                // Закрываем сокет - работа с клиентом закончена.
                writer.close();
                System.out.println(advice);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private String getAdvice()
    {
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }

    public static void main(String[] args)
    {
        DailyAdviceServer server = new DailyAdviceServer();
        server.go();
    }
}
