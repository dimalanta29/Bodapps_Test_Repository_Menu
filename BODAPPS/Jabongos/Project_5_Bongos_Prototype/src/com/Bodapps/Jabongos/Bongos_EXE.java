package com.Bodapps.Jabongos;

import com.Bodapps.Jabongos.Screen.Class_1_Splash_Screen;
import com.badlogic.gdx.Game;

public class Bongos_EXE extends Game
{

	public static final String LOG = "Show time!";
	
	@Override
	public void create() 
	{
		// TODO Create Section
		setScreen(new Class_1_Splash_Screen(this));
	}
	
}
