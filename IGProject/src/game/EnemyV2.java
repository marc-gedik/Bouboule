package game;

import java.awt.image.BufferedImage;
import java.util.Random;

import utils.AssetsManager;

public class EnemyV2 extends Enemy {

	private int dir = Direction.None;
	private int flag = 1000;
	private int changeDirection = 1000;
	private int lastX = 0, lastY = 0;

	public EnemyV2(Body body) {
		super(body);
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
		this.move(dir, 1);

	}

	@Override
	public int determineDirection(Character character) {
		Random rand = new Random();
		int nbAleatoire = rand.nextInt(8);
		int direction = Direction.None;

		switch (nbAleatoire) {
		case 0:
			direction = Direction.South;
			break;
		case 1:
			direction = Direction.North;
			break;
		case 2:
			direction = Direction.West;
			break;
		case 3:
			direction = Direction.East;
			break;
		case 4:
			direction = Direction.North;
			direction += Direction.East;
			break;
		case 5:
			direction = Direction.South;
			direction += Direction.East;
			break;
		case 6:
			direction = Direction.North;
			direction += Direction.West;
			break;
		case 7:
			direction = Direction.South;
			direction += Direction.West;
			break;
		}
		return direction;
	}

	

}
