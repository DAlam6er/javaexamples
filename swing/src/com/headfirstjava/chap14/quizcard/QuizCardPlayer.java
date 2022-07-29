package com.headfirstjava.chap14.quizcard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class QuizCardPlayer
{
    private JTextArea display;
    //private JTextArea answer;
    private ArrayList<QuizCard> cardList;
    private QuizCard currentCard;
    private int currentCardIndex;
    private JFrame frame;
    private JButton nextButton;
    private boolean isShowAnswer;

    public static void main(String[] args)
    {
        QuizCardPlayer reader = new QuizCardPlayer();
        reader.go();
    }
    public void go()
    {
        // Формируем и выводим на экран GUI
        frame = new JFrame("Quiz Card Player");
        JPanel mainPanel = new JPanel();
        //mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        Font bigFont = new Font("sanserif", Font.BOLD, 24);

        display = new JTextArea(10, 20);
        display.setFont(bigFont);
        display.setLineWrap(true);
        display.setEditable(false);

        JScrollPane qScroller = new JScrollPane(display);
        qScroller.setVerticalScrollBarPolicy(
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        nextButton = new JButton("Show Question");
        mainPanel.add(qScroller);
        mainPanel.add(nextButton);
        nextButton.addActionListener(new NextCardListener());

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem loadMenuItem = new JMenuItem("Load card set");
        loadMenuItem.addActionListener(new OpenMenuListener());
        fileMenu.add(loadMenuItem);
        menuBar.add(fileMenu);

        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(640, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    class NextCardListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            // Если это вопрос - показываем ответ, иначе показываем
            // следующий вопрос. Устанавливаем флаг для того, что видим.
            if (isShowAnswer) {
                // Показываем ответ т.к. вопрос уже был увиден
                display.setText(currentCard.getAnswer());
                nextButton.setText("Next Card");
                isShowAnswer = false;
            } else {
                // Показываем следующий вопрос
                if (currentCardIndex < cardList.size()) {
                    showNextCard();
                } else {
                    // Больше карточек нет!
                    display.setText("That was the last card");
                    nextButton.setEnabled(false);
                }
            }

        }
    }

    class OpenMenuListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            // Вызываем диалоговое окно, позволяющее пользователю выбрать
            // какой набор карточек открыть.
            JFileChooser fileOpen = new JFileChooser();
            fileOpen.showOpenDialog(frame);
            loadFile(fileOpen.getSelectedFile());
        }
    }

    private void loadFile(File file)
    {
        // Нужно создать ArrayList с карточками, считывая их из текстового
        // файла, вызванного из обработчика событий класса OpenMenuListener,
        // прочитать файл по одной строке за 1 раз и вызвать метод makeCards()
        // для создания новой карточки из строки
        // одна строка в файле содержит вопрос и ответ, разделенные символом /
        cardList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
            new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                makeCard(line);
            }
        } catch (IOException ex) {
            System.out.println("couldn't read the card file");
            ex.printStackTrace();
        }
        showNextCard();
    }

    private void makeCard(String lineToParse)
    {
        // Вызывается методом loadFile, берет строку из текстового файла,
        // делит ее на 2 части - вопрос и ответ - и создает новый объект
        // QuizCard, а затем добавляет его в ArrayList с помощью CardList
        String[] result = lineToParse.split("/");
        QuizCard card = new QuizCard(result[0], result[1]);
        cardList.add(card);
        System.out.println("made a card");
    }

    private void showNextCard()
    {
        currentCard = cardList.get(currentCardIndex);
        currentCardIndex++;
        display.setText(currentCard.getQuestion());
        nextButton.setText("Show Answer");
        isShowAnswer = true;
    }
}
