package com.headfirstjava.chap11;


import javax.sound.midi.*;

public class MiniMiniMusicApp
{
    public static void main(String[] args)
    {
        MiniMiniMusicApp mini = new MiniMiniMusicApp();
        mini.play();
    }

    private void play()
    {
        try {
            // Получаем синтезатор и открываем его
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);

            // Запрашиваем трек у последовательности
            Track track = seq.createTrack();

            // Помещаем в трек MIDI-события
            // В a хранится MIDI-инструкция (что делать)
            ShortMessage a = new ShortMessage();

            // Тип сообщения - 144 - начать проигрывать
            // Следующие сообщения зависят от первого аргумента
            // Канал - 1 - фортепиано
            // Нота для проигрывания - 44
            // Скорость и сила нажатия клавиши - 100
            a.setMessage(144, 1, 44, 100);
            // В какой момент нота начинает играть (когда делать)
            // сообщение a сработает на первом такте
            MidiEvent noteOn = new MidiEvent(a, 1);
            // В один момент времени возможны несколько событий
            track.add(noteOn);

            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, 44, 100);
            // В какой момент нота заканчивает играть
            MidiEvent noteOff = new MidiEvent(b, 16);
            track.add(noteOff);

            // Передаем последовательность синтезатору
            // как будто вставляем CD в проигрыватель
            player.setSequence(seq);
            // Запускаем синтезатор (как будто нажимаем Play (играть)
            player.start();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
