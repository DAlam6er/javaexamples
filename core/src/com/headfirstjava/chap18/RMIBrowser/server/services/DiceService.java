package com.headfirstjava.chap18.RMIBrowser.server.services;

import com.headfirstjava.chap18.RMIBrowser.Service;

import javax.swing.*;

public class DiceService implements Service
{
    JLabel label;
    JComboBox<String> numOfDice;

    // Метод описан в интерфейсе Service и вызывается,
    // когда сервис выбирают из списка и загружают.
    // В методе может происходить все, что угодно, но возвращать он должен
    // виджет JPanel, который и представляет собой пользовательский
    // интерфейс для игры в кости.
    @Override
    public JPanel getGuiPanel()
    {
        JPanel panel = new JPanel();
        JButton button = new JButton("Roll 'em!");
        String[] choices = {"1", "2", "3", "4", "5"};

        numOfDice = new JComboBox<>(choices);
        label = new JLabel("dice values here");
        button.addActionListener(e ->
        {
            // Бросаем кости
            StringBuilder diceOutput = new StringBuilder();
            String selection = (String) numOfDice.getSelectedItem();
            assert selection != null;
            int numOfDiceToRoll = Integer.parseInt(selection);
            for (int i = 0; i < numOfDiceToRoll; i++) {
                int r = (int) (Math.random() * 6 + 1);
                diceOutput.append(" ").append(r);
            }
            label.setText(diceOutput.toString());
        });

        panel.add(numOfDice);
        panel.add(button);
        panel.add(label);
        return panel;
    }
}
