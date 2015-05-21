package game.physics;

import java.awt.Rectangle;

public class Body {

	private PhysicalWorld world;

	private int x, y;
	private int width, height;
	final boolean collision;
	public BodyType type;
	public short id;
	public boolean isSensor;

	public Object data;

	
	public Body(int x, int y, int width, int height, boolean collision) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.collision = collision;
	}

	public Rectangle bounds() {
		return new Rectangle(x, y, width, height);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void applyForce(int x, int y) {
		int n;

		n = this.x;
		this.x += x;
		if (world.staticCollide(this) || world.collide(this))
			this.x = n;

		n = this.y;
		this.y += y;
		if (world.staticCollide(this) || world.collide(this))
			this.y = n;

	}

	public void setWorld(PhysicalWorld physicalWorld) {
		world = physicalWorld;
	}

	public void applyForce(double x, double y) {
		
	}
}
