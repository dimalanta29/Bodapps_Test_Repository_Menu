package com.bodapps.spinwithbuddies.Game_Screen;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.bodapps.spinwithbuddies.Start;
import com.bodapps.spinwithbuddies.Controls.Adjustment;
import com.bodapps.spinwithbuddies.Controls.Basic_Gesture_Detector;
import com.bodapps.spinwithbuddies.Controls.Camera_View;
import com.bodapps.spinwithbuddies.Controls.Sprite_Setup;
import com.bodapps.spinwithbuddies.Controls.Basic_Gesture_Detector.Direction_Listener;
import com.bodapps.spinwithbuddies.Model.Images;
import com.bodapps.spinwithbuddies.Model.SFX;
import com.bodapps.spinwithbuddies.Sprite_Batch.Sprite_Batch;

public class Game_App_Screen implements Screen
{
	//TODO __________[ Screen Connector ]__________
	public Start game;
	
	public Game_App_Screen(Start game)
	{
		this.game = game;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//TODO __________[ Field Data ]__________
	//-----[ Randomizer ]-----
	private Random rnd = new Random();
	
	
	
	//-----[ String Values ]-----
	private String gesture = "?";
	
	
	
	//-----[ Font ]-----
	private BitmapFont font;
	
	
	
	//-----[ Boolean values ]-----
	private boolean camera_Y_down = false; // --> Sets the Cartesian coordinate system upward or downward.
	private boolean random_spin = false;
	private boolean flinging = false;
	private boolean clockwise = false;
	private boolean counter_clockwise = false;
	private boolean debug_HUD_mode = false; // --> For testing purposes only.
		
		
		
	//-----[ Float Values ]-----
	private float red = 0;
	private float blue = 0;
	private float green = 0;
	private float alpha = 1;
	private float spin_speed = 15;
	private float rotate = 0;
	private float vw; // --> Used of rearrange touch point coordinates if the aspect ration changes have occurred. This value however is optional.
	private float vh; // --> Used of rearrange touch point coordinates if the aspect ration changes have occurred. This focused on spacer.
	
	
	
	//-----[ Integer Values ]-----
	private int width = 900; // --> Camera's Screen Width
	private int height = 1280; // --> Camera's Screen Height
	private int cam_index = 0;
	private int sfx_timer = 0;
	private int sfx_timer_2 = 0;
	private int intro_timer = 0;
	
	
	
	//-----[ Controls ]-----
	private Camera_View view;
	private Sprite_Batch batch;
	private Adjustment adjust;
	private Sprite_Setup sprite;
	private Images img;
	private Basic_Gesture_Detector detect;
	private Basic_Gesture_Detector.Direction_Listener direction;
	private SFX sfx;

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//TODO __________[ Methods for Screen Interface ]__________
	@Override
	public void render(float delta) 
	{
		//-----[ Camera Update ]-----
		view.Update_Aspect_Screen_Ratio();
		
		
		
		//-----[ GL Setup ]-----
		Gdx.gl10.glClearColor(red, green, blue, alpha);
		Gdx.gl10.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		
		
		//-----[ Intro Timer ]-----
		if(intro_timer != 1700)
		{
			if(intro_timer == 1650)
			{
				sfx.crowd.play(1.0f, 1.04f, 0);
			}
			
			intro_timer += 50;
		}
		
		
		
		//-----[ Batch Setup ]-----
		batch.main_batch.setProjectionMatrix(view.cam_1.combined);
		batch.main_batch.begin();
		
			sprite.colored.draw(batch.main_batch);

			if(debug_HUD_mode) // --> For testing purposes only.
			{
				font.setColor(1, 1, 1, 1);
				font.setScale(2.6f);
				font.draw(batch.main_batch, "Starting Angle: " + (int) rotate + "°", 10, (1280/16)*2);
				font.draw(batch.main_batch, "Speed: " + (int) spin_speed + "dps", 10, (1280/16)*1);
				font.setScale(2.2f);
				font.draw(batch.main_batch, " Tap here", (900/10)*7 + 30, (1280/16)*3 - 97);
				font.draw(batch.main_batch, "   for", (900/10)*7 + 40, (1280/16)*2 - 48);
				font.draw(batch.main_batch, "AUTO SPIN", (900/10)*7 + 18, (1280/16)*1);
				font.setScale(2.2f);
				font.draw(batch.main_batch, "BLUE --> Can tap to random spin", 10, (1280/16)*16);
				font.draw(batch.main_batch, "GREEN --> If you drag it.", 10, (1280/16)*15);
				font.draw(batch.main_batch, "GESTURE --> " + gesture, 10, (1280/16)*14);
				
			} else{
				
				batch.main_batch.draw(img.background[0], adjust.bg.x, adjust.bg.y, adjust.bg.width, adjust.bg.height);
				batch.main_batch.draw(img.spin, adjust.spin.x - 20, adjust.spin.y + 20, adjust.spin.width, adjust.spin.height);
				
			}
			
			sprite.bottle.draw(batch.main_batch);
		
		batch.main_batch.end();
		
		
		
		//-----[ Set Touch Method ]-----
		Bottle_Controls();
	}
	
	
	
	

	
	
	@Override
	public void resize(int width, int height) 
	{
		// Calculate new viewport.
		float adjust_screen = ((float)width / (float)height);
		float scale = 1.0f;
		Vector2 crop = new Vector2(0.0f, 0.0f);
		
		// Check for changes.
		if(adjust_screen > view.ASPECT_RATIO)
		{
			
			scale = ((float)height) / ((float)view.VIRTUAL_HEIGHT);
			crop.x = 0;
			
		} else if(adjust_screen < view.ASPECT_RATIO){
			
			scale = ((float)width) / ((float)view.VIRTUAL_WIDTH);
			crop.y =  0;
			
		} else{
			
			scale = (float)width / (float)view.VIRTUAL_WIDTH;
			
		}
		
		// Set new changes for the screen ratio.
		float w = (float)view.VIRTUAL_WIDTH*scale;
		float h = (float)view.VIRTUAL_HEIGHT*scale;
		
		// Set final changes for the screen view coordinates.
		crop.y = Gdx.graphics.getHeight() - h; // --> Set always on top.
		crop.x = (Gdx.graphics.getWidth()/2) - (w/2);
		
		// Reaarange touch area coordinates.
		vh = h;
		vw = w;
		
		view.Set_Viewport_Change(crop, w, h);
	}
	
	
	
	

	
	
	@Override
	public void show() 
	{
		//-----[ Control Setup ]-----
		view = new Camera_View(width, height, camera_Y_down, cam_index);
		batch = new Sprite_Batch();
		adjust = new Adjustment();
		img = new Images();
		sprite = new Sprite_Setup(img, adjust);
		font = new BitmapFont();sfx = new SFX();
		
		
		
		//-----[ Input Processor Setup ]-----
		Gdx.input.setInputProcessor(new Basic_Gesture_Detector(new Direction_Listener() {
			
			@Override
			public void Up() 
			{
				if((rotate > -180) && (rotate < 0))
				{
					gesture = "Up - Counter Clockwise";
					spin_speed = 10.0f;
					counter_clockwise = true;
					flinging = true;
					
				} else if((rotate < 180) && (rotate > 0)){
					
					gesture = "Up - Clockwise";
					spin_speed = -10.0f;
					clockwise = true;
					flinging = true;
					
				}
			}
			
			@Override
			public void Right() 
			{
				if((rotate > 90) || ((rotate > -180) && (rotate < -90)))
				{
					gesture = "Right - Counter Clockwise";
					spin_speed = 10.0f;
					counter_clockwise = true;
					flinging = true;
					
				} else if(rotate < 90){
					
					gesture = "Right - Clockwise";
					spin_speed = -10.0f;
					clockwise = true;
					flinging = true;
					
				}
			}
			
			@Override
			public void Left() 
			{
				if(((rotate > 0) && (rotate < 90)) || ((rotate > -90) && (rotate < 0)))
				{
					gesture = "Left - Counter Clockwise";
					spin_speed = 10.0f;
					counter_clockwise = true;
					flinging = true;
					
				} else if(((rotate > 90) || (rotate < 180)) || ((rotate > -180) && (rotate < -90))){
					
					gesture = "Left - Clockwise";
					spin_speed = -10.0f;
					clockwise = true;
					flinging = true;
					
				}
			}
			
			@Override
			public void Down() 
			{
				if((rotate > -180) && (rotate < 0))
				{
					gesture = "Down - Clockwise";
					spin_speed = -10.0f;
					clockwise = true;
					flinging = true;
					
				} else if((rotate < 180) && (rotate > 0)){
					
					gesture = "Down - Counter Clockwise";
					spin_speed = 10.0f;
					counter_clockwise = true;
					flinging = true;
					
				}
			}
			
		}));
		
		
		
		//-----[ Advertisement Setup ]-----
		game.ads.show_ads(true);
	}
	
	
	
	

	
	
	@Override
	public void hide() 
	{
		
	}
	
	
	
	

	
	
	@Override
	public void pause() 
	{
		
	}
	
	
	
	

	
	
	@Override
	public void resume() 
	{
		
	}
	
	
	
	

	
	
	@Override
	public void dispose() 
	{
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//TODO __________[ Other Methods ]__________
	public void Bottle_Controls()
	{
		//-----[ Angle Settings ]-----
		if(Gdx.input.isTouched() && !(flinging))
		{
			rotate = (float) -(Math.atan2((Gdx.input.getX()/2)-(sprite.bottle.getX()/2), -(Gdx.input.getY()-sprite.bottle.getY())) * 180.0d/Math.PI); // --> Capture the angle.
			sprite.bottle.setRotation(rotate); // --> Rotation speed
			sprite.bottle.setOrigin(155, (1280/2) - (adjust.bottle.height/2)); // --> Physic frame alignment point for the spinning bottle.
			
			sfx_timer_2 += 50;
			
			if(sfx_timer_2 == 1500)
			{
				sfx.bottle.play(0.5f, 0.65f, 0); // --> Play bottle SFX.
			}
			
		} else{
			
			sfx_timer_2 = 0;
			
		}
		
		
		
		//-----[ Random Spin Settings ]-----
		if(((Gdx.input.justTouched() &&
				(Gdx.input.getX() <= (Gdx.graphics.getWidth()/10) * 6) &&
				(Gdx.input.getX() >= (Gdx.graphics.getWidth()/10) * 4) &&
				(Gdx.input.getY() <= (vh/16) * 11) &&
				(Gdx.input.getY() >= (vh/16) * 6)) || 
				
				(Gdx.input.justTouched() &&
				(Gdx.input.getX() <= (Gdx.graphics.getWidth()/10) * 10) &&
				(Gdx.input.getX() >= (Gdx.graphics.getWidth()/10) * 8) &&
				(Gdx.input.getY() <= (vh/16) * 16) &&
				(Gdx.input.getY() >= (vh/16) * 14))) &&
				
				!(random_spin))
		{
			if(debug_HUD_mode) sprite.bottle.setColor(1, 0, 0, 1);
			spin_speed = -(rnd.nextInt(15 - 10) + 10);
			random_spin = true;
		}
		
		if(random_spin)
		{
			sprite.bottle.rotate(spin_speed); // Rotation speed
			sprite.bottle.setOrigin(155, (1280/2) - (adjust.bottle.height/2)); // Physic frame alignment point for the spinning bottle.
			spin_speed += 0.05f;
			sfx_timer += 50;
			
			if(sfx_timer == 2000) // --> Repeat time for playing bottle's sfx.
			{
				if((spin_speed <= -10) || (spin_speed >= -10))
				{
					if(spin_speed >= -8)
					{
						if(spin_speed >= -5)
						{
							if(spin_speed >= -3)
							{
								sfx.bottle.play(0.01f, 0.40f, 0);
								
							} else{
								
								sfx.bottle.play(0.1f, 0.64f, 0);
								
							}
							
						} else{
							
							sfx.bottle.play(0.5f, 0.70f, 0);
							
						}
						
					} else{
						
						sfx.bottle.play(0.9f, 1.00f, 0);
						
					}
				}
				
				sfx_timer = 0;
			}
			
			if(spin_speed >= 0)
			{
				if(debug_HUD_mode) sprite.bottle.setColor(0, 0, 1, 1);
				random_spin = false;
			}
			
		}
		
		
		
		//-----[ Flinging Settings ]-----
		if(flinging)
		{
			if(debug_HUD_mode) sprite.bottle.setColor(1, 0, 0, 1);
			
			if(counter_clockwise)
			{
				sprite.bottle.rotate(spin_speed); // Rotation speed
				sprite.bottle.setOrigin(155, (1280/2) - (adjust.bottle.height/2)); // Physic frame alignment point for the spinning bottle.
				spin_speed -= 0.05;
				sfx_timer += 50;
				
				if(sfx_timer == 2000)
				{
					if((spin_speed <= 10) || (spin_speed >= 10))
					{
						if(spin_speed <= 8)
						{
							if(spin_speed <= 5)
							{
								if(spin_speed <= 3)
								{
									sfx.bottle.play(0.01f, 0.40f, 0);
									
								} else{
									
									sfx.bottle.play(0.1f, 0.64f, 0);
									
								}
								
							} else{
								
								sfx.bottle.play(0.5f, 0.70f, 0);
								
							}
							
						} else{
							
							sfx.bottle.play(0.9f, 1.00f, 0);
							
						}
					}
					
					sfx_timer = 0;
				}
				
				if(spin_speed <= 0)
				{
					if(debug_HUD_mode) sprite.bottle.setColor(0, 0, 1, 1);
					clockwise = false;
					counter_clockwise = false;
					flinging = false;
				}
				
			} else if(clockwise){
				
				sprite.bottle.rotate(spin_speed); // Rotation speed
				sprite.bottle.setOrigin(155, (1280/2) - (adjust.bottle.height/2)); // Physic frame alignment point for the spinning bottle.
				spin_speed += 0.05;
				sfx_timer += 50;
				
				if(sfx_timer == 2000)
				{
					if((spin_speed <= -10) || (spin_speed >= -10))
					{
						if(spin_speed >= -8)
						{
							if(spin_speed >= -5)
							{
								if(spin_speed >= -3)
								{
									sfx.bottle.play(0.01f, 0.40f, 0);
									
								} else{
									
									sfx.bottle.play(0.1f, 0.64f, 0);
									
								}
								
							} else{
								
								sfx.bottle.play(0.5f, 0.70f, 0);
								
							}
							
						} else{
							
							sfx.bottle.play(0.9f, 1.00f, 0);
							
						}
					}
					
					sfx_timer = 0;
				}
				
				if(spin_speed >= 0)
				{
					if(debug_HUD_mode) sprite.bottle.setColor(0, 0, 1, 1);
					clockwise = false;
					counter_clockwise = false;
					flinging = false;
				}
				
			}
			
		}
	}
}
