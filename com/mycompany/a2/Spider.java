package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;

import java.util.Random;

public class Spider extends MoveableGameObject implements IMoveable
{
    Random rand = new Random();
    private static final int MAX_DEGREES = 360;
    
    //constructor for spider class, sets location, size, speed, direction, and color
    public Spider(float x, float y, int speed, int size, int direction)
    {
        super(x,y);
        this.setSize(this.rand.nextInt(31)+6);
        //this.speed = speed;
        this.setColor(ColorUtil.BLACK);

    }
    
    //spider has a random heading at time of instantiation
    public void randomDirection()
    {
        this.setDirection(rand.nextInt(MAX_DEGREES-1));
    }

    public void setNewDirection()
    {
    	this.setDirection(rand.nextInt(5+5)-5);
    }

    public void reverseDirection()
    {
    	this.setDirection(this.getDirection() - 180);
    }
    public void setSize(int size) {}
    @Override
    public void setColor(int color) {}

    public String toString()
    {
        return "Spider:" + super.toString();
    }


}