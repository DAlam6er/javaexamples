package com.specialist.sedykh.box_animation;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class JFrameBox extends JFrame
{
    public static final int STEP = 5;
    private static int dx, dy;
    private MoveThread thread;

    private JPanel jMainPan;
    private JPanel jScenePan;
    private JPanel jControlPan;
    private JButton jStartBtn;
    private JButton jStopBtn;
    private JButton jCloseBtn;
    private JPanel jBox;

    public JFrameBox()
    {
        JFrameBox jFrameBox = this;
        jStartBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // Задержка в 50 мс
                thread = new MoveThread(50, jFrameBox);
                // Если на кнопку start нажать дважды,
                // кубик будет двигаться быстрее, т.к. его буду двигать уже два потока
                thread.start();
                switchButtons();
            }
        });
        jStopBtn.addActionListener(e -> {
            thread.stop();
            switchButtons();
        });
        jCloseBtn.addActionListener(e -> {
            // Освобождает все собственные ресурсы экрана,
            // используемые этим окном, его подкомпонентами и всеми его дочерними элементами.
            // То есть ресурсы для этих Компонентов будут уничтожены,
            // вся потребляемая ими память будет возвращена ОС,
            // и они будут помечены как неотображаемые.
            dispose();
        });
    }

    // сдвигаем кубик на 1 шаг анимации
    public void moveBox()
    {
        Point p = jBox.getLocation();
        if ((p.x >= (jScenePan.getWidth() - jBox.getWidth())) || (p.x <= 0)) {
            dx = -dx;
        }
        if ((p.y >= (jScenePan.getHeight() - jBox.getHeight())) || (p.y <= 0)) {
            dy = -dy;
        }
        p.move(p.x + STEP * dx, p.y + STEP * dy);
        jBox.setLocation(p);
    }

    private void switchButtons()
    {
        jStartBtn.setEnabled(!jStartBtn.isEnabled());
        jStopBtn.setEnabled(!jStopBtn.isEnabled());
        jCloseBtn.setEnabled(!jCloseBtn.isEnabled());
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$()
    {
        jMainPan = new JPanel();
        jMainPan.setLayout(new BorderLayout(0, 0));
        jControlPan = new JPanel();
        jControlPan.setLayout(new BorderLayout(0, 0));
        jMainPan.add(jControlPan, BorderLayout.SOUTH);
        jControlPan.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        jControlPan.add(panel1, BorderLayout.WEST);
        jStartBtn = new JButton();
        jStartBtn.setText("Start");
        panel1.add(jStartBtn);
        jStopBtn = new JButton();
        jStopBtn.setEnabled(false);
        jStopBtn.setText("Stop");
        panel1.add(jStopBtn);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        jControlPan.add(panel2, BorderLayout.EAST);
        jCloseBtn = new JButton();
        jCloseBtn.setText("Close");
        panel2.add(jCloseBtn);
        jScenePan = new JPanel();
        jScenePan.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        jScenePan.setPreferredSize(new Dimension(600, 600));
        jMainPan.add(jScenePan, BorderLayout.CENTER);
        jScenePan.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        jBox = new JPanel();
        jBox.setLayout(new BorderLayout(0, 0));
        jBox.setBackground(new Color(-14290916));
        jBox.setForeground(new Color(-1372374));
        jBox.setPreferredSize(new Dimension(30, 30));
        jScenePan.add(jBox);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$()
    {
        return jMainPan;
    }

    public static void main(String[] args)
    {
        new JFrameBox().buildGUI();
    }

    private void buildGUI()
    {
        setTitle("Moving cube");
        setContentPane(jMainPan);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        jScenePan.setLayout(null);
        jBox.setLocation(
            new Random().nextInt(jScenePan.getWidth() - jBox.getWidth()),
            new Random().nextInt(jScenePan.getHeight() - jBox.getHeight()));
        dx = dy = 1;
        setVisible(true);
    }
}
