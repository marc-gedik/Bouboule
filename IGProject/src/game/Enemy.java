package game;

import java.awt.image.BufferedImage;

import ui.Game;
import utils.AssetsManager;

public abstract class Enemy extends Dynamic {

	private int levelEnemy;

	public Enemy(Body body) {
		super(body);
	}

	public Enemy(Body body, int levelEnemy) {
		super(body);
		this.levelEnemy = levelEnemy;
		BufferedImage[] img = AssetsManager.getSprites("enemy_v" + levelEnemy, 4);
		setAnimation(img, 1000 / 12f);
	}

	public abstract void strategicMove(Character character);

	public  abstract int determineDirection(Character character);

}
