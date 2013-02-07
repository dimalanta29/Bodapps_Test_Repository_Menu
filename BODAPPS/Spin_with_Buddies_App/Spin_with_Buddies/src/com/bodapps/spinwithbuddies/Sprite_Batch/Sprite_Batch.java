package com.bodapps.spinwithbuddies.Sprite_Batch;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Sprite_Batch 
{
	//TODO __________[ Field Data ]__________
	public SpriteBatch title_screen_batch;
	public SpriteBatch main_batch;
	
	
	
	
	
	
	
	
	
	
	//TODO __________[ Sprite Batch's Constructor ]__________
	public Sprite_Batch()
	{
		title_screen_batch = new SpriteBatch();
		main_batch = new SpriteBatch();
	}
	
	
	
	
	
	
	
	
	
	
	//TODO __________[ Method for Disposing Sprite Batch ]__________
	public void Dispose_Batch()
	{
		title_screen_batch.dispose();
		main_batch.dispose();
	}
}
