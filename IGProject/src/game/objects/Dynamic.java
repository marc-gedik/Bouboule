package game.objects;

import java.awt.image.BufferedImage;

import ui.game.Animation;
import game.Direction;
import game.physics.Body;


public abstract class Dynamic extends GameObject {
	private Animation animation;

	protected int idSprite = 0;

	protected float speed;

	public Dynamic(Body body, float speed) {
		super(body);
		this.speed = speed;
	}

	public void move(int dir) {
		int x = 0, y = 0;

		if ((dir & Direction.North) == Direction.North)
			y -= speed;
		if ((dir & Direction.South) == Direction.South)
			y += speed;
		if ((dir & Direction.East) == Direction.East)
			x += speed;
		if ((dir & Direction.West) == Direction.West)
			x -= speed;

		if (y < 0) {
			if (x < 0)
				angle = -45;
			else if (x == 0)
				angle = 0;
			else if (x > 0)
				angle = 45;
		} else if (y == 0) {
			if (x < 0)
				angle = -90;
			else if (x > 0)
				angle = 90;
		} else if (y > 0) {
			if (x < 0)
				angle = -135;
			else if (x == 0)
				angle = 180;
			else if (x > 0)
				angle = 135;
		}
		body.applyForce(x, y);
	}
	
	void move(double angle){
		double w = Math.toRadians(angle);
		double x = Math.cos(w);
		double y = Math.sin(w);
		
		body.applyForce(x, y);
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
