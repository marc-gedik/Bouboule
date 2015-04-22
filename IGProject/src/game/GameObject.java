package game;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import ui.game.LevelRenderer;

public abstract class GameObject {

	protected int x, y;
	
	public GameObject(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public boolean colliedWith(GameObject entity) {
		return getBounds().intersects(entity.getBounds());
	}

	abstract public Rectangle getBounds();


	public abstract void draw(LevelRenderer renderer);

}
