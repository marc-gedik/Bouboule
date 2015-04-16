package game;

import java.awt.Rectangle;

public abstract class Entity extends GameObject {
	
	public Entity(int x, int y) {
		super(x, y);
	}

	protected void setX(int x) {
		this.x = x;
	}
	
	protected void setY(int y) {
		this.y = y;
	}
	
}
