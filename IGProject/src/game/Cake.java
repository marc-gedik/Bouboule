package game;

import java.awt.Rectangle;

import ui.game.LevelRenderer;


public class Cake extends Static {

	private static final int WIDTH = 32;
	private static final int HEIGHT = 32;
	private int levelCake;
	
	public Cake(int x, int y, int levelCake) {
		super(x*WIDTH, y*HEIGHT);
		this.levelCake=levelCake;
	}

	private static final int DIAMETER = 30;

	@Override
	public Rectangle getBounds() {
		return new Rectangle(getX(), getY(), DIAMETER, DIAMETER);
	}

	@Override
	public void draw(LevelRenderer renderer) {
		renderer.drawSpriteCake(this, levelCake);
	}

}
