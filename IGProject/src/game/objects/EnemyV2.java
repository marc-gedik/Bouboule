package game.objects;

import game.Direction;
import game.physics.Body;

import java.awt.image.BufferedImage;
import java.util.Random;

import utils.AssetsManager;

public class EnemyV2 extends Enemy {

	private int dir = Direction.None;
	private int flag = 1000;
	private int changeDirection = 1000;
	private int lastX = 0, lastY = 0;

	
	public EnemyV2(Body body) {
		super(body, 2);
		BufferedImage[] img = AssetsManager.getSprites("enemy_v2", 4);
		setAnimation(img, 1000 / 12f);
		life = 150;
	}

	@Override
	public void strategicMove(Character character) {
		Random rand = new Random();

		if (body.getX() == lastX && body.getY() == lastY) {
			flag=changeDirection;
		}

		if (flag == changeDirection) {
			dir = determineDirection(character);
			flag = 0;
			changeDirection = rand.nextInt(500);

		} else {
			flag++;
		}
		lastX = body.getX();
		lastY = body.getY();
		this.move(dir);

	}

	@Override
	public int determineDirection(Character character) {
		Random rand = new Random();
		int nbAleatoire = rand.nextInt(8);

		switch (nbAleatoire) {
		case 0:
			return Direction.South;
		case 1:
			return Direction.North;
		case 2:
			return Direction.West;
		case 3:
			return Direction.East;
		case 4:
			return Direction.NEast;
		case 5:
			return Direction.SEast;
		case 6:
			return Direction.NWest;
		case 7:
			return Direction.SWest;
		}
		return Direction.None;
	}

	@Override
	public void specialPower(Character character) {
		character.hit(10);
		character.slowDown(3);
	}

	

}
