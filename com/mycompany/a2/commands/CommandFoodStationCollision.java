package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class CommandFoodStationCollision extends Command
{
	private GameWorld gw;
	
	public CommandFoodStationCollision(GameWorld gw)
	{
		super("Collision With Food Station");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		gw.foodStationCollision();
	}
}
