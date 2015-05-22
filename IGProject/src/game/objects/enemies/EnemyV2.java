package game.objects.enemies;

import game.Direction;
import game.objects.Character;
import game.physics.Body;

import java.awt.image.BufferedImage;
import java.util.Random;

import utils.AssetsManager;
import utils.MathUtils;

public class EnemyV2 extends Enemy {

	private int flag = 1000;
	private int changeDirection = 1000;
	private double lastX = 0, lastY = 0;

	public EnemyV2(Body body) {
		super(body, 2);
		BufferedImage[] img = AssetsManager.getSprites("enemy_v2", 4);
		setAnimation(img, 1000 / 12f);
		life = 150;
		setVersion(2);

	}

	@Override
	public void strategicMove(Character character) {
		Random rand = new Random();

		if (body.getX() == lastX && body.getY() == lastY) {
			flag = changeDirection;
		}

		if (MathUtils.dist2(lastX, character.getX(), lastY, character.getY()) < 150 * 150){
			angle = followCharacter(character);
		}else if (flag == changeDirection) {
			angle = determineDirection();
			flag = 0;
			changeDirection = rand.nextInt(500);
		} else {
			flag++;
		}
		lastX = body.getX();
		lastY = body.getY();
		this.move(angle);

	}

	public int determineDirection() {
		Random rand = new Random();
		return rand.nextInt(360);
	}

	@Override
	public void specialPower(Character character) {
		character.hit(10);
		character.slowDown(3);
	}

}
