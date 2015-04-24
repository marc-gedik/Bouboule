package game;

import java.awt.Color;
import java.awt.Rectangle;

import ui.game.LevelRenderer;

public class Enemy extends Dynamic {

	private static final int WIDTH = 32;
	private static final int HEIGHT = 32;
	private Color c;
	public static int nbEnemy = 0;

	public Enemy(int x, int y) {
		super(x * WIDTH, y * HEIGHT);
		nbEnemy++;
		System.out.println(nbEnemy);

	}

	public Enemy(int x, int y, Color c) {
		super(x * WIDTH, y * HEIGHT);
		this.c = c;
		nbEnemy++;
	}

	public void strategicMove(Level l) {
		int dir = determineDirection(l);
		if (c.equals(Color.RED)) {
			this.move(dir, 1);
		} else
			this.move(dir, 1);

	}

	public int determineDirection(Level l) {
		Character c = l.getCharacter();
		int xC = c.getX();
		int yC = c.getY();
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

	@Override
	public Rectangle getBounds() {
		return new Rectangle(getX(), getY(), WIDTH, HEIGHT);
	}

	public Color getEnemyColor() {
		return c;
	}

	@Override
	public void draw(LevelRenderer renderer) {
		renderer.drawEnemy(this);
	}

}
