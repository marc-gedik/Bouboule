package game.physics;

import java.awt.Shape;
import java.awt.geom.Line2D;

public class LBody extends Body {

	private float xb, yb;
	private double dir;

	public LBody(BodyType bodyType, float x, float y, float dist, float angle) {
		super(Shapes.Line, bodyType, x, y);

		dir = Math.toRadians(angle);
		x += (float) (Math.cos(dir) * dist);
		y += (float) (Math.sin(dir) * dist);
		xb = x;
		yb = y;
	}

	@Override
	public Shape shape() {
		return new Line2D.Float(x, y, xb, yb);
	}

	@Override
	public void applyForce(float pow, float dir) {
		world.staticCollide(this);
		world.collide(this);
	}

}
