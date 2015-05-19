package game.objects;

import game.Direction;
import game.physics.Body;

import java.awt.image.BufferedImage;
import java.util.Random;

import utils.AssetsManager;
import utils.MathUtils;

public class EnemyV3 extends Enemy {

	private int lastX = 0, lastY = 0, lastDIR = 0;
	private int cpt = 0;
	private int sizeBypass = 50;
	private boolean flag = true;
	private int dir = Direction.None;

	public EnemyV3(Body body) {
		super(body, 3);
		BufferedImage[] img = AssetsManager.getSprites("enemy_v3", 4);
		setAnimation(img, 1000 / 12f);
		life = 200;
	}

	@Override
	public void strategicMove(Character character) {
		int dist = MathUtils.dist2(character.getX(), body.getX(),
				character.getY(), body.getY());
		int distMax = 20 * 20;

		if (body.getX() == lastX && body.getY() == lastY && dist > distMax) {
			dir = bypass(lastDIR);
			flag = false;
		}

		if (flag)
			dir = determineDirection(character);
		else {
			cpt++;
			if (cpt == sizeBypass) {
				flag = true;
				cpt = 0;
			}

		}

		lastX = body.getX();
		lastY = body.getY();
		lastDIR = dir;
		this.move(dir);

	}

	@Override
	public int determineDirection(Character character) {
		int xC = character.getX();
		int yC = character.getY();
		int xE = this.getX();
		int yE = this.getY();
		int direction = Direction.None;

		if (yC > yE)
			direction += Direction.South;
		else if (yC < yE)
			direction += Direction.North;
		if (xC > xE)
			direction += Direction.East;
		if (xC < xE)
			direction += Direction.West;
		return direction;
	}

	public int turnRight(int d) {

		switch (d) {
		case Direction.North:
			return Direction.NWest;
		case Direction.NWest:
			return Direction.West;
		case Direction.West:
			return Direction.SWest;
		case Direction.SWest:
			return Direction.South;
		case Direction.South:
			return Direction.SEast;
		case Direction.SEast:
			return Direction.East;
		case Direction.East:
			return Direction.NEast;
		case Direction.NEast:
			return Direction.North;
		default:
			return Direction.None;
		}
	}

	public int bypass(int lastDIR) {
		int direction = turnRight(lastDIR);
		return direction;
	}

	@Override
	public void specialPower(Character character) {
		character.hit(15);
	}

}
