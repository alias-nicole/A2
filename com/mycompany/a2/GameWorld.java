package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Form;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

//GameWorld is implemented as an Observable
public class GameWorld extends Observable 
{
	private int mapHeight;
	private int mapWidth;
    private int clock;
    private int lives;
    private boolean soundCheck;
    private boolean spiderCollide = false;
    private boolean foodStationCollide = false;
    private boolean flagCollide = false;
    private Random rand;
    private Ant ant;
    private Spider spiders;
    private int lastFlag;
    private GameObjectCollection gameObjCollection;
    
    private ArrayList<GameObject> colliderList = new ArrayList<GameObject>();
    
    public static final int MAX_LIVES = 3;


    public GameWorld()
    {
    	gameObjCollection = new GameObjectCollection();
    	this.clock = 0;
    	this.soundCheck = true;
    	this.lives = MAX_LIVES;
    	this.rand = new Random();
    	
    }

    public void init()
    {
        //code here to create the initial game objects/setup
        addAnt();
        addFlags();
        for (int i = 0; i < 3; i++ )
        {
	        addFoodStations();
	        addSpiders();
        }
        this.setChanged();
        this.notifyObservers();
        

    }
    
    public void reinit()
    {
    	gameObjCollection = new GameObjectCollection();
    	this.clock = 0;
    	this.soundCheck = true;
    	this.lives = MAX_LIVES;
    	this.rand = new Random();
    	
    	 addAnt();
         addFlags();
         for (int i = 0; i < 3; i++ )
         {
 	        addFoodStations();
 	        addSpiders();
         }
         this.setChanged();
         this.notifyObservers();
    }
    
    
    //getters and setters
    public void setMapHeight(int h)
    {
    	this.mapHeight = h;
    	System.out.println("" + h);
    	this.setChanged();
    	this.notifyObservers();
    }
    
    public void setMapWidth(int w)
    {
    	this.mapWidth = w;
    	System.out.println("" + w);
    	this.setChanged();
    	this.notifyObservers();
    }
    public int getMapHeight()
    {
    	return this.mapHeight;
    }
    public int getMapWidth()
    {
    	return this.mapWidth;
    }
    //additional methods here to manipulate
    //world objects and related game state data

    public float randomX()
    {
    	//random x-coordinate between 0 and 1024
    	int randX = rand.nextInt((1024-1) + 1) + 0;
    	return randX;
    }
    
    public float randomY()
    {
    	//random y-coordinate between 0 and 768
    	int randY = rand.nextInt((768-1)+1)+0;
    	return randY;
    }
    public int randSize()
    {
        //size is between 10 and 50
        int randNum = rand.nextInt((50-10)+1) +10;
        return randNum;
    }
    int randSpeed()
    {
    	//random speed between 5 and 10
        int randNum = rand.nextInt((10-5) + 1) +5;
        return randNum;
    }
    public int randDirection()
    {
    	//random degree between 0 and 359
        int randomNum =  rand.nextInt((359-0)+1)+0;
        return randomNum;
    }

    //methods to add GameObjects to the worldObjects array
    public void addAnt()
    {
    	//if ant doesn't already exist in GameWorld
        if(this.ant == null)
        {
        	//accessor for ant class instantiates it via private constructor
        	this.ant = Ant.getAnt(0,0);
        	this.gameObjCollection.add(this.ant);
        	System.out.println("Ant added to Game World");
        	this.setChanged();
        	this.notifyObservers(this);
        }
        else {
        	System.out.println("Cannot add another Ant to Game World");
        }
    }
    public void addSpiders()
    {
    	gameObjCollection.add(new Spider(randomX(),randomY(), randSpeed(), 20, randDirection()));
    	this.setChanged();
    	this.notifyObservers();
    }
    public void addFoodStations()
    {
    	gameObjCollection.add(new FoodStation(randomX(),randomY(), rand.nextInt(25)+5));
    	this.setChanged();
    	this.notifyObservers();
    }
    public void addFlags()
    {
    	gameObjCollection.add(new Flag(0,0,1));
    	gameObjCollection.add(new Flag(150,200,2));
    	gameObjCollection.add(new Flag(230,500,3));
    	gameObjCollection.add(new Flag(700,600,4));
    	this.setChanged();
    	this.notifyObservers();

    }
    
