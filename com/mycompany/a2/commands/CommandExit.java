package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class CommandExit extends Command
{
	private GameWorld gw;
	
	public CommandExit(GameWorld gw)
	{
		super("Exit");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Command y = new Command("Yes");
		Command n = new Command("No");
		
		Label l = new Label("");
		
		Command c = Dialog.show("Are you sure you want to exit?", l, y,n);
		if (c==y)
		{
			gw.exit();
		}
		else if (c==n)
		{
			return;
		}
	}

}
