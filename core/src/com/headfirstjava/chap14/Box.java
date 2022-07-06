package com.headfirstjava.chap14;

import java.io.*;

public class Box implements Serializable
{
    private int width;
    private int height;

    public void setWidth(int width)
    {
        this.width = width;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public static void main(String[] args)
    {
        Box myBox = new Box();
        myBox.setWidth(50);
        myBox.setHeight(20);

        try (FileOutputStream fs = new FileOutputStream("foo.ser");
             ObjectOutputStream os = new ObjectOutputStream(fs))
        {
            os.writeObject(myBox);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