    //other getters and setters
    public int getLivesLeft()
    {
    	return lives;
    }
    public int getClock()
    {
    	return clock;
    }
    public int getLastFlagReached()
    {
    	if (ant!=null)
    	{
    		return ant.getLastFlagReached();
    	}
    	return 0;
    }
    public int getFoodLevel()
    {
    	if(ant!=null)
    	{
    	return ant.getFoodLevel();
    	}
    	return 0;
    }
    public int getHealthLevel()
    {
    	if(ant!=null)
    	{
    	return ant.getHealthLevel();
    	}
    	return 0;
    }
    public void accelerate()
    {
    	if(this.ant != null && this.ant.getSpeed() < 10)
    	{
	        int speedIncrease = 2;
	        this.ant.setSpeed(this.ant.getSpeed() + speedIncrease);

	        System.out.println("Ant's speed has been increased by " + speedIncrease + "!");
    	}
    	else
    	{
    		System.out.println("Cannot accelerate - ant does not exist");
    	}
        this.setChanged();
        //call update() for every observer in list
        this.notifyObservers();
    }

    public void brake()
    {
    	if(this.ant != null && this.ant.getSpeed() > 0)
    	{
	        int speedDecrease = 2;
	        ant.setSpeed(ant.getSpeed() - speedDecrease);
	        this.setChanged();
	        this.notifyObservers();
	        System.out.println("Ant's speed has been decreased by " + speedDecrease +"!");
    	}
    }
    public void left()
    {
    	if(this.ant != null)
    	{
	        int leftShift = -5;
	        ant.changeDirection(leftShift);
	        this.setChanged();
	        this.notifyObservers();
	        System.out.println("Ant has shifted left by " + leftShift + " degrees");
    	}
    }
    public void right()
    {
    	if(this.ant != null)
    	{
	        int rightShift = 5;
	        ant.changeDirection(rightShift);
	        this.setChanged();
	        this.notifyObservers();
	        System.out.println("Ant has shifted right by " + rightShift + " degrees");
    	}
    }
    
    public String isSound()
    {
    	if (this.soundCheck)
    	{
    		return "OFF";    	
    	} else {
    		return "ON";
    	}
    }
    
    public void toggleSound()
    {
    	this.soundCheck = !(this.soundCheck);
    	this.setChanged();
    	this.notifyObservers();
    }
    //every clock tick...
    public void clockTick()
    {
        clock++;
        
        //iterate through the game objects in collection
        IIterator gameElements = gameObjCollection.getIterator();
        while (gameElements.hasNext())
        {

        	GameObject o = (GameObject) gameElements.getNext();
        	if ( o instanceof Spider)
        	{
        		//if the spider is within world boundaries,
            	//it shifts direction between -5 and 5 degrees
            	if (  o.getX()  < getMapHeight() &&  o.getY() < getMapWidth() )
            	{
            		((Spider) o).setNewDirection();
            	}
            	//otherwise, it reverses direction
        		((Spider) o).reverseDirection();
        	}
        	if (o instanceof MoveableGameObject)
        	{
        		((MoveableGameObject)o).move();
        	}
        	/*if (o instanceof FoodStation)
        	{
        		if (((FoodStation) o).getCapacity() == 0)
        		{
        			gameObjCollection.remove(o);
        		}
        	}*/
        }
        
        //ant's food level is reduced by its food consumption rate
        /*ant.reduceFoodLevel();
        ant.checkHealthLevel();
        //if ant health level is 0, 1 (out of 3) life is lost
        if (ant.getHealthLevel() == 0 || ant.getFoodLevel() <= 0 )
        {
        	lives -=1;
        	if (lives == 0)
        	{
        		 System.out.println("You are out of lives, game over!");
        		 System.exit(0);
        	}
             
        }
        if(ant.getLastFlagReached() == lastFlag)
        {
                System.out.println("Congratulations, you have found all of the flags! Total time: " + this.t);
        }*/
        if(this.ant != null)
        {
	        ant.reduceFoodLevel();
	        if(ant.getLastFlagReached() == lastFlag)
	        {
	        	System.out.println("Game Over, you have won! Total time: " + clock);      	
	        }
	        ant.checkHealthLevel();
	        if (ant.getIsDead() && ant.getSpeed() != 0)
	        {
	        	lives -= 1;
	        	if (lives == 0 )
	        	{
	        		System.out.println("You are out of lives, game over!");
	        		//restart the game
	        		ant.reset();
	        		this.reinit();
	        	}
	        }
        }
        
        this.setChanged();
        this.notifyObservers();
        System.out.println("Time has increased by 1 tick");

    }
    
