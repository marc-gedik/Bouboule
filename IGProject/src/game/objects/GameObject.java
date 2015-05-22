package game.objects;

import game.physics.Body;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Rectangle2D.Float;
import java.awt.image.BufferedImage;

import ui.game.Animation;

public abstract class GameObject {

	public Body body;
	protected float angle;

	public GameObject(Body body) {
		this.body = body;
	}

	public float getX() {
		return body.getX();
	}

	public float getY() {
		return body.getY();
	}

	public float getAngle() {
		return angle;
	}
	
	public Shape bounds(){
		return body.shape();
	}
}
