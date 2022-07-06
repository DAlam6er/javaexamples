package com.headfirstjava.chap13;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BeatBox
{
    JPanel mainPanel;
    ArrayList<JCheckBox> checkBoxList;
    Sequencer sequencer;
    Sequence sequence;
    Track track;
    JFrame theFrame;

    // Названия инструментов
    String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat",
        "Acoustic Snare", "Crash Cymbal", "Hand Clap", "High Tom", "Hi Bongo",
        "Maracas", "Whistle", "Low Conga", "Cowbell", "Vibraslap",
        "Low-mid Tom", "High Agogo", "Open Hi Conga"};
    // Барабанные клавиши
    int[] instruments = {35, 42, 46, 38, 49, 39, 50, 60,
        70, 72, 64, 56, 58, 47, 67, 63};

    public static void main(String[] args)
    {
        new BeatBox().buildGUI();
    }

    private void buildGUI()
    {
        theFrame = new JFrame("Cyber BeatBox");
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        // Пустая граница позволяет создать поля между краями панели
        // и местом размещения компонентов
        background.setBorder(BorderFactory.createEmptyBorder(
            10,10,10,10));


        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        JButton start = new JButton("Start");
        start.addActionListener(e -> buildTrackAndStart());
        buttonBox.add(start);

        JButton stop = new JButton("Stop");
        stop.addActionListener(e -> sequencer.stop());
        buttonBox.add(stop);

        JButton upTempo = new JButton("Tempo Up");
        upTempo.addActionListener(e ->
        {
            float tempoFactor = sequencer.getTempoFactor();
            // +3% к темпу синтезатора
            sequencer.setTempoFactor(tempoFactor * 1.03f);
        });
        buttonBox.add(upTempo);

        JButton downTempo = new JButton("Tempo Down");
        downTempo.addActionListener(e ->
        {
            float tempoFactor = sequencer.getTempoFactor();
            // -3% к темпу синтезатора
            sequencer.setTempoFactor(tempoFactor * .97f);
        });
        buttonBox.add(downTempo);

        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (int i = 0; i < 16; i++) {
            nameBox.add(new Label(instrumentNames[i]));
        }

        background.add(BorderLayout.EAST, buttonBox);
        background.add(BorderLayout.WEST, nameBox);

        theFrame.getContentPane().add(background);

        GridLayout grid = new GridLayout(16, 16);
        grid.setVgap(1);
        grid.setHgap(2);
        mainPanel = new JPanel(grid);
        background.add(BorderLayout.CENTER, mainPanel);

        checkBoxList = new ArrayList<>();
        for (int i = 0; i < 256; i++) {
            JCheckBox c = new JCheckBox();
            c.setSelected(false);
            checkBoxList.add(c);
            mainPanel.add(c);
        }

        setUpMidi();

        theFrame.setBounds(50,50, 300, 300);
        theFrame.setLocationRelativeTo(null);
        theFrame.pack();
        theFrame.setVisible(true);
    }

    public void setUpMidi()
    {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        } catch (InvalidMidiDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public void makeTracks(int[] list)
    {
        for (int i = 0; i < 16; i++) {
            int key = list[i];

            if (key != 0) {
                // Создаем события включения и выключения
                // и добавляем их в дорожку
                track.add(
                    makeEvent(144, 9, key, 100, i));
                track.add(
                    makeEvent(128, 9, key, 100, i+1));
            }
        }
    }
    public MidiEvent makeEvent(
        int comd, int chan, int one, int two, int tick)
    {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
        return event;
    }

    // Преобразуем состояния флажков в MIDI-события и добавляем их на дорожку
    public void buildTrackAndStart()
    {
        // Создаем массив из 16 элементов, чтобы хранить значения для
        // каждого инструмента на все 16 тактов
        int[] trackList;

        // Избавляемся от старой дорожки и создаем новую
        sequence.deleteTrack(track);
        track = sequence.createTrack();

        // Делаем это для каждого из 16 рядов
        for (int i = 0; i < 16; i++) {
            trackList = new int[16];
            // Задаем клавишу, которая представляет собой инструмент
            // Массив содержит MIDI-числа для каждого инструмента
            int key = instruments[i];

            // Делаем это для каждого такта текущего ряда
            for (int j = 0; j < 16; j++) {
                JCheckBox jc = checkBoxList.get(j + (16 * i));
                // Установлен ли флажок на этом такте? Если да - то помещаем
                // значение клавиши в текущую ячейку массива
                // (ячейку, которая представляет такт). Если нет - то
                // инструмент не должен играть в этом такте,
                // поэтому присвоим ему 0.
                if (jc.isSelected()) {
                    trackList[j] = key;
                } else {
                    trackList[j] = 0;
                }
            }

            // Для этого инструмента и для всех 16 тактов создаем события
            // и добавляем их на дорожку
            makeTracks(trackList);
            /*
                Ловим ритм - добавляем событие ControllerEvent
                (176 - тип события - ControllerEvent)
                с аргументом для события #127. Оно ничего не будет делать.
             */
            track.add(makeEvent(176, 1, 127, 0, 16));
        }
        // Мы всегда должны быть уверены, что событие на такте 16 существует
        // (они идут от 0 до 15). Иначе BeatBox может не пройти все 16 тактов,
        // перед тем как заново начнет последовательность
        track.add(makeEvent(192, 9, 1, 0, 15));

        try {
            sequencer.setSequence(sequence);
            // Создает непрерывный цикл повторений
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
            sequencer.start();
            sequencer.setTempoInBPM(120);
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }
}
