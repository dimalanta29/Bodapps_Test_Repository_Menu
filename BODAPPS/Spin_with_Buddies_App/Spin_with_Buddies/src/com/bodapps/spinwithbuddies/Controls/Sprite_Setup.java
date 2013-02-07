package com.bodapps.spinwithbuddies.Controls;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.bodapps.spinwithbuddies.Model.Images;

public class Sprite_Setup 
{
	//TODO __________[ Field Data ]__________
	public Sprite colored;
	public Sprite bottle;
	public Sprite black;
	public Sprite black_2;
	
	
	
	
	
	//TODO __________[ Sprite Setup's Constructor ]__________
	public Sprite_Setup(Images img, Adjustment adjust)
	{
		colored = new Sprite(img.shadow);
		colored.setBounds(0, 0, 900, 1280);
		colored.setColor(0.45f, 0, 0.75f, 1);
		
		bottle = new Sprite(img.bottle);
		bottle.setBounds(adjust.bottle.x, adjust.bottle.y, adjust.bottle.width, adjust.bottle.height);
		bottle.setColor(1, 1, 1, 1);
		bottle.setOrigin(adjust.bottle.x, adjust.bottle.y);
		bottle.setRotation(0);
		
		black = new Sprite(img.black);
		black.setBounds(adjust.black.x, adjust.black.y, adjust.black.width, adjust.black.height);
		black.setColor(0, 0, 0, 0);
		
		black_2 = new Sprite(img.black);
		black_2.setBounds(adjust.black_2.x, adjust.black_2.y, adjust.black_2.width, adjust.black_2.height);
		black_2.setColor(0, 0, 0, 0);
	}
}
