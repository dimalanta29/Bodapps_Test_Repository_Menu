package com.bodapps.spinwithbuddies.Controls;

import com.bodapps.spinwithbuddies.Start;
import com.bodapps.spinwithbuddies.Game_Screen.Game_App_Screen;
import com.bodapps.spinwithbuddies.Normal_Screen.Title_Scceen;

public class Switch_Screen 
{
	//TODO __________[ Screen Connector ]__________
	Start game; // --> Starter.java
	
	public Switch_Screen(Start game)
	{
		this.game = game;
	}
	
	
	
	
	
	
	
	
	
	
	//TODO __________[ Fade's Constructor ]__________
	public void goTo(int screen_number)
	{
		if(screen_number == 1)
		{
			game.setScreen(new Title_Scceen(game));
			
		} else if(screen_number == 2){
			
			game.setScreen(new Game_App_Screen(game));
			
		}   else{
			
			System.exit(0);
			
		}
	}
}
