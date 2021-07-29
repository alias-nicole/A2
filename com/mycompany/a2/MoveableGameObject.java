package com.mycompany.a2;

import java.util.Random;

import com.mycompany.a2.GameObject;

public abstract class MoveableGameObject extends GameObject
{
    private int speed;
    private int direction;
    private Random rand;
    
    public static final int MAX_SPEED = 10;
    public static final int DEGREE_LIMIT = 359;

    public MoveableGameObject(float x, float y)
    {
        super(x,y);
        this.rand = new Random();
        this.speed = rand.nextInt(MAX_SPEED);
        this.direction = rand.nextInt(DEGREE_LIMIT);
    }
    
    //move method, inherited by all MoveableGameObjects
    public void move()
    {
        //need to convert polar to Cartesian
        //Speed = radius (1 unit/tick)
        float r = this.getSpeed();
        //North = 0 degrees
        double theta = Math.toRadians(90-this.getDirection());

        float cx = (float) (r * Math.cos(theta));
        float cy = (float) (r * Math.sin(theta));


        float newX = this.getX() + cx;
        float newY = this.getY() + cy;

        this.setLocation(newX, newY);

    }

    //getters and setters
    //@return speed
    public int getSpeed()
    {
        return this.speed;
    }
    //@param newSpeed
    public void setSpeed(int newSpeed)
    {
        this.speed = newSpeed;
    }
    //@return direction
    public int getDirection()
    {
        return this.direction;
    }
    //@param newDirection
    public void setDirection(int newDirection)
    {
        this.direction = newDirection;
    }

    public String toString()
    {
        String s = super.toString();
        String ss = " direction= " + direction + " speed = " + speed;
        return s + ss;
    }
}