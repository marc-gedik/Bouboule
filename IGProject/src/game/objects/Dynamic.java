package game.objects;

import game.physics.Body;

import java.awt.image.BufferedImage;

import ui.game.Animation;


public abstract class Dynamic extends GameObject {
	private Animation animation;

	protected float speed;

	public Dynamic(Body body, float speed) {
		super(body);
		this.speed = speed;
	}

	public void move(float angle) {
		body.applyForce(angle, speed);
	}

	protected void setAnimation(BufferedImage reg, float delay) {
		setAnimation(new BufferedImage[] { reg }, delay);
	}
	
	protected void setAnimation(BufferedImage[] reg, float delay) {
		animation = new Animation(reg, delay);
	}

	public Animation getAnimation() {
		return animation;
	}

	public void update(float dt){
		animation.update(dt);
	}

}
