package game;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PhysicalWorld {

	public final static int PPM = 32;

	private List<Body> bodies;

	public PhysicalWorld(int width, int height) {
		bodies = new LinkedList<Body>();
	}

	public void addBody(Body body) {
		body.setWorld(this);
		bodies.add(body);
	}

	public boolean collide(Body bodyA) {
		for (Body bodyB : bodies)
			if (bodyA != bodyB && bodyA.bounds().intersects(bodyB.bounds()))
				return true;
		return false;
	}
}

enum BodyType {
	STATIC, DYNAMIC
}