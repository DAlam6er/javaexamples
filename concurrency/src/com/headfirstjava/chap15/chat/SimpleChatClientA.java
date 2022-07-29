package com.headfirstjava.chap15.chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleChatClientA
{
    JTextField outgoing;
    PrintWriter writer;
    //SocketDemo sock;

    // Создаем GUI и подключаем слушатель для событий к кнопке отправки
    // Вызываем метод setUpNetworking()
    public void go()
    {
        JFrame frame = new JFrame("Ludicrously Simple Chat Client");
        JPanel mainPanel = new JPanel();
        outgoing = new JTextField(20);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendButtonListener());
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);

        setUpNetworking();
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Создаем сокет и PrintWriter, присваиваем его переменной writer
    public void setUpNetworking()
    {
        try {
            Socket sock = new Socket("127.0.0.1", 5000);
            writer = new PrintWriter(sock.getOutputStream());
            System.out.println("networking established");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public class SendButtonListener implements ActionListener
    {
        // Получаем текст из текстового поля и отправляем его
        // на сервер с помощью переменной writer
        @Override
        public void actionPerformed(ActionEvent e)
        {
            writer.println(outgoing.getText());
            writer.flush();

            outgoing.setText("");
            outgoing.requestFocus();
        }
    }

    public static void main(String[] args)
    {
        new SimpleChatClientA().go();
    }
}
