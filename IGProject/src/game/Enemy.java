package game;

import java.awt.Color;

import ui.game.LevelRenderer;

public class Enemy extends Dynamic {

	private static final int WIDTH = 32;
	private static final int HEIGHT = 32;
	private int levelEnemy;
	public static int nbEnemy = 0;

	public Enemy(Body body) {
		super(body);
	}

	public Enemy(Body body, int levelEnemy) {
		super(body);
		this.levelEnemy = levelEnemy;
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

	@Override
	public void draw(LevelRenderer renderer) {
		renderer.drawSpriteEnemy(this, idSprite, rotation, levelEnemy);
	}

}
