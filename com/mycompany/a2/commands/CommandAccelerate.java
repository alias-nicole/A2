package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class CommandAccelerate extends Command
{
	private GameWorld gw;
	
	public CommandAccelerate(GameWorld gw)
	{
		super("Accelerate");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		gw.accelerate();
	}

}
