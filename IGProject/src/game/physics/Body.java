package game.physics;

import java.awt.Rectangle;

public class Body {

	private PhysicalWorld world;

	private int x, y;
	private int width, height;
	private boolean collision;
	public BodyType type;
	public short id;

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

	public boolean getCollision() { return collision; }

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
}
