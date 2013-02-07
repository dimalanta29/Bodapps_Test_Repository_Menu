package com.Bodapps.Jabongos.Screen;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;

import com.Bodapps.Jabongos.Bongos_EXE;
import com.Bodapps.Jabongos.Animation_Package.Tween_Animation;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Class_2_Title_Screen implements Screen
{

	//------------------------------[ Data Types ]------------------------------
	
	//[Textures]>>>>>
	private Texture Title_IMG;
	private Texture Black_IMG;
	
	//[Orthographic Camera Set]>>>>> (For viewing on screen.)
	private OrthographicCamera camera;
	
	//[Sprite Set]>>>>> (For 2D rendition.)
	private Sprite Black_Sprite;
	
	//[Sprite Batch Set]>>>>> (Enables 2D rendition.)
	private SpriteBatch batch;
	
	//[Rectangle Set]>>>>>
	private Rectangle Title_POS;
	
	//[Tween Manager]>>>>>
	private TweenManager manager;
	
	//[Tween Assistants]>>>>>
	private TweenCallback CB;
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//------------------------------[ Screen Aspect Ratio Settings ]------------------------------
	
	private static final int VIRTUAL_WIDTH = 1280;
    private static final int VIRTUAL_HEIGHT = 720;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//------------------------------[ Passing Game Screen ]------------------------------
	
	Bongos_EXE game; // --> Show_Time.java
	
	public Class_2_Title_Screen(Bongos_EXE game)
	{
		this.game = game;
	}
	

	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	//------------------------------[ Screen Methods ]------------------------------
	
	@Override
	public void render(float delta) 
	{
		// update camera
//        camera.update();
//        camera.apply(Gdx.gl10);
//
//        // set viewport
//        Gdx.gl.glViewport((int) viewport.x, (int) viewport.y, (int) viewport.width, (int) viewport.height);
//        
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		manager.update(delta); // --> Set update to enable animation changes.
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		
			//Must set a batch member in order, like a sandwich! the most top part will be the back end and vice versa.
			batch.draw(Title_IMG, Title_POS.x, Title_POS.y, Title_POS.width, Title_POS.height);
			
			Black_Sprite.draw(batch);
		
		batch.end();
	}

	
	
	
	
	
	
	
	
	
	@Override
	public void resize(int width, int height) 
	{
		// TODO Auto-generated method stub
	}

	
	
	
	
	
	
	
	
	
	@Override
	public void show() 
	{
		// TODO Show
		
		//-----[ Setting Camera ]-----
		camera = new OrthographicCamera();
		camera.setToOrtho(false, VIRTUAL_WIDTH, VIRTUAL_HEIGHT); //--> Sets the screen resolution independently.
		
		
		
		
		
		//-----[ Texture Initialization Setup ]-----
		Title_IMG = new Texture(Gdx.files.internal("images/title/bongochamplogo.png"));
		Black_IMG = new Texture(Gdx.files.internal("data/black.png"));
		
		Title_IMG.setFilter(TextureFilter.Linear , TextureFilter.Linear);
		Black_IMG.setFilter(TextureFilter.Linear , TextureFilter.Linear);
		
		
		
		
		
		//-----[ Rectangle Initialization ]-----
		Title_POS = new Rectangle();
		
		
		
		
		
		//-----[ Sprite Batch Initialization ]-----
		batch = new SpriteBatch();
		
		
		
		
		
		//-----[ Sprite Initialization ]-----
		// --> TODO Black Sprite
		Black_Sprite = new Sprite(Black_IMG);
		Black_Sprite.setColor(0, 0, 0, 0);
		Black_Sprite.setX(0);
		Black_Sprite.setY(0);
		Black_Sprite.setSize(VIRTUAL_WIDTH, VIRTUAL_HEIGHT);
		
		
		
		
		
		//-----[ Animation Settings ]-----
		Tween.registerAccessor(Sprite.class, new Tween_Animation());
		manager = new TweenManager();
		CB = new TweenCallback() 
		{
			@Override
			public void onEvent(int arg0, BaseTween<?> arg1) 
			{
				// TODO onEvent (Tween Callback)
				completed();
			}
		};
		
		// --> TODO Tween Black Sprite
		Tween
		.from(Black_Sprite, Tween_Animation.ALPHA, 0.5f)
		.target(1)
		.ease(TweenEquations.easeInQuad)
		.repeatYoyo(1, 3.0f)
		.setCallback(CB)
		.setCallbackTriggers(TweenCallback.COMPLETE)
		.start(manager);
		
		
		
		
		
		//-----[ Coordinate Setup ]-----
		//Title
		Title_POS.width = 624; 
		Title_POS.height = 312; 
		Title_POS.x = (VIRTUAL_WIDTH/2) - (624/2);
		Title_POS.y = (VIRTUAL_HEIGHT/2) - (312/2);
	}

	
	
	
	
	
	
	
	
	
	@Override
	public void hide() 
	{
		// TODO Auto-generated method stub
	}

	
	
	
	
	
	
	
	
	
	@Override
	public void pause() 
	{
		// TODO Auto-generated method stub
	}

	
	
	
	
	
	
	
	
	
	@Override
	public void resume() 
	{
		// TODO Auto-generated method stub
	}

	
	
	
	
	
	
	
	
	
	@Override
	public void dispose() 
	{
		// TODO Auto-generated method stub
		Title_IMG.dispose();
		Black_IMG.dispose();
		batch.dispose();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//------------------------------[ TODO: Methods for Callbacks ]------------------------------
	
	private void completed()
	{
		game.setScreen(new Tap_Drum_Screen(game));
	}

}
