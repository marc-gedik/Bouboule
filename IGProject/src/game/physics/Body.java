package game.physics;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Float;

public class Body {

	private PhysicalWorld world;

	private float x, y;
	private float width, height;
	final boolean collision;
	public BodyType type;
	public short id;
	public boolean isSensor;

	public Object data;

	
	public Body(float x, float y, float width, float height, boolean collision) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.collision = collision;
	}

	public Float bounds() {
		return new Rectangle2D.Float(x, y, width, height);
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public void applyForce(float x, float y) {
		float n;

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