    public void flagCollision(int x)
    {
    	if(ant!=null)
    	{
	        System.out.println("Colliding with flag " + x);
	        if ((x-ant.getLastFlagReached() == 1))
	        {
	            ant.setLastFlagReached(x);
	            System.out.println("Collision with Flag #" + x + " has occurred");
	        } 
	        if(x==9)
	        {
	        	System.out.println("Game over, you win! Total time: " + clock);
	        	ant.reset();
	        	this.reinit();
	        }
    	}
    	 this.setChanged();
	     this.notifyObservers();
    }
    public void foodStationCollision()
    {
    	if(ant!=null)
    	{
    		if(ant.getIsDead())
        	{
        		System.out.println("Game over, you are out of lives!");
        		ant.reset();
        		this.reinit();
        	}
    		//FoodStation food = null;
	    	//GameObject foodStation = new GameObject();
	        IIterator elements = gameObjCollection.getIterator();
	        FoodStation food = null;
	        while (elements.hasNext())
	        {
	        	GameObject f = (GameObject) elements.getNext();
	        	if ( f instanceof FoodStation)
	        	{
	        		if (((FoodStation) f).getCapacity() != 0)
	        		{
	        			food = (FoodStation)f;

	        		}
	        	}
	        }
	        
	        //set the ant's food level to its current plus amt from foodstation
	        ant.setFoodLevel(ant.getFoodLevel() + ((FoodStation) food).getCapacity());
	        ((FoodStation) food).setCapacity(0);
	        ((FoodStation) food).setColor(ColorUtil.rgb(0, 120, 0));
	        //add a new randomly placed FoodStation to GameWorld
	        gameObjCollection.add(new FoodStation(randomX(), randomY(), rand.nextInt(25)+5));
	        this.setChanged();
	        this.notifyObservers();
	        System.out.println("Ant has collided with a Food Station");
   
    	}

    }
    public void spiderCollision()
    {

    	if (this.ant != null)
    	{
        	if(ant.getIsDead())
        	{
        		System.out.println("Game over, you are out of lives!");
        		ant.reset();
        		this.reinit();
        	}
	        ant.collisionWithSpider();
	        System.out.println("Ant and spider have collided.");
    	}
    	this.setChanged();
    	this.notifyObservers();
    }
    public void display()
    {
    	if(this.ant != null)
    	{
	        System.out.println("\nNumber of lives left is: " + lives );
	        System.out.println("Current value of clock is: " + clock);
	        System.out.println("The highest flag number reached is: " + ant.getLastFlagReached());
	        System.out.println("Food level of ant is: " +  ant.getFoodLevel());
    	}

    }
    public void map()
    {
        System.out.println();
        IIterator gameElements = gameObjCollection.getIterator();
        while(gameElements.hasNext())
        {
        	GameObject g = (GameObject) gameElements.getNext();
        	System.out.println(g.toString());
        }

    }
    public void exit()
    {
    	System.exit(0);
    }

}