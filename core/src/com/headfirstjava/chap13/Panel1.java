package com.headfirstjava.chap13;

import javax.swing.*;
import java.awt.*;

public class Panel1
{
    public static void main(String[] args)
    {
        Panel1 gui = new Panel1();
        gui.go();
    }

    private void go()
    {
        JFrame frame = new JFrame();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        panel1.setBackground(Color.darkGray);
        panel2.setBackground(Color.darkGray);
        // изменяем диспетчер компоновки панели с FlowLayout,
        // установленного по умолчанию, на BoxLayout
        // Конструктору диспетчера указываем размещаемый компонент и ось
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

        JButton button1 = new JButton("shock me");
        JButton button2 = new JButton("bliss");
        JButton button3 = new JButton("huh?");

        JTextField field1 = new JTextField(20);
        JTextField field2 = new JTextField("Ваше имя");
        JCheckBox check1 = new JCheckBox("Goes to 11");

        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);

        panel2.add(field1);
        panel2.add(field2);
        panel2.add(check1);

        System.out.println(field2.getText());
        field2.setText("Новый текст");

        // Выделяем текст в поле
        field2.selectAll();

        // Помещаем курсор в поле
        field2.requestFocus();

        // Отслеживаем нажатия клавиши ENTER
        // e - параметр ActionEvent анонимного класса,
        // реализующего ActionListener
        field2.addActionListener(e ->
            System.out.println("Была нажата клавиша Enter"));

        // Отслеживаем событие флажка (установлен он или снят)
        // e - параметр ItemEvent анонимного класса,
        // реализующего ItemListener
        check1.addItemListener(e ->
        {
            String onOrOff = "off";
            if (check1.isSelected()) onOrOff = "on";
            System.out.println("Check box is " + onOrOff);
        });
        check1.setSelected(true);
        check1.setSelected(false);

        frame.getContentPane().add(BorderLayout.EAST, panel1);
        frame.getContentPane().add(BorderLayout.WEST, panel2);
        frame.setSize(600,200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
