package game;

import java.awt.Color;

import ui.game.LevelRenderer;

public class Enemy extends Dynamic {

	private Color c;

	public Enemy(Body body) {
		super(body);
	}

	public Enemy(Body body, Color c) {
		super(body);
		this.c = c;
	}

	public void strategicMove(Character character) {
		int dir = determineDirection(character);
		if (c.equals(Color.RED)) {
			this.move(dir, 3);
		} else
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
			direction +=  Direction.East;
		if (xC < xE)
			direction += Direction.West;

		return direction;

	}

	public Color getEnemyColor() {
		return c;
	}

	@Override
	public void draw(LevelRenderer renderer) {
		renderer.drawEnemy(this);
	}

}
