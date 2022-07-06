package com.headfirstjava.chap12;

import javax.sound.midi.*;

// Реализуем интерфейс слушателя, для отслеживания события ControllerEvent
public class MiniMusicPlayer2 implements ControllerEventListener
{
    // Метод обработки события (из интерфейса слушателя события ControllerEvent)
    // При каждом получении события, мы пишем в командной строке слово "ля"
    @Override
    public void controlChange(ShortMessage event)
    {
        System.out.println("ля");
    }

    private MidiEvent makeEvent(
        int comd, int chan, int one, int two, int tick)
    {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception ignored) {}
        return event;
    }

    public static void main(String[] args)
    {
        MiniMusicPlayer2 mini = new MiniMusicPlayer2();
        mini.go();
    }

    private void go()
    {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            // Регистрируем события синтезатором.
            // Метод, отвечающий за регистрацию, принимает объект слушателя
            // и целочисленный массив, представляющий собой список событий
            // ControllerEvent, которые нам нужны.
            // Нас интересует только одно событие - #127
            int[] eventsIWant = {127};
            sequencer.addControllerEventListener(this, eventsIWant);

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            for (int i = 5; i < 60; i+=4) {
                track.add(makeEvent(144, 1, i, 100, i));
                /*
                Ловим ритм - добавляем событие ControllerEvent
                (176 - тип события - ControllerEvent)
                с аргументом для события #127. Оно ничего не будет делать.
                Вставляем для возможности реагировать на воспроизведение
                каждой ноты. Его единственная цель - запуск чего-нибудь,
                что можно отслеживать (события 144, 128 - не отслеживаемые).
                Запускаем это событие в тот же момент, когда включается
                воспроизведение ноты.
                Поэтому, когда произойдет событие включения
                вопроизведения ноты, мы сразу узнаем об этом, т.к.
                наше событие запустится в то же самое время.
                */
                track.add(makeEvent(176, 1, 127, 0, i));
                track.add(makeEvent(128, 1, i, 100, i+2));
            }

            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
