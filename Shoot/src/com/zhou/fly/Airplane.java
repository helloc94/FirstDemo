package com.zhou.fly;

import java.util.Random;

/**
 * 敌机类
 */
public class Airplane extends FlyingObject implements Enemy {
	private int speed = 4;
	

	public Airplane(){
		this.image = ShootGame.airplane;
		width = image.getWidth();
		height = image.getHeight();
		y = -height;          
		Random rand = new Random();
		x = rand.nextInt(ShootGame.WIDTH - width);
	}
	

	@Override
	public int getScore() {  
		return 5;
	}


	@Override
	public 	boolean outOfBounds() {   
		return y>ShootGame.HEIGHT;
	}


	@Override
	public void step() {   
		y += speed;
	}

}

