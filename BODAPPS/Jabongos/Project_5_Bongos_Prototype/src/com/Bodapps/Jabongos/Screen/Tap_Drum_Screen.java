package com.Bodapps.Jabongos.Screen;

import com.Bodapps.Jabongos.Bongos_EXE;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Tap_Drum_Screen implements Screen
{

	/*
	 * _______________________________________________________________________________________________
	 * 
	 * 			TODO ---> Field Section
	 * _______________________________________________________________________________________________
	 */
	
	private OrthographicCamera camera;
	
	private float w = 1280; // --> Width
	private float h = 720;  // --> Height
	private float x, x2 = 0;    // --> X Coordinate
	private float y, y2 = 0;    // --> Y Coordinate
	
	private int finger_index;
	
	private Vector3 Touch_Sensor;
	
	private SpriteBatch batch;
	
	private Texture Drum_Bongos_IMG;
	private Texture Background_IMG;
	
	private Rectangle Drum_POS;
	private Rectangle Background_POS;
	
	private Sound Macho_Lo_SFX;
	private Sound Macho_Mi_SFX;
	private Sound Macho_Hi_SFX;
	private Sound Hembra_Lo_SFX;
	private Sound Hembra_Mi_SFX;
	private Sound Hembra_Hi_SFX;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * _______________________________________________________________________________________________
	 * 
	 * 			TODO ---> Screen Call Setup
	 * _______________________________________________________________________________________________
	 */
	
	public Bongos_EXE game;
	
	public Tap_Drum_Screen(Bongos_EXE game)
	{
		this.game = game;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * _______________________________________________________________________________________________
	 * 
	 * 			TODO ---> Screen Method Group Section
	 * _______________________________________________________________________________________________
	 */
	
	@Override
	public void render(float delta) 
	{
		// TODO Rendering Section
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		
			batch.draw(Background_IMG, Background_POS.x, Background_POS.y, Background_POS.width, Background_POS.height);
			batch.draw(Drum_Bongos_IMG, Drum_POS.x, Drum_POS.y, Drum_POS.width, Drum_POS.height);
			//batch.draw(Background_IMG, Background_POS.x, Background_POS.y, Background_POS.width, Background_POS.height);
			
		batch.end();
		
		
		
		
		
		//-----[ Checking for Coordinates ]-----
		//For mouse clicks or screen touch...
		if(Gdx.input.justTouched()) // --> This condition is useful only for single touch per coordinate.
		{
			float X;
			float Y;
			
			//For target image only.
			Touch_Sensor = new Vector3();
			Touch_Sensor.set(X = Gdx.input.getX(), Y = Gdx.input.getY(), 180);
			camera.unproject(Touch_Sensor);
			
			x = X;
			y = Y;
		}
		
		//For the next finger to touch...
		if(Gdx.input.justTouched())
		{
			finger_index = 0;
		}
		if(Gdx.input.isTouched(1))
		{
			finger_index = 1;
		}
		if(Gdx.input.isTouched(2))
		{
			finger_index = 2;
		}
		if(Gdx.input.isTouched(3))
		{
			finger_index = 3;
		}
		if(Gdx.input.isTouched(4))
		{
			finger_index = 4;
		}
		if(Gdx.input.isTouched(5))
		{
			finger_index = 5;
		}
		if(Gdx.input.isTouched(6))
		{
			finger_index = 6;
		}
		if(Gdx.input.isTouched(7))
		{
			finger_index = 7;
		}
		if(Gdx.input.isTouched(8))
		{
			finger_index = 8;
		}
		if(Gdx.input.isTouched(9))
		{
			finger_index = 9;
		}
		
		
		
		
		
		//-----[ Rendering Key Event ]-----
		if(Gdx.input.isKeyPressed(Keys.ALT_LEFT))
		{
			Macho_Lo_SFX.play();
			Gdx.app.log(Bongos_EXE.LOG, "You hit with drum no. 1.");
		}
		
		if(Gdx.input.isKeyPressed(Keys.ALT_RIGHT))
		{
			Hembra_Lo_SFX.play();
			Gdx.app.log(Bongos_EXE.LOG, "You hit with drum no. 2.");
		}
		
		
		
		
		
		//-----[ Rendering Touch Event ]-----
		if(Gdx.input.justTouched())
		{
			//Macho Drum
			if(Gdx.input.getX(0) >= (Gdx.graphics.getWidth()/16) * 4 &&
					Gdx.input.getX(0) <= (Gdx.graphics.getWidth()/16) * 6 &&
					Gdx.input.getY(0) >= (Gdx.graphics.getHeight()/16) * 6 &&
					Gdx.input.getY(0) <= (Gdx.graphics.getHeight()/16) * 9)
			{
				Macho_Lo_SFX.play();
				Gdx.app.log(Bongos_EXE.LOG, "You hit macho drum at center.");
			}
			
			else if(Gdx.input.getX(0) >= (Gdx.graphics.getWidth()/16) * 3 &&
					Gdx.input.getX(0) <= (Gdx.graphics.getWidth()/16) * 4 &&
					Gdx.input.getY(0) >= (Gdx.graphics.getHeight()/16) * 6 &&
					Gdx.input.getY(0) <= (Gdx.graphics.getHeight()/16) * 9)
			{
				Macho_Mi_SFX.play();
				Gdx.app.log(Bongos_EXE.LOG, "You hit macho drum at left.");
			}
			
			else if(Gdx.input.getX(0) >= (Gdx.graphics.getWidth()/16) * 2 &&
					Gdx.input.getX(0) <= (Gdx.graphics.getWidth()/16) * 3 &&
					Gdx.input.getY(0) >= (Gdx.graphics.getHeight()/16) * 6 &&
					Gdx.input.getY(0) <= (Gdx.graphics.getHeight()/16) * 9)
			{
				Macho_Hi_SFX.play();
				Gdx.app.log(Bongos_EXE.LOG, "You hit macho drum at left edge.");
			}
			
			else if(Gdx.input.getX(0) >= (Gdx.graphics.getWidth()/16) * 6 &&
					Gdx.input.getX(0) <= (Gdx.graphics.getWidth()/16) * 7 &&
					Gdx.input.getY(0) >= (Gdx.graphics.getHeight()/16) * 6 &&
					Gdx.input.getY(0) <= (Gdx.graphics.getHeight()/16) * 9)
			{
				Macho_Mi_SFX.play();
				Gdx.app.log(Bongos_EXE.LOG, "You hit macho drum at right.");
			}
			
			else if(Gdx.input.getX(0) >= (Gdx.graphics.getWidth()/16) * 7 &&
					Gdx.input.getX(0) <= (Gdx.graphics.getWidth()/16) * 8 &&
					Gdx.input.getY(0) >= (Gdx.graphics.getHeight()/16) * 6 &&
					Gdx.input.getY(0) <= (Gdx.graphics.getHeight()/16) * 9)
			{
				Macho_Hi_SFX.play();
				Gdx.app.log(Bongos_EXE.LOG, "You hit macho drum at right edge.");
			}
			
			else if(Gdx.input.getX(0) >= (Gdx.graphics.getWidth()/16) * 3 &&
					Gdx.input.getX(0) <= (Gdx.graphics.getWidth()/16) * 6 &&
					Gdx.input.getY(0) >= (Gdx.graphics.getHeight()/16) * 5 &&
					Gdx.input.getY(0) <= (Gdx.graphics.getHeight()/16) * 6)
			{
				Macho_Mi_SFX.play();
				Gdx.app.log(Bongos_EXE.LOG, "You hit macho drum at top.");
			}
			
			else if(Gdx.input.getX(0) >= (Gdx.graphics.getWidth()/16) * 3 &&
					Gdx.input.getX(0) <= (Gdx.graphics.getWidth()/16) * 7 &&
					Gdx.input.getY(0) >= (Gdx.graphics.getHeight()/16) * 3 &&
					Gdx.input.getY(0) <= (Gdx.graphics.getHeight()/16) * 6)
			{
				Macho_Hi_SFX.play();
				Gdx.app.log(Bongos_EXE.LOG, "You hit macho drum at top edge.");
			}
			
			else if(Gdx.input.getX(0) >= (Gdx.graphics.getWidth()/16) * 3 &&
					Gdx.input.getX(0) <= (Gdx.graphics.getWidth()/16) * 6 &&
					Gdx.input.getY(0) >= (Gdx.graphics.getHeight()/16) * 9 &&
					Gdx.input.getY(0) <= (Gdx.graphics.getHeight()/16) * 11)
			{
				Macho_Mi_SFX.play();
				Gdx.app.log(Bongos_EXE.LOG, "You hit macho drum at bottom.");
			}
			
			else if(Gdx.input.getX(0) >= (Gdx.graphics.getWidth()/16) * 3 &&
					Gdx.input.getX(0) <= (Gdx.graphics.getWidth()/16) * 7 &&
					Gdx.input.getY(0) >= (Gdx.graphics.getHeight()/16) * 11 &&
					Gdx.input.getY(0) <= (Gdx.graphics.getHeight()/16) * 12)
			{
				Macho_Hi_SFX.play();
				Gdx.app.log(Bongos_EXE.LOG, "You hit macho drum at bottom edge.");
			}
			
			
			
			//Hembra Drum
			else if(Gdx.input.getX(0) >= (Gdx.graphics.getWidth()/16) * 10 &&
					Gdx.input.getX(0) <= (Gdx.graphics.getWidth()/16) * 12 &&
					Gdx.input.getY(0) >= (Gdx.graphics.getHeight()/16) * 6 &&
					Gdx.input.getY(0) <= (Gdx.graphics.getHeight()/16) * 9)
			{
				Hembra_Lo_SFX.play();
				Gdx.app.log(Bongos_EXE.LOG, "You hit hembra drum at center.");
			}
			
			else if(Gdx.input.getX(0) >= (Gdx.graphics.getWidth()/16) * 9 &&
					Gdx.input.getX(0) <= (Gdx.graphics.getWidth()/16) * 10 &&
					Gdx.input.getY(0) >= (Gdx.graphics.getHeight()/16) * 6 &&
					Gdx.input.getY(0) <= (Gdx.graphics.getHeight()/16) * 9)
			{
				Hembra_Mi_SFX.play();
				Gdx.app.log(Bongos_EXE.LOG, "You hit hembra drum at left.");
			}
			
			else if(Gdx.input.getX(0) >= (Gdx.graphics.getWidth()/16) * 8 &&
					Gdx.input.getX(0) <= (Gdx.graphics.getWidth()/16) * 9 &&
					Gdx.input.getY(0) >= (Gdx.graphics.getHeight()/16) * 3 &&
					Gdx.input.getY(0) <= (Gdx.graphics.getHeight()/16) * 12)
			{
				Hembra_Hi_SFX.play();
				Gdx.app.log(Bongos_EXE.LOG, "You hit hembra drum at left edge.");
			}
			
			else if(Gdx.input.getX(0) >= (Gdx.graphics.getWidth()/16) * 12 &&
					Gdx.input.getX(0) <= (Gdx.graphics.getWidth()/16) * 13 &&
					Gdx.input.getY(0) >= (Gdx.graphics.getHeight()/16) * 6 &&
					Gdx.input.getY(0) <= (Gdx.graphics.getHeight()/16) * 9)
			{
				Hembra_Mi_SFX.play();
				Gdx.app.log(Bongos_EXE.LOG, "You hit hembra drum at right.");
			}
			
			else if(Gdx.input.getX(0) >= (Gdx.graphics.getWidth()/16) * 13 &&
					Gdx.input.getX(0) <= (Gdx.graphics.getWidth()/16) * 14 &&
					Gdx.input.getY(0) >= (Gdx.graphics.getHeight()/16) * 3 &&
					Gdx.input.getY(0) <= (Gdx.graphics.getHeight()/16) * 12)
			{
				Hembra_Hi_SFX.play();
				Gdx.app.log(Bongos_EXE.LOG, "You hit hembra drum at right edge.");
			}
			
			else if(Gdx.input.getX(0) >= (Gdx.graphics.getWidth()/16) * 9 &&
					Gdx.input.getX(0) <= (Gdx.graphics.getWidth()/16) * 13 &&
					Gdx.input.getY(0) >= (Gdx.graphics.getHeight()/16) * 4 &&
					Gdx.input.getY(0) <= (Gdx.graphics.getHeight()/16) * 6)
			{
				Hembra_Mi_SFX.play();
				Gdx.app.log(Bongos_EXE.LOG, "You hit hembra drum at top.");
			}
			
			else if(Gdx.input.getX(0) >= (Gdx.graphics.getWidth()/16) * 9 &&
					Gdx.input.getX(0) <= (Gdx.graphics.getWidth()/16) * 13 &&
					Gdx.input.getY(0) >= (Gdx.graphics.getHeight()/16) * 2 &&
					Gdx.input.getY(0) <= (Gdx.graphics.getHeight()/16) * 3)
			{
				Hembra_Hi_SFX.play();
				Gdx.app.log(Bongos_EXE.LOG, "You hit hembra drum at top edge.");
			}
			
			else if(Gdx.input.getX(0) >= (Gdx.graphics.getWidth()/16) * 9 &&
					Gdx.input.getX(0) <= (Gdx.graphics.getWidth()/16) * 13 &&
					Gdx.input.getY(0) >= (Gdx.graphics.getHeight()/16) * 9 &&
					Gdx.input.getY(0) <= (Gdx.graphics.getHeight()/16) * 11)
			{
				Hembra_Mi_SFX.play();
				Gdx.app.log(Bongos_EXE.LOG, "You hit hembra drum at bottom.");
			}
			
			else if(Gdx.input.getX(0) >= (Gdx.graphics.getWidth()/16) * 8 &&
					Gdx.input.getX(0) <= (Gdx.graphics.getWidth()/16) * 13 &&
					Gdx.input.getY(0) >= (Gdx.graphics.getHeight()/16) * 11 &&
					Gdx.input.getY(0) <= (Gdx.graphics.getHeight()/16) * 13)
			{
				Hembra_Hi_SFX.play();
				Gdx.app.log(Bongos_EXE.LOG, "You hit hembra drum at bottom edge.");
			}
			
			
			
			//When you touch with the same drum with your next finger or simultaneously...
			if(Gdx.input.isTouched(1) || finger_index > 0)
			{
				//When you touch the small bongo drum (Macho)...
				if(Gdx.input.getX(finger_index) >= (Gdx.graphics.getWidth()/8) * 2 &&
						Gdx.input.getX(finger_index) <= (Gdx.graphics.getWidth()/8) * 4 &&
						Gdx.input.getY(finger_index) >= (Gdx.graphics.getHeight()/8) * 3 &&
						Gdx.input.getY(finger_index) <= (Gdx.graphics.getHeight()/8) * 4)
				{
					Macho_Lo_SFX.play();
					Gdx.app.log(Bongos_EXE.LOG, "You hit macho drum at center. (nth touch)");
				}
				else if(Gdx.input.getX(finger_index) >= (Gdx.graphics.getWidth()/16) * 3 &&
						Gdx.input.getX(finger_index) <= (Gdx.graphics.getWidth()/16) * 4 &&
						Gdx.input.getY(finger_index) >= (Gdx.graphics.getHeight()/16) * 6 &&
						Gdx.input.getY(finger_index) <= (Gdx.graphics.getHeight()/16) * 9)
				{
					Macho_Mi_SFX.play();
					Gdx.app.log(Bongos_EXE.LOG, "You hit macho drum at left.");
				}
				
				else if(Gdx.input.getX(finger_index) >= (Gdx.graphics.getWidth()/16) * 2 &&
						Gdx.input.getX(finger_index) <= (Gdx.graphics.getWidth()/16) * 3 &&
						Gdx.input.getY(finger_index) >= (Gdx.graphics.getHeight()/16) * 6 &&
						Gdx.input.getY(finger_index) <= (Gdx.graphics.getHeight()/16) * 9)
				{
					Macho_Hi_SFX.play();
					Gdx.app.log(Bongos_EXE.LOG, "You hit macho drum at left edge.");
				}
				
				else if(Gdx.input.getX(finger_index) >= (Gdx.graphics.getWidth()/16) * 6 &&
						Gdx.input.getX(finger_index) <= (Gdx.graphics.getWidth()/16) * 7 &&
						Gdx.input.getY(finger_index) >= (Gdx.graphics.getHeight()/16) * 6 &&
						Gdx.input.getY(finger_index) <= (Gdx.graphics.getHeight()/16) * 9)
				{
					Macho_Mi_SFX.play();
					Gdx.app.log(Bongos_EXE.LOG, "You hit macho drum at right.");
				}
				
				else if(Gdx.input.getX(finger_index) >= (Gdx.graphics.getWidth()/16) * 7 &&
						Gdx.input.getX(finger_index) <= (Gdx.graphics.getWidth()/16) * 8 &&
						Gdx.input.getY(finger_index) >= (Gdx.graphics.getHeight()/16) * 6 &&
						Gdx.input.getY(finger_index) <= (Gdx.graphics.getHeight()/16) * 9)
				{
					Macho_Hi_SFX.play();
					Gdx.app.log(Bongos_EXE.LOG, "You hit macho drum at right edge.");
				}
				
				else if(Gdx.input.getX(finger_index) >= (Gdx.graphics.getWidth()/16) * 3 &&
						Gdx.input.getX(finger_index) <= (Gdx.graphics.getWidth()/16) * 6 &&
						Gdx.input.getY(finger_index) >= (Gdx.graphics.getHeight()/16) * 5 &&
						Gdx.input.getY(finger_index) <= (Gdx.graphics.getHeight()/16) * 6)
				{
					Macho_Mi_SFX.play();
					Gdx.app.log(Bongos_EXE.LOG, "You hit macho drum at top.");
				}
				
				else if(Gdx.input.getX(finger_index) >= (Gdx.graphics.getWidth()/16) * 3 &&
						Gdx.input.getX(finger_index) <= (Gdx.graphics.getWidth()/16) * 7 &&
						Gdx.input.getY(finger_index) >= (Gdx.graphics.getHeight()/16) * 3 &&
						Gdx.input.getY(finger_index) <= (Gdx.graphics.getHeight()/16) * 6)
				{
					Macho_Hi_SFX.play();
					Gdx.app.log(Bongos_EXE.LOG, "You hit macho drum at top edge.");
				}
				
				else if(Gdx.input.getX(finger_index) >= (Gdx.graphics.getWidth()/16) * 3 &&
						Gdx.input.getX(finger_index) <= (Gdx.graphics.getWidth()/16) * 6 &&
						Gdx.input.getY(finger_index) >= (Gdx.graphics.getHeight()/16) * 9 &&
						Gdx.input.getY(finger_index) <= (Gdx.graphics.getHeight()/16) * 11)
				{
					Macho_Mi_SFX.play();
					Gdx.app.log(Bongos_EXE.LOG, "You hit macho drum at bottom.");
				}
				
				else if(Gdx.input.getX(finger_index) >= (Gdx.graphics.getWidth()/16) * 3 &&
						Gdx.input.getX(finger_index) <= (Gdx.graphics.getWidth()/16) * 7 &&
						Gdx.input.getY(finger_index) >= (Gdx.graphics.getHeight()/16) * 11 &&
						Gdx.input.getY(finger_index) <= (Gdx.graphics.getHeight()/16) * 12)
				{
					Macho_Hi_SFX.play();
					Gdx.app.log(Bongos_EXE.LOG, "You hit macho drum at bottom edge.");
				}
				
				
				
				//When you touch the big bongo drum (Hembra)...
				else if(Gdx.input.getX(finger_index) >= (Gdx.graphics.getWidth()/16) * 10 &&
						Gdx.input.getX(finger_index) <= (Gdx.graphics.getWidth()/16) * 12 &&
						Gdx.input.getY(finger_index) >= (Gdx.graphics.getHeight()/16) * 6 &&
						Gdx.input.getY(finger_index) <= (Gdx.graphics.getHeight()/16) * 9)
				{
					Hembra_Lo_SFX.play();
					Gdx.app.log(Bongos_EXE.LOG, "You hit hembra drum at center. (nth touch)");
				}
				
				else if(Gdx.input.getX(finger_index) >= (Gdx.graphics.getWidth()/16) * 9 &&
						Gdx.input.getX(finger_index) <= (Gdx.graphics.getWidth()/16) * 10 &&
						Gdx.input.getY(finger_index) >= (Gdx.graphics.getHeight()/16) * 6 &&
						Gdx.input.getY(finger_index) <= (Gdx.graphics.getHeight()/16) * 9)
				{
					Hembra_Mi_SFX.play();
					Gdx.app.log(Bongos_EXE.LOG, "You hit hembra drum at left.");
				}
				
				else if(Gdx.input.getX(finger_index) >= (Gdx.graphics.getWidth()/16) * 8 &&
						Gdx.input.getX(finger_index) <= (Gdx.graphics.getWidth()/16) * 9 &&
						Gdx.input.getY(finger_index) >= (Gdx.graphics.getHeight()/16) * 3 &&
						Gdx.input.getY(finger_index) <= (Gdx.graphics.getHeight()/16) * 12)
				{
					Hembra_Hi_SFX.play();
					Gdx.app.log(Bongos_EXE.LOG, "You hit hembra drum at left edge.");
				}
				
				else if(Gdx.input.getX(finger_index) >= (Gdx.graphics.getWidth()/16) * 12 &&
						Gdx.input.getX(finger_index) <= (Gdx.graphics.getWidth()/16) * 13 &&
						Gdx.input.getY(finger_index) >= (Gdx.graphics.getHeight()/16) * 6 &&
						Gdx.input.getY(finger_index) <= (Gdx.graphics.getHeight()/16) * 9)
				{
					Hembra_Mi_SFX.play();
					Gdx.app.log(Bongos_EXE.LOG, "You hit hembra drum at right.");
				}
				
				else if(Gdx.input.getX(finger_index) >= (Gdx.graphics.getWidth()/16) * 13 &&
						Gdx.input.getX(finger_index) <= (Gdx.graphics.getWidth()/16) * 14 &&
						Gdx.input.getY(finger_index) >= (Gdx.graphics.getHeight()/16) * 3 &&
						Gdx.input.getY(finger_index) <= (Gdx.graphics.getHeight()/16) * 12)
				{
					Hembra_Hi_SFX.play();
					Gdx.app.log(Bongos_EXE.LOG, "You hit hembra drum at right edge.");
				}
				
				else if(Gdx.input.getX(finger_index) >= (Gdx.graphics.getWidth()/16) * 9 &&
						Gdx.input.getX(finger_index) <= (Gdx.graphics.getWidth()/16) * 13 &&
						Gdx.input.getY(finger_index) >= (Gdx.graphics.getHeight()/16) * 4 &&
						Gdx.input.getY(finger_index) <= (Gdx.graphics.getHeight()/16) * 6)
				{
					Hembra_Mi_SFX.play();
					Gdx.app.log(Bongos_EXE.LOG, "You hit hembra drum at top.");
				}
				
				else if(Gdx.input.getX(finger_index) >= (Gdx.graphics.getWidth()/16) * 9 &&
						Gdx.input.getX(finger_index) <= (Gdx.graphics.getWidth()/16) * 13 &&
						Gdx.input.getY(finger_index) >= (Gdx.graphics.getHeight()/16) * 2 &&
						Gdx.input.getY(finger_index) <= (Gdx.graphics.getHeight()/16) * 3)
				{
					Hembra_Hi_SFX.play();
					Gdx.app.log(Bongos_EXE.LOG, "You hit hembra drum at top edge.");
				}
				
				else if(Gdx.input.getX(finger_index) >= (Gdx.graphics.getWidth()/16) * 9 &&
						Gdx.input.getX(finger_index) <= (Gdx.graphics.getWidth()/16) * 13 &&
						Gdx.input.getY(finger_index) >= (Gdx.graphics.getHeight()/16) * 9 &&
						Gdx.input.getY(finger_index) <= (Gdx.graphics.getHeight()/16) * 11)
				{
					Hembra_Mi_SFX.play();
					Gdx.app.log(Bongos_EXE.LOG, "You hit hembra drum at bottom.");
				}
				
				else if(Gdx.input.getX(finger_index) >= (Gdx.graphics.getWidth()/16) * 8 &&
						Gdx.input.getX(finger_index) <= (Gdx.graphics.getWidth()/16) * 13 &&
						Gdx.input.getY(finger_index) >= (Gdx.graphics.getHeight()/16) * 11 &&
						Gdx.input.getY(finger_index) <= (Gdx.graphics.getHeight()/16) * 13)
				{
					Hembra_Hi_SFX.play();
					Gdx.app.log(Bongos_EXE.LOG, "You hit hembra drum at bottom edge.");
				}
			}
		}
	}

	
	
	
	
	
	
	
	
	
	@Override
	public void resize(int width, int height) 
	{
		// TODO Resizing Section
	}

	
	
	
	
	
	
	
	
	
	@Override
	public void show() 
	{
		// TODO Show/Creation Section
		
		//-----[ Screen Setup ]-----
		camera = new OrthographicCamera();
		camera.setToOrtho(false, w, h);
		
		
		
		
		
		//-----[ Sprite Batch Initialization ]-----
		batch = new SpriteBatch();
		
		
		
		
		
		//-----[ Texture Setup ]-----
		Drum_Bongos_IMG = new Texture(Gdx.files.internal("images/drums/bongos_revised.png"));
		Background_IMG = new Texture(Gdx.files.internal("images/background.png"));
		
		
		
		
		
		//-----[ SFX Setup ]-----
		//Macho Drum Sound Physics
		Macho_Lo_SFX = Gdx.audio.newSound(Gdx.files.internal("SFX/drums/Macho_Lo.wav"));
		Macho_Mi_SFX = Gdx.audio.newSound(Gdx.files.internal("SFX/drums/Macho_Mi.wav"));
		Macho_Hi_SFX = Gdx.audio.newSound(Gdx.files.internal("SFX/drums/Macho_Hi.wav"));
		
		//Hembra Drum Sound Physics
		Hembra_Lo_SFX = Gdx.audio.newSound(Gdx.files.internal("SFX/drums/Hembra_Lo.wav"));
		Hembra_Mi_SFX = Gdx.audio.newSound(Gdx.files.internal("SFX/drums/Hembra_Mi.wav"));
		Hembra_Hi_SFX = Gdx.audio.newSound(Gdx.files.internal("SFX/drums/Hembra_Hi.wav"));
		
		
		
		
		
		//-----[ Rectangle Setup ]-----
		Drum_POS = new Rectangle();
		Drum_POS.width = Drum_Bongos_IMG.getWidth();
		Drum_POS.height = Drum_Bongos_IMG.getHeight();
		Drum_POS.x = (w/2) - (Drum_POS.width/2);;
		Drum_POS.y = (h/2) - (Drum_POS.height/2);
		
		Background_POS = new Rectangle();
		Background_POS.width = 1280;
		Background_POS.height = 720;
		Background_POS.x = 0;
		Background_POS.y = 0;
	}

	
	
	
	
	
	
	
	
	
	@Override
	public void hide() 
	{
		// TODO Hide Section
	}

	
	
	
	
	
	
	
	
	
	@Override
	public void pause() 
	{
		// TODO Pause Section
	}

	
	
	
	
	
	
	
	
	
	@Override
	public void resume() 
	{
		// TODO Resume Section
	}

	
	
	
	
	
	
	
	
	
	@Override
	public void dispose() 
	{
		// TODO Dispose Section
	}

}
