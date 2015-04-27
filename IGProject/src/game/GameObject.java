package game;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import ui.game.Animation;

public abstract class GameObject {

	private Animation animation;
	protected Body body;
	protected double angle;

	public GameObject(Body body) {
		this.body = body;
	}

	protected void setAnimation(BufferedImage reg, float delay) {
		setAnimation(new BufferedImage[] { reg }, delay);
	}
	
	protected void setAnimation(BufferedImage[] reg, float delay) {
		animation = new Animation(reg, delay);
	}
	
	public int getX() {
		return body.getX();
	}

	public int getY() {
		return body.getY();
	}

	public Animation getAnimation() {
		return animation;
	}

	public void update(float dt){
		animation.update(dt);
	}

	public double getAngle() {
		return angle;
	}
	
	public Rectangle bounds(){
		return body.bounds();
	}
}
