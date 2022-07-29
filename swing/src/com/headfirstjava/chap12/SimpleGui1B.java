package com.headfirstjava.chap12;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Реализуем интерфейс. Кнопка будет передавать события только тем,
// кто реализует ActionListener
public class SimpleGui1B implements ActionListener
{
    JButton button;

    public static void main(String[] args)
    {
        SimpleGui1B gui = new SimpleGui1B();
        gui.go();
    }

    public void go()
    {
        JFrame frame = new JFrame();
        button = new JButton("click me");
        // Регистрируем нашу заинтересованность в кнопке.
        // Код говорит кнопке: "Добавь меня к своему списку слушателей"
        // Аргумент должен быть объектом класса, реализующего ActionListener
        // Т.о. связываем события с источником
        button.addActionListener(this);

        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    // Реализуем метод интерфейса ActionListener.
    // Это фактический метод обработки событий
    // Кнопка вызывает этот метод, чтобы известить о наступлении события.
    // Объект события - аргумент, отправляемый кнопкой - нам не нужен.
    // Достаточно знать, что событие произошло
    @Override
    public void actionPerformed(ActionEvent event)
    {
        button.setText("I've been clicked!");
        // информация об источнике события
        System.out.println(event.getSource());
    }
}
