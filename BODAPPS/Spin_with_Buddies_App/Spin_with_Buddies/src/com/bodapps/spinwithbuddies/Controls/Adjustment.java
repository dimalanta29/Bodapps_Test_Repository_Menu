package com.bodapps.spinwithbuddies.Controls;

import com.badlogic.gdx.math.Rectangle;

public class Adjustment 
{
	//TODO __________[ Field Data ]__________
	public Rectangle bottle;
	public Rectangle bodapps;
	public Rectangle game_logo;
	public Rectangle black;
	public Rectangle black_2;
	public Rectangle spin;
	public Rectangle bg;
	
	
	
	
	
	//TODO __________[ Adjustment's Constructor ]__________
	public Adjustment()
	{
		bottle = new Rectangle();
		bottle.width = 300;
		bottle.height = 660;
		bottle.x = (900/2) - (bottle.width/2);
		bottle.y = (1280/2) - (bottle.height/2);
		
		bodapps = new Rectangle();
		bodapps.width = 320;
		bodapps.height = 80;
		bodapps.x = (900/2) - (bodapps.width/2);
		bodapps.y = (1280/16) * 15;
		
		game_logo = new Rectangle();
		game_logo.width = 600;
		game_logo.height = 600;
		game_logo.x = (900/2) - (game_logo.width/2);
		game_logo.y = (1280/2) - (game_logo.height/2);
		
		black = new Rectangle();
		black.width = 900;
		black.height = 1280;
		black.x = (900/2) - (black.width/2);
		black.y = (1280/2) - (black.height/2);
		
		black_2 = new Rectangle();
		black_2.width = 900;
		black_2.height = 300;
		black_2.x = (900/2) - (black_2.width/2);
		black_2.y = (1280/16)*0;
		
		spin = new Rectangle();
		spin.width = 120;
		spin.height = 120;
		spin.x = 900 - spin.width;
		spin.y = (1280/16)*0;
		
		bg = new Rectangle();
		bg.width = 900;
		bg.height = 1280;
		bg.x = (900/2) - (bg.width/2);
		bg.y = (1280/2) - (bg.height/2);
	}
}
