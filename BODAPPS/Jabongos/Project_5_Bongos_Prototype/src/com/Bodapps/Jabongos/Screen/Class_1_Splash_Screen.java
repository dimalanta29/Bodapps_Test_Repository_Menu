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
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Class_1_Splash_Screen implements Screen
{

	//------------------------------[ TODO: Data Types and Objects ]------------------------------
	
	//[Textures]>>>>>
	private Texture Logo_IMG;
	
	//[Orthographic Camera Set]>>>>> (For viewing on screen.)
	private OrthographicCamera camera;
	
	//[Sprite Set]>>>>> (For 2D rendition.)
	private Sprite Splash_Sprite;
	
	//[Sprite Batch Set]>>>>> (Enables 2D rendition.)
	private SpriteBatch batch;
	
	//[Rectangle Set]>>>>>
	private Rectangle center_position;
	
	//[Tween Manager]>>>>>
	private TweenManager manager;
	
	//[Integer Data Type]>>>>>
	private int h = 720;
	private int w = 1280;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//------------------------------[ TODO: Passing Game Screen ]------------------------------
	
	Bongos_EXE game; // -->Bongos_EXE.java
	
	public Class_1_Splash_Screen(Bongos_EXE game)
	{
		this.game = game;
	}
	

	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	//------------------------------[ TODO: Screen Methods ]------------------------------
	
	@Override
	public void render(float delta) 
	{
		// --> TODO Render
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		manager.update(delta); // --> Set update to enable animation changes.
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		
			Splash_Sprite.draw(batch);
		
		batch.end();
	}

	
	
	
	
	
	
	
	
	
	@Override
	public void resize(int width, int height) 
	{
		// --> TODO Resize
	}

	
	
	
	
	
	
	
	
	
	@Override
	public void show() 
	{
		// --> TODO Show
		
		//-----[ Setting Camera ]-----
		//Texture.setEnforcePotImages(true);
		camera = new OrthographicCamera();
		camera.setToOrtho(false, w, h); // --> Sets the screen resolution independently.
		
		
		
		
		
		//-----[ Texture Initialization Setup ]-----
		Logo_IMG = new Texture(Gdx.files.internal("data/bodapps_logo_2.png"));
		Logo_IMG.setFilter(TextureFilter.Linear , TextureFilter.Linear);
		
		
		
		
		
		//-----[ Rectangle Initialization ]-----
		center_position = new Rectangle();
		
		
		
		
		
		//-----[ Sprite Batch Initialization ]-----
		batch = new SpriteBatch();
		
		
		
		
		
		//-----[ Sprite Initialization ]-----
		Splash_Sprite = new Sprite(Logo_IMG);
		Splash_Sprite.setColor(1, 1, 1, 0);
		Splash_Sprite.setX((w/2) - (800/2));
		Splash_Sprite.setY((h/2) - (203/2));
		Splash_Sprite.setSize(800, 203);
		
		
		
		
		
		//-----[ Animation Settings ]-----
		Tween.registerAccessor(Sprite.class, new Tween_Animation());
		manager = new TweenManager();
		TweenCallback CB = new TweenCallback() 
		{
			@Override
			public void onEvent(int arg0, BaseTween<?> arg1) 
			{
				// TODO onEvent (Tween Callback)
				completed();
			}
		};
		Tween
			.to(Splash_Sprite, Tween_Animation.ALPHA, 1f)
			.target(1)
			.ease(TweenEquations.easeInQuad)
			.repeatYoyo(1, 2.5f)
			.setCallback(CB)
			.setCallbackTriggers(TweenCallback.COMPLETE)
			.start(manager);
	}

	
	
	
	
	
	
	
	
	
	@Override
	public void hide() 
	{
		// --> TODO Hide
	}

	
	
	
	
	
	
	
	
	
	@Override
	public void pause() 
	{
		// --> TODO Pause
	}

	
	
	
	
	
	
	
	
	
	@Override
	public void resume() 
	{
		// --> TODO Resume
	}

	
	
	
	
	
	
	
	
	
	@Override
	public void dispose() 
	{
		// --> TODO Dispose
		batch.dispose();
		Logo_IMG.dispose();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//------------------------------[ TODO: Methods for Callbacks ]------------------------------
	
	private void completed()
	{
		game.setScreen(new Class_2_Title_Screen(game));
	}

}
