package game.objects.enemies;

import game.objects.Character;
import game.physics.Body;

import java.awt.image.BufferedImage;

import utils.AssetsManager;
import utils.MathUtils;

public class EnemyV3 extends Enemy {

	private double lastX = 0, lastY = 0;
	private float lastDIR = 0;
	private int cpt = 0;
	private int sizeBypass = 50;
	private boolean flag = true;

	public EnemyV3(Body body) {
		super(body, 3);
		BufferedImage[] img = AssetsManager.getSprites("enemy_v3", 4);
		setAnimation(img, 1000 / 12f);
		life = 200;
		setVersion(3);

	}

	@Override
	public void strategicMove(Character character) {
		double dist = MathUtils.dist2(character.getX(), body.getX(),
				character.getY(), body.getY());
		int distMax = 20 * 20;

		if (body.getX() == lastX && body.getY() == lastY && dist > distMax) {
			angle = bypass(lastDIR);
			flag = false;
		}

		if (flag)
			angle = followCharacter(character);
		else {
			cpt++;
			if (cpt == sizeBypass) {
				flag = true;
				cpt = 0;
			}

		}

		lastX = body.getX();
		lastY = body.getY();
		lastDIR = angle;
		this.move(angle);

	}

	public float turnRight(float angle) {
		return angle + 90;
	}

	public float bypass(float lastDir) {
		return turnRight(lastDir);
	}

	@Override
	public void specialPower(Character character) {
		character.hit(15);
	}

}
