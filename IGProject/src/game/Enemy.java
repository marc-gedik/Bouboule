package game;

import java.awt.image.BufferedImage;

import ui.Game;

public class Enemy extends Dynamic {

	private int levelEnemy;

	public Enemy(Body body) {
		super(body);
	}

	public Enemy(Body body, int levelEnemy) {
		super(body);
		this.levelEnemy = levelEnemy;
		BufferedImage[] img = Game.assets.getSprites("enemy_v" + levelEnemy, 4);
		setAnimation(img, 1000 / 12f);
	}

	public void strategicMove(Character character) {
		int dir = determineDirection(character);
		this.move(dir, 1);
	}

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

}
