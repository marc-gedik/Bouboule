package game;

import java.awt.Rectangle;

public class Character extends Dynamic {
	private static final int WIDTH = 32;
	private static final int HEIGHT = 32;

	public Character(int x, int y) {
		super(x * WIDTH, y * HEIGHT);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(getX(), getY(), WIDTH, HEIGHT);
	}

}
