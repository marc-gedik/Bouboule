package game.objects;

import game.Direction;
import game.physics.Body;

import java.awt.image.BufferedImage;

import utils.AssetsManager;

public class Bullet extends Dynamic {

	private int direction;
	private int dist;
	
	public Bullet(Body body, int dir, int dist) {
		super(body, 15);
		this.direction = determineDirection(dir);
		this.dist = dist;
		BufferedImage img = AssetsManager.getTexture("bullet");
		setAnimation(img, 0 / 12f);
	}

	public int determineDirection(int angle) {
		int direction = Direction.None;

		if (angle == 0)
			direction = Direction.North;
		else if (angle == 90)
			direction = Direction.East;
		else if (angle == 45)
			direction = Direction.East + Direction.North;
		else if (angle == 180)
			direction = Direction.South;
		else if (angle == 135)
			direction = Direction.East + Direction.South;
		else if (angle == -90)
			direction = Direction.West;
		else if (angle == -45)
			direction = Direction.North + Direction.West;
		else if (angle == -180)
			direction = Direction.South;
		else if (angle == -135)
			direction = Direction.South + Direction.West;
		return direction;
	}

	@Override
	public void move(int dir) {
		super.move(dir);
		
	}
	
	@Override
	public void update(float dt) {
		super.update(dt);
		move(direction);
	}
}