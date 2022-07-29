package com.specialist.sedykh.box_animation;

// Класс для анимации кубика
public class MoveThread implements Runnable
{
    private final Thread self;
    private int delay;
    private final JFrameBox frame;

    public MoveThread(int delay, JFrameBox frame)
    {
        this.delay = delay;
        this.frame = frame;
        self = new Thread(this, "BoxMoveThread");
    }

    public int getDelay()
    {
        return delay;
    }

    public void setDelay(int delay)
    {
        this.delay = delay;
    }

    public void start()
    {
        self.start();
    }

    public void stop()
    {
        self.interrupt();
    }

    @Override
    public void run()
    {
        try {
            while (true) {
                frame.moveBox();
                Thread.sleep(delay);
            }
        } catch (InterruptedException ignored) {}
    }
}
