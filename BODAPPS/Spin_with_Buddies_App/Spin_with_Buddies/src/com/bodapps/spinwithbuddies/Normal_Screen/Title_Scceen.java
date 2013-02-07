package com.bodapps.spinwithbuddies.Normal_Screen;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.bodapps.spinwithbuddies.Start;
import com.bodapps.spinwithbuddies.Controls.Adjustment;
import com.bodapps.spinwithbuddies.Controls.Basic_Gesture_Detector;
import com.bodapps.spinwithbuddies.Controls.Camera_View;
import com.bodapps.spinwithbuddies.Controls.Fade;
import com.bodapps.spinwithbuddies.Controls.Sprite_Setup;
import com.bodapps.spinwithbuddies.Controls.Basic_Gesture_Detector.Direction_Listener;
import com.bodapps.spinwithbuddies.Model.Images;
import com.bodapps.spinwithbuddies.Model.SFX;
import com.bodapps.spinwithbuddies.Sprite_Batch.Sprite_Batch;

public class Title_Scceen implements Screen, InputProcessor
{
	//TODO __________[ Screen Connector ]__________
	public Start game;
	
	public Title_Scceen(Start game)
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
	private boolean fade_out = true; // --> For testing purposes only.
		
		
		
	//-----[ Float Values ]-----
	private float red = 0;
	private float blue = 0;
	private float green = 0;
	private float alpha = 1;
	private float spin_speed = 15;
	private float sound_fade = 0;
	private float rotate = 0;
	private float vw; // --> Used of rearrange touch point coordinates if the aspect ration changes have occurred. This value however is optional.
	private float vh; // --> Used of rearrange touch point coordinates if the aspect ration changes have occurred. This focused on spacer.
	
	
	
	//-----[ Integer Values ]-----
	private int width = 900; // --> Camera's Screen Width
	private int height = 1280; // --> Camera's Screen Height
	private int cam_index = 0;
	private int sfx_timer = 0;
	
	
	
	//-----[ Controls ]-----
	private Camera_View view;
	private Sprite_Batch batch;
	private Adjustment adjust;
	private Sprite_Setup sprite;
	private Images img;
	private SFX sfx;
	private Fade fade;

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//TODO __________[ Methods for Screen Interface ]__________
	@Override
	public void render(float delta) 
	{
		//-----[ Camera Update ]-----
		view.Update_Aspect_Screen_Ratio();
		
		
		
		//-----[ Fade Animation Update ]-----
		fade.Animation_Update(delta);
		
		
		
		//-----[ GL Setup ]-----
		Gdx.gl10.glClearColor(red, green, blue, alpha);
		Gdx.gl10.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		
		
		//-----[ Batch Setup ]-----
		batch.title_screen_batch.setProjectionMatrix(view.cam_1.combined);
		batch.title_screen_batch.begin();
		
			batch.title_screen_batch.draw(img.bodapps, adjust.bodapps.x, adjust.bodapps.y - 90, adjust.bodapps.width, adjust.bodapps.height);
			batch.title_screen_batch.draw(img.game_logo, adjust.game_logo.x, adjust.game_logo.y, adjust.game_logo.width, adjust.game_logo.height);

			font.setColor(1, 1, 1, 1);
			font.setScale(2.2f);
			font.draw(batch.title_screen_batch, "T A P   t o   S T A R T", (900/10)*3 + 25, (1280/16)*1);
			
			sprite.black_2.draw(batch.title_screen_batch);
			sprite.black.draw(batch.title_screen_batch);
		
		batch.title_screen_batch.end();
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
		fade = new Fade(game);
		
		
		
		//-----[ Fade Animation Setup ]-----
		fade.Play_without_Switching_Screen(sprite.black, 0, 6.3f, 0);
		fade.Play_without_Switching_Screen(sprite.black_2, 99999999, 0.81f, 1);
		
		
		
		//-----[ Input Processor Setup ]-----
		Gdx.input.setInputProcessor(this);
		
		
		
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








	
	
	

	
	

	
	
	

	
	
	//TODO __________[ Methods for Input Processor ]__________
	@Override
	public boolean keyDown(int keycode) {
		return false;
	}







	@Override
	public boolean keyUp(int keycode) {
		return false;
	}







	@Override
	public boolean keyTyped(char character) {
		return false;
	}







	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}







	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) 
	{
		sfx.jackpot.play(1.0f, 1.04f, 0);
		fade.Screen_Index(2);
		fade.Play_2(sprite.black, 0, 1.3f, 0);
		return true;
	}







	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}







	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}







	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}
