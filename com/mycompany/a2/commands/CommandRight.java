package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class CommandRight extends Command
{
	private GameWorld gw;
	
	public CommandRight(GameWorld gw)
	{
		super("Right");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		gw.right();
	}

}
