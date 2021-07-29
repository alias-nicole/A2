package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class CommandFlagCollision extends Command
{
	private GameWorld gw;
	
	public CommandFlagCollision(GameWorld gw)
	{
		super("Collision with Flag");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Command enterCommand = new Command("Confirm");
		TextField tf = new TextField();
		Command c = Dialog.show("Enter a flag number between 1-9", tf, enterCommand);
		
		int seq = 1;
		if (c==enterCommand)
		{
			try {
				//read user input from text box to make sure its an int
				seq = Integer.parseInt(tf.getText());
			} catch (Exception e1) {
				Dialog.show("Error", "Enter a number between 1 and 9","OK",null);
				return;
			}
		}
		
		//check if number entered is between 1 and 9
		if (seq > 9 || seq < 1)
		{
			Dialog.show("Error",  "Enter a number between 1 and 9",  "OK", null);
			return;
		}
		
		//pass the flag number into game world's flag collision method
		gw.flagCollision(seq);
	}
}
