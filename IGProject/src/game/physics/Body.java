package game.physics;

import java.awt.geom.Rectangle2D;

public abstract class Body {

	protected PhysicalWorld world;
	
	public final Shapes shape;
	public final BodyType type;
	
	public short category, mask;
	public boolean isSensor;

	public Object data;

	protected float x, y;


	public Body(Shapes shape, BodyType bodyType, float x, float y) {
		this.shape = shape;
		this.type = bodyType;
		this.x = x;
		this.y = y;
	}

	public abstract java.awt.Shape shape();

	public float getX(){return x;}
	public float getY(){return y;}

	public abstract void applyForce(float pow, float dir);

	public void setWorld(PhysicalWorld physicalWorld) {
		world = physicalWorld;
	}

	public boolean intersect(Body body) {
		if (shape == Shapes.Rectangle)
			return body.shape().intersects((Rectangle2D.Float) shape());
		if (body.shape == Shapes.Rectangle)
			return shape().intersects((Rectangle2D.Float) body.shape());
		return false;
	}
}
