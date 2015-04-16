package game;

import java.awt.Rectangle;

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

}
