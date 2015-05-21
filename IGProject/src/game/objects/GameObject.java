package game.objects;

import game.physics.Body;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import ui.game.Animation;

public abstract class GameObject {

	public Body body;
	protected int angle;

	public GameObject(Body body) {
		this.body = body;
	}

	public int getX() {
		return body.getX();
	}

	public int getY() {
		return body.getY();
	}

	public int getAngle() {
		return angle;
	}
	
	public Rectangle bounds(){
		return body.bounds();
	}
}
