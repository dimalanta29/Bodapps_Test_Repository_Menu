package com.bodapps.spinwithbuddies;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.bodapps.spinwithbuddies.Ad_Request_Handler;
import com.bodapps.spinwithbuddies.Start;

public class Desktop_Starter implements Ad_Request_Handler
{
	private static Desktop_Starter app;
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) 
	{
		if(app == null)
		{
			app = new Desktop_Starter();
		}
		
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Spin_with_Buddies";
		cfg.useGL20 = false;
		cfg.width = 420;
		cfg.height = 580;
		
		new LwjglApplication(new Start(app), cfg);
	}

	
	
	
	
	
	
	
	
	
	@Override
	public void show_ads(boolean show) 
	{
		// ? ? ?
	}
}
