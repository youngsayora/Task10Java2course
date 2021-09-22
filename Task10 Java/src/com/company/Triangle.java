package com.company;

public class Triangle {
    Dot[] a =new Dot[3];
    public void setDot(int x,int y,int dot)
    {
        a[dot]=new Dot();
        a[dot].setCord(x,y);
    }
    public int getX(int ind)
    {
        return a[ind].getX();
    }
    public int getY(int ind)
    {
        return a[ind].getY();
    }
}
