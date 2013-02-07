package com.Bodapps.Jabongos;

import com.Bodapps.Jabongos.Bongos_EXE;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Desktop_Starter 
{
	
	public static void main(String[] args) 
	{
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Project_5_Bongos_Prototype";
		cfg.useGL20 = false;
		cfg.width = 580;
		cfg.height = 420;
		
		new LwjglApplication(new Bongos_EXE(), cfg);
	}
	
}
