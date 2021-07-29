package com.mycompany.a2;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public abstract class GameObject
{
	//all GameObjects have a size, location, and color
    private int size = 0;
    private Point location;
    private int color;
    
    public GameObject(float x, float y)
    {
    	this.location = new Point();
    	this.location.setX(x);
    	this.location.setY(y);
    }
    //getters and setters
    //@return size
    public int getSize() 	{return this.size;} 

    //@return x
    public float getX() 	{return this.location.getX();}
    //@return y
    public float getY() 	{return this.location.getY();}

    //@param x, y
    public void setLocation(float newX, float newY)
    {
        this.location.setX(newX);
        this.location.setY(newY);
    }
    
    //@return color
    public int getColor() 			   {return this.color;}
    //@param newColor
    public void setColor(int newColor) {this.color = newColor;}
    

    //toString method used for all game objects
    //only location and color (not size) can be changed
    public String toString()
    {
        String s = " location= " + Math.round(getX()*10.0)/10.0 +","+Math.round(getY()*10.0)/10.0
                + " color=[" + ColorUtil.red(color) + "," + ColorUtil.green(color) + "," + ColorUtil.blue(color) + "]"  +
                " size="  + this.getSize();
        return s;
    }

}