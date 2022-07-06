package com.headfirstjava.chap13;

import javax.swing.*;
import java.awt.*;

public class TextArea1
{
    JTextArea text;

    public static void main(String[] args)
    {
        TextArea1 gui = new TextArea1();
        gui.go();
    }

    public void go()
    {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JButton button = new JButton("Just click it");
        // реализация метода actionPerformed анонимного класса,
        // реализующего интерфейс ActionListener. e - параметр метода
        button.addActionListener(e -> text.append("button clicked\n"));
        text = new JTextArea(10, 20);
        text.setLineWrap(true);

        String[] listEntries = {"alpha", "beta", "gamma", "delta",
            "epsilon", "zeta", "eta", "theta"};
        JList<String> list = new JList<>(listEntries);

        // Объекту JScrollPane присваивают текстовую область
        JScrollPane scroller1 = new JScrollPane(text);
        scroller1.setVerticalScrollBarPolicy(
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller1.setHorizontalScrollBarPolicy(
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        // Добавляем область прокрутки на панель.
        // Текстовая область на панель непосредственно не добавляется.
        panel.add(scroller1);

        // Объекту JScrollPane присваивают список
        JScrollPane scroller2 = new JScrollPane(list);
        scroller2.setVerticalScrollBarPolicy(
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller2.setHorizontalScrollBarPolicy(
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panel.add(scroller2);
        // Устанавливаем количество строк, изображаемых до прокрутки
        list.setVisibleRowCount(4);
        // Ограничиваем выбор до одной строки
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // Регистрируем события выбора в списке,
        // используя реализацию ListSelectionListener
        list.addListSelectionListener(e ->
        {
            // Explanation: https://stackoverflow.com/a/10861043
            if (!e.getValueIsAdjusting()) {
                System.out.println(list.getSelectedValue());
            }
        });

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, button);

        frame.setSize(350, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
