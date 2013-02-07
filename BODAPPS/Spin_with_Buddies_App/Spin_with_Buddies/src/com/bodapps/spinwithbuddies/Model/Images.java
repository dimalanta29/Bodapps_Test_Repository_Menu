package com.bodapps.spinwithbuddies.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;

public class Images 
{
	//TODO __________[ Field Data ]__________
	public Texture bottle;
	public Texture shadow;
	public Texture bodapps;
	public Texture game_logo;
	public Texture black;
	public Texture spin;
	public Texture[] background;
	
	
	
	
	
	
	
	
	
	
	//TODO __________[ Images' Construcotr ]__________
	public Images()
	{
		bottle = new Texture(Gdx.files.internal("images/bottle/bottle 1024x512.png"));
		shadow = new Texture(Gdx.files.internal("images/bottle/bottle silhouette 1024x512.png"));
		bodapps = new Texture(Gdx.files.internal("images/misc/bodapps logo.png"));
		game_logo = new Texture(Gdx.files.internal("images/misc/game logo.png"));
		black = new Texture(Gdx.files.internal("images/misc/black.png"));
		spin = new Texture(Gdx.files.internal("images/buttons/spin icon.png"));
		
		background = new Texture[3];
		
		background[0] = new Texture(Gdx.files.internal("images/background/wood 1.png"));
		
		bottle.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		shadow.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		bodapps.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		game_logo.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		black.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		spin.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		background[0].setFilter(TextureFilter.Linear, TextureFilter.Linear);
	}
	
	
	
	
	
	
	
	
	
	
	//TODO __________[ Method for Disposing Images ]__________
	public void Dispose_Images()
	{
		bottle.dispose();
		shadow.dispose();
		bodapps.dispose();
		game_logo.dispose();
		black.dispose();
		spin.dispose();
		
		for(int i = 0; i < 3; i++)
		{
			background[i].dispose();
		}
	}
}
