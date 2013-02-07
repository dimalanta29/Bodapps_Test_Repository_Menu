package com.bodapps.spinwithbuddies.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class SFX 
{
	public Sound bottle;
	public Sound crowd;
	public Sound jackpot;
	
	public SFX()
	{
		bottle = Gdx.audio.newSound(Gdx.files.internal("SFX/bottle roll.mp3"));
		crowd = Gdx.audio.newSound(Gdx.files.internal("SFX/crowd wow.mp3"));
		jackpot = Gdx.audio.newSound(Gdx.files.internal("SFX/jackpot.wav"));
	}
	
	public void Dispose_SFX()
	{
		bottle.dispose();
		crowd.dispose();
		jackpot.dispose();
	}
}
