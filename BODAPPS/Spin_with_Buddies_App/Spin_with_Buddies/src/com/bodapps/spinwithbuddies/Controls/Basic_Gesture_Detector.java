package com.bodapps.spinwithbuddies.Controls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.input.GestureDetector;

/*
 * 
 * 			Author of This Code: lycying@gmail.com
 * 
 */

public class Basic_Gesture_Detector extends GestureDetector
{
	public static float fling_L;
	public static float fling_R;
	private static float fling_U;
	public static float fling_D;
	
	
	
	
	
	
	
	
	
	
	public interface Direction_Listener
	{
		void Left();
		void Right();
		void Up();
		void Down();
	}
	
	
	
	
	
	
	
	
	
	
	public Basic_Gesture_Detector(Direction_Listener directions)
	{
		super(new Direction_Gesture_Listener(directions));
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * @return the fling_U
	 */
	public static float getFling_U() {
		return fling_U;
	}

	/**
	 * @param fling_U the fling_U to set
	 */
	public static void setFling_U(float fling_U) {
		Basic_Gesture_Detector.fling_U = fling_U;
	}
	
	/**
	 * @return the fling_D
	 */
	public static float getFling_D() {
		return fling_D;
	}

	/**
	 * @param fling_D the fling_D to set
	 */
	public static void setFling_D(float fling_D) {
		Basic_Gesture_Detector.fling_D = fling_D;
	}
	
	/**
	 * @return the fling_L
	 */
	public static float getFling_L() {
		return fling_L;
	}

	/**
	 * @param fling_L the fling_L to set
	 */
	public static void setFling_L(float fling_L) {
		Basic_Gesture_Detector.fling_L = fling_L;
	}
	
	/**
	 * @return the fling_R
	 */
	public static float getFling_R() {
		return fling_R;
	}

	/**
	 * @param fling_R the fling_R to set
	 */
	public static void setFling_R(float fling_R) {
		Basic_Gesture_Detector.fling_R = fling_R;
	}

	
	
	
	
	
	
	
	
	
	public static class Direction_Gesture_Listener extends GestureAdapter implements GestureListener
	{
		private Direction_Listener directions;
		
		public  Direction_Gesture_Listener(Direction_Listener directions)
		{
			this.directions = directions;
		}
		
		@Override
		public boolean fling(float velocity_X, float velocity_Y, int button)
		{
			if(Math.abs(velocity_X) > Math.abs(velocity_Y))
			{
				if(velocity_X > 0)
				{
					directions.Right();
					setFling_R(velocity_Y);
					
				} else{
					
					directions.Left();
					setFling_L(velocity_Y);
					
				}
				
			} else{
				
				if(velocity_Y > (Gdx.graphics.getHeight()/2))
				{
					directions.Down();
					setFling_D(velocity_Y);
					
				} else{
					
					directions.Up();
					setFling_U(velocity_Y);
					
				}
				
			}
			
			return true;
		}
	}
}
