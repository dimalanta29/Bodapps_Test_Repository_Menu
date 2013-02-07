package com.bodapps.spinwithbuddies.Controls;

import aurelienribon.tweenengine.TweenAccessor;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Tween_Animation implements TweenAccessor<Sprite>
{
	//-----[ Types of Tweens ]-----
	public static final int ALPHA = 1;
	public static final int MOVE_LEFT = 2;
	public static final int MOVE_RIGHT = 3;
	public static final int MOVE_LEFT_ALPHA = 4;
	public static final int MOVE_RIGHT_ALPHA = 5;
	public static final int ROTATE = 6;
	
	
	
	
	
	@Override
	public int getValues(Sprite target, int tweenType, float[] returnValue) 
	{
		// TODO Auto-generated method stub
		switch(tweenType)
		{
			case ALPHA: returnValue[0] = target.getColor().a;
						return 1;
						
			default: return 0;
		}
	}

	
	
	
	
	@Override
	public void setValues(Sprite target, int tweenType, float[] newValue) 
	{
		// TODO Auto-generated method stub
		switch(tweenType)
		{
			case ALPHA: target.setColor(1, 1, 1, newValue[0]);
						break;
		}
	}
}
