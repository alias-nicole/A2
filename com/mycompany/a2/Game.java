package com.mycompany.a2;

import static com.codename1.ui.CN.*;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.mycompany.a2.commands.*;
/**
 * Following the Model-View-Controller (MVC) architecture
 * Game is the "controller"
 *
 */
public class Game extends Form
{

    private Form current;
    private GameWorld gw;
    private ScoreView sv;
    private MapView mv;
    private boolean check = false;

    public Game()
    {
        gw = new GameWorld();
        //create a ScoreView and MapView within the Game World
        sv = new ScoreView(gw);
        mv = new MapView(gw);

        Toolbar toolbar = new Toolbar();
        this.setToolbar(toolbar);
        toolbar.setTitle("ThePath Game");

        //create west container
        Container westContainer = new Container();
        westContainer.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.BLACK));
        westContainer.setLayout(new BoxLayout(2));
        //start adding components at a location 50 pixels below the upper border of container
        westContainer.getAllStyles().setPadding(Component.TOP, 50);
        
        //create east container
        Container eastContainer = new Container();
        eastContainer.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.BLACK));
        eastContainer.setLayout(new BoxLayout(2));
        //start adding components at a location 50 pixels below the upper border of container
        eastContainer.getAllStyles().setPadding(Component.TOP, 50);
        
        
        //create south container
        Container southContainer = new Container();
        southContainer.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.BLACK));
        southContainer.setLayout(new BoxLayout(2));
        //need buttons to be placed horizontally and stretched vertically
        southContainer.setLayout(new BoxLayout(BoxLayout.X_AXIS));
        //start adding components at a location 200 pixels to the right of the left border of container
        southContainer.getAllStyles().setPadding(Component.LEFT, 400);
         
        //commands with key bindings
        Command accelerateCommand = new CommandAccelerate(gw);
        Command brakeCommand = new CommandBrake(gw);
        Command leftCommand = new CommandLeft(gw);
        Command rightCommand = new CommandRight(gw);
        Command foodStationCollisionCommand = new CommandFoodStationCollision(gw);
        Command spiderCollisionCommand = new CommandSpiderCollision(gw);
        Command tickCommand = new CommandClockTick(gw);
        Command exitCommand = new CommandExit(gw);
        
        //commands with buttons only
        Command flagCommand = new CommandFlagCollision(gw);
        
        //commands only on side menu
        Command soundCommand = new CommandSound(gw);
        Command aboutCommand = new CommandAbout(gw);
        Command helpCommand = new CommandHelp(gw);
        
        //add key listeners here, upon key press command is activated
        addKeyListener('a',accelerateCommand);
        addKeyListener('b', brakeCommand);
        addKeyListener('l', leftCommand);
        addKeyListener('r',rightCommand);
        addKeyListener('f', foodStationCollisionCommand);
        addKeyListener('g',spiderCollisionCommand);
        addKeyListener('t',tickCommand);
        addKeyListener('e',exitCommand);
        
        //buttons on west container
        Button accelerateButton = new Button("Accelerate");
		accelerateButton.setCommand(accelerateCommand);
		westContainer.addComponent(accelerateButton);
		accelerateButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		accelerateButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		accelerateButton.getAllStyles().setBgTransparency(255);
		accelerateButton.getAllStyles().setMarginBottom(10); 
		
		Button leftButton = new Button("Left"); 
		leftButton.setCommand(leftCommand);
		westContainer.addComponent(leftButton);	
		leftButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		leftButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		leftButton.getAllStyles().setBgTransparency(255);	
		leftButton.getAllStyles().setMarginBottom(10);
		
		//buttons on east container
		Button brakeButton = new Button("Brake");
		brakeButton.setCommand(brakeCommand);
		eastContainer.addComponent(brakeButton);
		brakeButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		brakeButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		brakeButton.getAllStyles().setBgTransparency(255);	
		brakeButton.getAllStyles().setMarginBottom(10);
		
		
		Button rightButton = new Button("Right");
		rightButton.setCommand(rightCommand);
		eastContainer.addComponent(rightButton);
		rightButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		rightButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		rightButton.getAllStyles().setBgTransparency(255);	
		rightButton.getAllStyles().setMarginBottom(10);
		
		//buttons on south container
		Button flagButton = new Button("Collide with Flag");
		southContainer.add(flagButton);
		flagButton.setCommand(flagCommand);
		flagButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		flagButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		flagButton.getAllStyles().setBgTransparency(255);	
		flagButton.getAllStyles().setMarginRight(5);
		
		Button spiderButton = new Button("Collide with Spider");
		southContainer.addComponent(spiderButton);
		spiderButton.setCommand(spiderCollisionCommand);
		spiderButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		spiderButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		spiderButton.getAllStyles().setBgTransparency(255);	
		spiderButton.getAllStyles().setMarginRight(5);
		
		Button foodStationButton = new Button("Collide with Food Station");
		southContainer.add(foodStationButton);
		foodStationButton.setCommand(foodStationCollisionCommand);
		foodStationButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		foodStationButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		foodStationButton.getAllStyles().setBgTransparency(255);	
		foodStationButton.getAllStyles().setMarginRight(5);
        

		
		Button tickButton  = new Button("Tick");
		tickButton.setCommand(tickCommand);
		southContainer.add(tickButton);
		tickButton.getAllStyles().setFgColor(ColorUtil.WHITE);
		tickButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		tickButton.getAllStyles().setBgTransparency(255);	
		tickButton.getAllStyles().setMarginRight(5);
        
		//commands on side menu
		toolbar.addCommandToSideMenu(accelerateCommand);
		
		CheckBox soundCheck = new CheckBox();
		soundCheck.getAllStyles().setBgTransparency(255);
		//soundCheck.getAllStyles().setBgColor(ColorUtil.BLUE);
		toolbar.addComponentToSideMenu(soundCheck);
		//add the sound command to checkbox
		soundCheck.setCommand(soundCommand);
		
		toolbar.addCommandToSideMenu(aboutCommand);
		toolbar.addCommandToSideMenu(exitCommand);
		toolbar.addCommandToRightBar(helpCommand);
        
		//add border layouts and containers to the form
		this.setLayout(new BorderLayout());
		this.add(BorderLayout.WEST, westContainer);
		this.add(BorderLayout.EAST, eastContainer);
		this.add(BorderLayout.SOUTH, southContainer);
		this.add(BorderLayout.NORTH, sv);
		this.add(BorderLayout.CENTER, mv);
		
		//set dimensions of game world, based off of MapView
		gw.setMapHeight(mv.getComponentForm().getHeight());
		gw.setMapWidth(mv.getComponentForm().getWidth());
        
        gw.init();
        this.show();
    }

    private void play()
    {
        //code here to accept and
        //execute user commands that
        //operate on the game world
        Label myLabel=new Label("Enter a Command:");
        this.addComponent(myLabel);
        final TextField myTextField=new TextField();
        this.addComponent(myTextField);
        this.show();
        myTextField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String sCommand=myTextField.getText().toString();
                myTextField.clear();
                if(sCommand.length() != 0)
                {
	                if(check==true)	//checks if user wants to quit
	                {
	                	switch(sCommand.charAt(0))
	                	{
	                	case 'y':
	                		System.exit(0);
	                		break;
	                	case 'n':
	                		check = false;
	                		break;
	                		default: 
	                			System.out.println("Enter y or n");
	                	}
	                }
                }
                if(sCommand.length() != 0)
                    switch (sCommand.charAt(0)) {
                        case 'a':
                            gw.accelerate();
                            break;
                        case 'b':
                            gw.brake();
                            break;
                        case 'l':
                            gw.left();
                            break;
                        case 'r':
                            gw.right();
                            break;
                        case 'g':
                            gw.spiderCollision();
                            break;
                        case 'f':
                            gw.foodStationCollision();
                            break;
                        case '1':
                        	gw.flagCollision(1);
                        	break;
                        case '2':
                        	gw.flagCollision(2);
                        	break;
                        case '3':
                        	gw.flagCollision(3);
                        	break;
                        case '4':
                        	gw.flagCollision(4);
                        	break;
                        case '5':
                        	gw.flagCollision(5);
                        	break;
                        case '6':
                        	gw.flagCollision(6);
                        	break;
                        case '7':
                        	gw.flagCollision(7);
                        	break;
                        case '8':
                        	gw.flagCollision(8);
                        	break;
                        case '9':
                        	gw.flagCollision(9);
                        	break;
                        case 't':
                            gw.clockTick();
                            break;
                        case 'd':
                            gw.display();
                            break;
                        case 'm':
                            gw.map();
                            break;
                        case 'x':
                        	System.out.println("Do you want to quit?");
                        	check = true;
                        case 'y':
                        	if (check)
                        	{
                        		System.exit(1);
                        	}
                        case 'n':
                        	if (check)
                        	{
                        		System.exit(0);
                        	}
                        default:
                            System.out.println("Invalid keyboard input");

                    }
                } //actionPerformed
            } //new ActionListener()
            ); //addActionListener
    }
    

}