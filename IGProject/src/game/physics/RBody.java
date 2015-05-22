package game.physics;


import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class RBody extends Body {

	private float width, height;

	public RBody(BodyType type, float x, float y, int width, int height) {
		super(Shapes.Rectangle, type, x, y);
		this.width = width;
		this.height = height;
	}

	@Override
	public Shape shape() {
		return new Rectangle2D.Float(x, y, width, height);
	}

	@Override
	public void applyForce(float angle, float speed) {
		double w = Math.toRadians(angle);
		float x = (float) (Math.cos(w) * speed);
		float y = (float) (Math.sin(w) * speed);

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

}
