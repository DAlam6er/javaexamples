package com.headfirstjava.chap12;

import javax.sound.midi.*;

public class MiniMusicPlayer1
{
    public static void main(String[] args)
    {
        try {
            // Создаем и открываем синтезатор
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            // Создаем последовательность и дорожку
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            // Создаем группу событий, чтобы ноты продолжали подниматься
            // (от ноты фортепиано 5 до ноты фортепиано 61)
            for (int i = 5; i < 61; i += 4) {
                // Вызываем созданный ниже метод,
                // чтобы создать сообщение и событие,
                // а затем добавляем результат MidiEvent в дорожку
                // Они представляют собой пару включения (144)
                // и отключения ноты (128)
                track.add(makeEvent(144, 1, i, 100, i));
                track.add(makeEvent(128, 1, i, 100, i + 2));
            }
            // Запускаем последовательность
            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 4 параметра для сообщения,
    // Событие tick происходит в момент появления данного сообщения
    private static MidiEvent makeEvent(
        int comd, int chan, int one, int two, int tick)
    {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception ignored) { }
        // Возвращаем событие
        // (MidiEvent полностью загружено сообщением)
        return event;
    }
}
