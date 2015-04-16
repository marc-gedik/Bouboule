package game;

import java.awt.Rectangle;

public class Enemy extends Dynamic {

	public Enemy(int x, int y) {
		super(x, y);
	}

	private static final int WIDTH = 50;
	private static final int HEIGHT = 50;

	@Override
	public Rectangle getBounds() {
		return new Rectangle(getX(), getY(), WIDTH, HEIGHT);
	}

}
