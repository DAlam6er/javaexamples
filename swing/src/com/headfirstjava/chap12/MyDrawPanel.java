package com.headfirstjava.chap12;

import javax.swing.*;
import java.awt.*;

public class MyDrawPanel extends JPanel
{
    // Метод paintComponent ВСЕГДА вызывается системой, а не пользователем!
    // объект Graphics - холст для рисования, наложенный на настоящий экран
    // фактически является экземпляром класса Graphics2D
    // этот объект тоже ВСЕГДА создаёт система

    // Вариант 1: Рисуем оранжевый прямоугольник
    /*
    @Override
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.orange);
        g.fillRect(20,50,100,100);
    }
    */

    // Вариант 2: Изображаем JPEG
    /*
    @Override
    public void paintComponent(Graphics g)
    {
        // Указываем имя файла
        Image image = new ImageIcon("catzilla.jpg").getImage();
        // Указываем координаты верхнего левого угла картинки,
        // Эти числа относятся к виджету (наследнику JPanel - MyDrawPanel),
        // а не ко всему фрейму
        g.drawImage(image, 3, 4, this);
    }
    */

    // Вариант 3: Рисуем на черном фоне круг произвольного цвета
    /*
    @Override
    public void paintComponent(Graphics g)
    {
        // закрасим всю панель черным (цвет по умолчанию)
        g.fillRect(0,0, this.getWidth(), this.getHeight());

        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);

        Color randomColor = new Color(red, green, blue);
        g.setColor(randomColor);
        g.fillOval(70,70,100,100);
    }
    */

    // Вариант 4: Рисуем круг с плавным градиентом
    /*
    @Override
    public void paintComponent(Graphics g)
    {
        // Указываем его, чтобы иметь возможность вызвать нечто такое,
        // что есть у Graphics2D, но отсутствует у Graphics
        Graphics2D g2d = (Graphics2D) g;

        // Начальная точка, начальный цвет, конечная точка, конечный цвет
        GradientPaint gradient = new GradientPaint(
            70, 70, Color.blue, 150, 150, Color.orange);

        // Назначаем виртуальной кисти градиент вместо сплошного цвета
        g2d.setPaint(gradient);
        // Закрашиваем овал тем, что на кисти - градиентом
        g2d.fillOval(70, 70, 100, 100);
    }
    */

    // Вариант 5: Рисуем круг с плавным градиентом произвольных цветов
    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;

        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
        Color startColor = new Color(red, green, blue);

        red = (int) (Math.random() * 255);
        green = (int) (Math.random() * 255);
        blue = (int) (Math.random() * 255);
        Color endColor = new Color(red, green, blue);


        GradientPaint gradient = new GradientPaint(
            70, 70, startColor, 150, 150, endColor);

        g2d.setPaint(gradient);
        g2d.fillOval(70, 70, 100, 100);
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(drawPanel);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
