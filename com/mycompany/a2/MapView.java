package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.plaf.Border;
//MapView contains code to output the map
//Implemented as an Observer of GameWorld
public class MapView extends Container implements Observer
{
	
	//model of MVC
	private GameWorld gw;
	
	MapView(Observable gwModel)
	{
		gw = (GameWorld) gwModel;
		//MapView is the observer class 
		gwModel.addObserver(this);
		//create red border around container
		this.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.rgb(255, 0, 0)));
	}
	
	
	
	public void update(Observable observable, Object data)
	{
		gw.map();
		gw.display();
	}

}
