package game.physics;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

public class PhysicalWorld {

	public final static int PPM = 32;

	private Body[][] statics;
	private List<Body> dynamics;
	private List<CollisionListener> listeners;

	public PhysicalWorld(int width, int height) {
		dynamics = new LinkedList<Body>();
		statics = new Body[width][height];
		listeners = new LinkedList<CollisionListener>();
	}

	public void addBody(Body body) {
		body.setWorld(this);
		if (body.type == BodyType.DYNAMIC)
			dynamics.add(body);
		else if (body.type == BodyType.STATIC) {
			Rectangle r = body.bounds();
			statics[(int) (body.getX() / r.getWidth())][(int) (body.getY() / r
					.getHeight())] = body;
		}
	}

	public boolean collide(Body bodyA) {
		boolean b = false;
		for (Body bodyB : dynamics)
			if (bodyA != bodyB && bodyA.bounds().intersects(bodyB.bounds())) {
				if (bodyA.collision == false && bodyB.collision == false)
					continue;
				for (CollisionListener listener : listeners)
					listener.colide(bodyA, bodyB);
				if (!bodyA.isSensor && !bodyB.isSensor)
					b = true;
			}
		return b;
	}

	public void addContactListener(CollisionListener listener) {
		listeners.add(listener);
	}

	public void remove(Body body) {
		dynamics.remove(body);
	}

	public boolean staticCollide(Body bodyA) {
		int x = bodyA.getX() / PPM;
		int y = bodyA.getY() / PPM;
		boolean b = false;
		Rectangle r = bodyA.bounds();
		if (x >= 0 && y >= 0)
			for (int i = 0; i < 2 && x + i< statics.length ; i++)
				for (int j = 0; j < 2 && y + j< statics.length; j++) {
					Body bodyB = statics[x + i][y + j];
					if (bodyB != null && bodyB.bounds().intersects(r)) {
						for (CollisionListener listener : listeners)
							listener.colide(bodyB, bodyA);
						if (!bodyA.isSensor && !bodyB.isSensor)
							b = true;
					}
				}
		return b;
	}

}
