package game;

import java.awt.Rectangle;

public class Body {

	private PhysicalWorld world;

	private int x, y;
	private int width, height;
	public BodyType type;

	public Body(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
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
		if (world.collide(this))
			this.x = n;

		n = this.y;
		this.y += y;
		if (world.collide(this))
			this.y = n;

	}

	public void setWorld(PhysicalWorld physicalWorld) {
		world = physicalWorld;
	}
}
