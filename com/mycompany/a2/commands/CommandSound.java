package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class CommandSound extends Command
{
	private GameWorld gw;
	
	public CommandSound(GameWorld gw)
	{
		super("Sound");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		gw.toggleSound();
	}

}
