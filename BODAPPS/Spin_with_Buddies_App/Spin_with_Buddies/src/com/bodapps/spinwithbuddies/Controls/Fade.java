package com.bodapps.spinwithbuddies.Controls;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.bodapps.spinwithbuddies.Start;

public class Fade 
{
	//TODO __________[ Field data ]__________
	//-----[ Tween Managers ]-----
	public TweenManager manager;
	
	
	
	//-----[ Tween Call Backs ]-----
	public TweenCallback CB;
	
	
	
	//-----[ Conrtol Class ]-----
	public Switch_Screen screen;
	
	
	
	//-----[ Integers ]-----
	public int i = 0;
	
	
	
	
	
	
	
	
	
	
	//TODO __________[ Fade's Constructor ]__________
	public Fade(Start Game)
	{
		// Set the screen switcher.
		screen = new Switch_Screen(Game);
		
		// Set the tween manager.
		Tween.registerAccessor(Sprite.class, new Tween_Animation());
		manager = new TweenManager();
		CB = new TweenCallback() 
		{
			@Override
			public void onEvent(int arg0, BaseTween<?> arg1) 
			{
				// TODO onEvent (Tween Callback)
				Change_Screen();
			}
		};
	}
	
	
	
	
	
	
	
	
	
	
	//TODO __________[ Play with Switching Screen Method ]__________
	public void Play(Sprite sprite, int number_of_times_to_repeat, float duration, float delay_time)
	{
		Tween
		.from(sprite, Tween_Animation.ALPHA, duration)
		.target(1)
		.ease(TweenEquations.easeInQuad)
		.repeatYoyo(number_of_times_to_repeat, delay_time)
		.setCallback(CB)
		.setCallbackTriggers(TweenCallback.COMPLETE)
		.start(manager);
	}
	
	public void Play_2(Sprite sprite, int number_of_times_to_repeat, float duration, float delay_time)
	{
		Tween
		.to(sprite, Tween_Animation.ALPHA, duration)
		.target(1)
		.ease(TweenEquations.easeInQuad)
		.repeatYoyo(number_of_times_to_repeat, delay_time)
		.setCallback(CB)
		.setCallbackTriggers(TweenCallback.COMPLETE)
		.start(manager);
	}
	
	
	
	
	
	
	
	
	
	
	//TODO __________[ Play without Switching Screen Method ]__________
	public void Play_without_Switching_Screen(Sprite sprite, int number_of_times_to_repeat, float duration, float delay_time)
	{
		// TODO Version 1
		
		Tween // --> Bodapps Logo
		.from(sprite, Tween_Animation.ALPHA, duration)
		.target(1)
		.ease(TweenEquations.easeInQuad)
		.repeatYoyo(number_of_times_to_repeat, delay_time)
		.start(manager);
	}
	
	
	
	
	
	
	
	
	
	
	//TODO __________[ Animation Update Method ]__________
	public void Animation_Update(float delta)
	{
		manager.update(delta); // --> Set update to enable animation changes.
	}

	
	
	
	
	
	
	
	
	
	//TODO __________[ Index Method ]__________
	public void Screen_Index(int i)
	{
		this.i = i;
	}
	
	
	
	
	
	
	
	
	
	
	//TODO __________[ Change Screen Method ]__________
	public void Change_Screen()
	{
		screen.goTo(i);
	}
}
