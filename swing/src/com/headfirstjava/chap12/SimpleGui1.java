package com.headfirstjava.chap12;

import javax.swing.*;

public class SimpleGui1
{
    public static void main(String[] args)
    {
        // Создаем окно
        JFrame frame = new JFrame();
        JButton button = new JButton("click me");

        // завершение работы программы при закрытии окна
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Добавляем кнопку на панель содержимого, принадлежащую JFrame
        frame.getContentPane().add(button);
        frame.setSize(300, 300);
        // Делаем фрейм видимым
        frame.setVisible(true);
    }
}
