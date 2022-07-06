package com.specialist.sedykh.inheritance;

class Test
{
    private int x;

    public Test(int x)
    {
        this.x = x;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    @Override
    public String toString()
    {
        return "x=" + x ;
    }
}
