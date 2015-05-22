package game.objects.enemies;

import game.Direction;
import game.objects.Character;
import game.physics.Body;

import java.awt.image.BufferedImage;
import java.util.Random;

import utils.AssetsManager;

public class EnemyV1 extends Enemy {

	private int dir = Direction.None;
	private int flag = 1000;
	private int changeDirection = 1000;
	private double lastX = 0, lastY = 0;

	public EnemyV1(Body body) {
		super(body, 1);
		BufferedImage[] img = AssetsManager.getSprites("enemy_v1", 4);
		setAnimation(img, 1000 / 12f);
		life = 100;
		setVersion(1);
	}

	@Override
	public void strategicMove(Character character) {
		Random rand = new Random();

		if (body.getX() == lastX && body.getY() == lastY)
			flag = changeDirection;

		if (flag == changeDirection) {
			dir = determineDirection();
			flag = 0;
			changeDirection = rand.nextInt(800);

		} else {
			flag++;
		}

		lastX = body.getX();
		lastY = body.getY();
		this.move(dir);

	}

	public int determineDirection() {
		Random rand = new Random();
		int nbAleatoire = rand.nextInt(4);

		return nbAleatoire * 90;
	}

	@Override
	public void specialPower(Character character) {
		character.hit(5);
	}

}
