package com.mycompany.a2;

import com.mycompany.a2.GameObject;

public abstract class FixedGameObject extends GameObject
{
	//this is for fixed in place GameObjects(Flag, FoodStation)
    public FixedGameObject(float x, float y)
    {
        super(x,y);
    }
    
    @Override
    public void setLocation(float x, float y) {
    	
    }
   

}
