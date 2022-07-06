package com.headfirstjava.chap12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TwoButtons
{
    JFrame frame;
    JLabel label;

    public static void main(String[] args)
    {
        TwoButtons gui = new TwoButtons();
        gui.go();
    }

    private void go()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton labelButton = new JButton("Change Label");
        // Передаем методу регистрации слушателя в качестве аргумента
        // экземпляр соответствующего класса слушателя
        // реализован в классе LabelListener
        //labelButton.addActionListener(new LabelListener());
        labelButton.addActionListener(this.new LabelListener());

        JButton colorButton = new JButton("Change Circle");
        // colorButton.addActionListener(new ColorListener());
        // экземпляр класса слушателя реализован в виде лямбда-выражения
        // frame.repaint() - метод обработки событий анонимного класса,
        // реализующего интерфейс ActionListener
        colorButton.addActionListener(e -> frame.repaint());

        label = new JLabel("I'm a label");
        JComponent drawPanel = new JComponent()
        {
            @Override
            protected void paintComponent(Graphics g)
            {
                g.fillRect(0,0,this.getWidth(), this.getHeight());
                int red = (int) (Math.random() * 255);
                int green = (int) (Math.random() * 255);
                int blue = (int) (Math.random() * 255);

                Color randomColor = new Color(red, green, blue);
                g.setColor(randomColor);
                g.fillOval(70,70, 100,100);
            }
        };

        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);

        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // внутренний класс, использует переменную label внешнего класса
    class LabelListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            label.setText("Ouch!");
        }
    }

    // внутренний класс, использует переменную frame внешнего класса
    /*
    class ColorListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            frame.repaint();
        }
    }
    */
}
