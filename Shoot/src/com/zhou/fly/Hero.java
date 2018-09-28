package com.zhou.fly;
import java.awt.image.BufferedImage;

/**
 * 飞机
 */
public class Hero extends FlyingObject{
	
	private BufferedImage[] images = {};  //飞机图片数组
	private int index = 0;                //Ӣ�ۻ�ͼƬ�л�����
	
	private int doubleFire;   //是否双倍火力
	private int life;   //生命值
	
	/** 飞机初始化 */
	public Hero(){
		life = 3;   //初始为3
		doubleFire = 0;   //默认为0
		images = new BufferedImage[]{ShootGame.hero0, ShootGame.hero1};
		image = ShootGame.hero0;   //默认状态0
		width = image.getWidth();
		height = image.getHeight();
		x = 150;
		y = 400;
	}
	

	public int isDoubleFire() {
		return doubleFire;
	}


	public void setDoubleFire(int doubleFire) {
		this.doubleFire = doubleFire;
	}
	

	public void addDoubleFire(){
		doubleFire = 40;
	}
	

	public void addLife(){  //����
		life++;
	}
	

	public void subtractLife(){   //����
		life--;
	}
	

	public int getLife(){
		return life;
	}
	
	/** 移动  */
	public void moveTo(int x,int y){   
		this.x = x - width/2;
		this.y = y - height/2;
	}

	/** 超出边界 */
	@Override
	public boolean outOfBounds() {
		return false;  
	}


	public Bullet[] shoot(){   
		int xStep = width/4;
		int yStep = 20;
		if(doubleFire>0){
			Bullet[] bullets = new Bullet[2];
			bullets[0] = new Bullet(x+xStep,y-yStep);
			bullets[1] = new Bullet(x+3*xStep,y-yStep);
			return bullets;
		}else{
			Bullet[] bullets = new Bullet[1];
			bullets[0] = new Bullet(x+2*xStep,y-yStep);  
			return bullets;
		}
	}


	@Override
	public void step() {
		if(images.length>0){
			image = images[index++/10%images.length];  //�л�ͼƬhero0��hero1
		}
	}
	

	public boolean hit(FlyingObject other){
		
		int x1 = other.x - this.width/2; 
		int x2 = other.x + this.width/2 + other.width;
		int y1 = other.y - this.height/2;
		int y2 = other.y + this.height/2 + other.height;
	
		int herox = this.x + this.width/2;
		int heroy = this.y + this.height/2;
		
		return herox>x1 && herox<x2 && heroy>y1 && heroy<y2;
	}
	
}










