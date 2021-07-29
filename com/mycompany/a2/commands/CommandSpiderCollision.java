package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class CommandSpiderCollision extends Command
{
	private GameWorld gw;
	
	public CommandSpiderCollision(GameWorld gw)
	{
		super("Collision with Spider");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		gw.spiderCollision();
	}
}
