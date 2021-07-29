package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;

public class Ant extends MoveableGameObject implements IMoveable, ISteerable
{
    private int maximumSpeed = 10;
    private int steeringDirection = 5;
    private int foodLevel = 25;
    private int healthLevel = 10;
    private int lastFlagReached = 1;
    private int foodConsumptionRate = 2;
    private boolean isDead = false;
    private static Ant ant;
    
    //ant needs a private constructor for Singleton Design Pattern
    //constructor for Ant, sets location, size, speed, and color
    private Ant(float x, float y)
    {
        super(x,y);
        this.setLocation(x,y);
        this.setSize(40);
        this.setSpeed(0);
        this.setColor(ColorUtil.MAGENTA);

    }
    
    //provides access to the Ant
    public static Ant getAnt(float x, float y)
    {
    	if (ant == null)
    	{
    		ant = new Ant(x,y);
    	}
    	
    	return ant;
    }

    
    private void setSize(int i) {
		// TODO Auto-generated method stub
		
	}

	//change direction ant is heading in
    //@param newDirection
    public void changeDirection(int newDirection)
    {
        this.setDirection(this.getDirection() + newDirection);

    }
    
    //change ant's speed, making sure it's less than max speed
    //@param speed
    public void setAntSpeed(int speed)
    {
        /*if (speed < this.maximumSpeed)
        {
            this.speed = speed;
        }
        else
        {
            System.out.println("Ant cannot go beyond maximum speed!");
        }
        //in case player decreases speed
        if (this.getSpeed() < 0 )
        {
        	this.setSpeed(0);
        }*/
    }
    //ant speed is updated after colliding with a spider or having low food level
    public void updateAntSpeed()
    {
    	if (this.getSpeed() < this.getMaximumSpeed() * this.getHealthLevel())
    	{
    		//if ant is alread
    	}
    	else
    	{
    		this.setSpeed(this.getMaximumSpeed()*(this.getHealthLevel()/2));
    	}
    	this.checkHealthLevel();


    }
    
    public void setSpeed(int newSpeed)
    {
    	if(newSpeed>10)
    	{
    		System.out.println("Ant is at maximum speed");
    	}
    	else if(newSpeed<0)
    	{
    		System.out.println("Ant is already stopped");
    	}
    	else
    	{
    		super.setSpeed(newSpeed);
    	}
    }

    //Getters and Setters
    //@return steeringDirection
    public int getSteeringDirection() { return steeringDirection; }
    //@param newSteeringDirection
    public void setSteeringDirection(int newSteeringDirection) { this.steeringDirection = newSteeringDirection; }
    //@return maximumSpeed
    public int getMaximumSpeed() { return maximumSpeed; }
    //@param maximumSpeed
    public void setMaximumSpeed(int maxSpeed) { this.maximumSpeed = maxSpeed; }
    //@return foodLevel
    public int getFoodLevel() { return foodLevel; }
    //@param foodLevel
    public void setFoodLevel(int foodLevel) { this.foodLevel = foodLevel; }
    //@return foodConsumptionRate
    public int getFoodConsumptionRate() { return foodConsumptionRate; }
    //@param foodConsumptionRate
    public void setFoodConsumptionRate(int rate) { this.foodConsumptionRate = rate; }
    //@return healthLevel
    public int getHealthLevel() { return healthLevel; }
    //@param healthLevel
    public void setHealthLevel(int healthLevel) { this.healthLevel = healthLevel; }
    //@return lastFlagReached
    public int getLastFlagReached() { return lastFlagReached; }
    //@param lastFlagReached	
    public void setLastFlagReached(int lastFlag) { this.lastFlagReached = lastFlag; }
    //@return isDead
    public boolean getIsDead() { return isDead; }
    //@param isDead
    public void setIsDead(boolean isDead) { this.isDead = isDead; }
    
    //method to alter ant's speed based on damage level or food level
    public void checkHealthLevel()
    {
    	if (this.getHealthLevel() <= 0)
    	{
    		this.setSpeed(0);
    	}
    	if (this.getFoodLevel() == 0)
    	{
    		this.setSpeed(0);
    	}
    	if (this.getSpeed() == 0)
    	{
    		this.isDead = true;
    	}
    }

    //health and speed of ant are reduced after collision
    public void collisionWithSpider()
    {
    	if (this.healthLevel > 0)
    	{
	        this.healthLevel = healthLevel - 1;
	        //ant's color changes (changes lighter red) when damaged by spider
	        this.setColor(ColorUtil.rgb(255 - (20 *(10 - this.getHealthLevel())) , 0, 0));	
	        this.updateAntSpeed();
    	}
    	else
    	{
    		this.isDead = true;
    	}
    }

    //method to reduce ant's food level by foodConsumptionRate
    public void reduceFoodLevel()
    {
    	if(foodLevel >= 0)
    	{
        	foodLevel = foodLevel - foodConsumptionRate;
    	}
    	else
    	{
    		this.isDead = true;
    	}
    }

    //after the ant's health level reaches 0, ant is reset
    public void reset()
    {
        this.setColor(ColorUtil.MAGENTA);
        this.setDirection(0);
        this.setSpeed(1);
        this.setLastFlagReached(1);
        this.setLocation(0,0);
        this.setFoodLevel(25);
        this.setHealthLevel(10);
        this.setIsDead(false);

    }

    public String toString()
    {
        String objDesc = super.toString();
        String localDesc = " maxSpeed=" + maximumSpeed + " steeringDirection=" + getSteeringDirection() +
                " foodLevel=" + foodLevel  + " healthLevel=" + healthLevel;
        return "Ant:" + objDesc + localDesc;
    }

}