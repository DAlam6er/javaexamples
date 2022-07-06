package com.headfirstjava.chap18.RMIBrowser.server.services;

import com.headfirstjava.chap18.RMIBrowser.Service;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiniMusicService implements Service
{
    MyDrawPanel myPanel;

    @Override
    public JPanel getGuiPanel()
    {
        JPanel mainPanel = new JPanel();
        myPanel = new MyDrawPanel();
        JButton playItButton = new JButton("Play it");
        playItButton.addActionListener(new PlayItListener());
        mainPanel.add(myPanel);
        mainPanel.add(playItButton);
        mainPanel.add(myPanel);
        mainPanel.add(playItButton);
        return mainPanel;
    }

    public class PlayItListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            try {
                Sequencer sequencer = MidiSystem.getSequencer();
                sequencer.open();

                sequencer.addControllerEventListener(
                    myPanel, new int[] {127});
                Sequence seq = new Sequence(Sequence.PPQ, 4);
                Track track = seq.createTrack();

                for (int i = 0; i < 100; i += 4) {
                    int rNum = (int) (Math.random() * 50) + 1;
                    if (rNum < 38) {
                        // 75% времени
                        track.add(
                            makeEvent(144, 1, rNum, 100, i));
                        track.add(
                            makeEvent(176, 1, 127, 0, i));
                        track.add(
                            makeEvent(128, 1, rNum, 100, i + 2));
                    }
                }

                sequencer.setSequence(seq);
                sequencer.setTempoInBPM(220);
                sequencer.start();
            } catch (MidiUnavailableException |
                     InvalidMidiDataException ex) {
                ex.printStackTrace();
            }
        }
    }

    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick)
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
}

class MyDrawPanel extends JPanel implements ControllerEventListener
{
    boolean msg = false;

    @Override
    public void controlChange(ShortMessage event)
    {
        msg = true;
        repaint();
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(300, 300);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        if (msg) {
            int red = (int) (Math.random() * 250);
            int green = (int) (Math.random() * 250);
            int blue = (int) (Math.random() * 250);

            g.setColor(new Color(red, green, blue));

            int height = (int) (Math.random() * 120) + 10;
            int width = (int) (Math.random() * 120) + 10;

            int x = (int) (Math.random() * 40) + 10;
            int y = (int) (Math.random() * 40) + 10;

            g.fillRect(x, y, width, height);
            msg = false;
        }
    }
}
