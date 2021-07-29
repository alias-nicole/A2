package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class CommandClockTick extends Command
{
	private GameWorld gw;
	
	public CommandClockTick(GameWorld gw)
	{
		super("Tick");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		gw.clockTick();
	}

}
