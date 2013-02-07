package com.bodapps.spinwithbuddies.Controls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Camera_View 
{
	//TODO __________[ Field data ]__________
	//-----[ Camera Views ]-----
	public Camera main_camera; // --> This will use to make screen aspect ration to prevent shape distortion.
	public OrthographicCamera cam_1;
	
	
	
	//-----[ Camera Angle Values (For "main_camera") ]-----
	public static final int VIRTUAL_WIDTH = 900;
	public static final int VIRTUAL_HEIGHT = 1280;
	public static final float ASPECT_RATIO = ((float)VIRTUAL_WIDTH / (float)VIRTUAL_HEIGHT);
	public Rectangle Viewport;
	
	
	
	
	
	
	
	
	
	
	//TODO __________[ Camera View's Constructor ]__________
	public Camera_View(float View_Width, float View_Height, boolean Y_Down, int index)
	{
		//-----[ Camera Setup ]-----
		cam_1 = new OrthographicCamera();
		cam_1.setToOrtho(Y_Down, View_Width, View_Height);
		
		main_camera = new OrthographicCamera(VIRTUAL_WIDTH, VIRTUAL_HEIGHT);
	}
	
	
	
	
	
	
	
	
	
	
	//TODO __________[ Viewport's Method ]__________
	public void Set_Viewport_Change(Vector2 crop, float width, float height)
	{
		/*
		 * 
		 * 		   Use this method for the "resize()" method. Always associate this method right
		 * 		after setting the constructor or it might not work.
		 * 
		 */
		
		Viewport = new Rectangle(crop.x, crop.y, width, height);
	}
	
	
	
	
	
	
	
	
	
	
	//TODO __________[ Aspect Ratio's View Update ]__________
	public void Update_Aspect_Screen_Ratio()
	{
		// Update the main camera.
		main_camera.update();
		main_camera.apply(Gdx.gl10);
		
		// Reset the viewport.
		Gdx.gl.glViewport((int)Viewport.x, (int)Viewport.y, (int)Viewport.width, (int)Viewport.height);
	}
}
