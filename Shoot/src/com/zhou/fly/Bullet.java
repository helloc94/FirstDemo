package com.zhou.fly;

/**
 * �ӵ���:�Ƿ�����
 */
public class Bullet extends FlyingObject {
	private int speed = 10;  //�ƶ����ٶ�
	
	/** ��ʼ�����? */
	public Bullet(int x,int y){
		this.x = x;
		this.y = y;
		this.image = ShootGame.bullet;
	}

	/** �ƶ� */
	@Override
	public void step(){   
		y-=speed;
	}

	/** Խ�紦�� */
	@Override
	public boolean outOfBounds() {
		return y<-height;
	}

}
