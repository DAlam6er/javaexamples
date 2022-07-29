package com.headfirstjava.chap12;

import javax.swing.*;
import java.awt.*;

public class SimpleAnimation
{
    int x = 70;
    int y = 70;

    public static void main(String[] args)
    {
        SimpleAnimation gui = new SimpleAnimation();
        gui.go();
    }

    public void go()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(drawPanel);
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        for (int i = 0; i < 130; i++) {
            x++;
            y++;
            drawPanel.repaint();
            try {
                Thread.sleep(50);
            } catch(Exception ignored) {}
        }
    }

    class MyDrawPanel extends JPanel
    {
        @Override
        public void paintComponent(Graphics g)
        {
            // закрасим всю панель фоновым цветом
            g.setColor(Color.white);
            // методы getWidth() и getHeight() унаследованы от JPanel
            // this - ссылка на drawPanel
            g.fillRect(0, 0, this.getWidth(), this.getHeight());

            g.setColor(Color.green);
            g.fillOval(x, y, 40, 40);
        }
    }
}
