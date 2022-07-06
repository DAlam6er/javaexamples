package com.headfirstjava.chap11;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

public class MusicTest1
{
    public void play()
    {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            System.out.println("Успешно получили синтезатор");
        } catch (MidiUnavailableException exception) {
            System.out.println("Неудача");
        }
    }

    public static void main(String[] args)
    {
        MusicTest1 mt = new MusicTest1();
        mt.play();
    }
}
