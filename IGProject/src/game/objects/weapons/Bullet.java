package game.objects.weapons;

import game.objects.Dynamic;
import game.physics.Body;

import java.awt.image.BufferedImage;

import utils.AssetsManager;

public class Bullet extends Dynamic {

	private float maxDist;
	private float dist;
	
	public Bullet(Body body, float angle, float dist, float speed) {
		super(body, speed);
		this.angle = angle;
		this.maxDist = dist;
		
		BufferedImage img = AssetsManager.getTexture("bullet");
		setAnimation(img, 0 / 12f);
	}

	@Override
	public void move(float angle) {
		super.move(angle);
		dist += speed;
	}

	public boolean remove(){
		return dist > maxDist;
	}
	
	@Override
	public void update(float dt) {
		super.update(dt);
		move(angle);
	}
}