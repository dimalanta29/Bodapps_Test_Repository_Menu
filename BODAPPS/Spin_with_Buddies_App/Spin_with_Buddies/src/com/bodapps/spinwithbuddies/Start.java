package com.bodapps.spinwithbuddies;

import com.badlogic.gdx.Game;
import com.bodapps.spinwithbuddies.Ad_Request_Handler;
import com.bodapps.spinwithbuddies.Normal_Screen.Title_Scceen;

public class Start extends Game
{
	public Ad_Request_Handler ads;
	
	
	
	
	
	
	
	
	
	
	public Start(Ad_Request_Handler ads)
	{
		this.ads = ads;
	}
	
	
	
	
	
	
	
	
	
	
	@Override
	public void create() 
	{
		setScreen(new Title_Scceen(this));
	}
}
