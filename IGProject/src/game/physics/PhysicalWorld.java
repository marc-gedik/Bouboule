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
		for (Body bodyB : dynamics)
			if (bodyA != bodyB && bodyA.bounds().intersects(bodyB.bounds())) {
				if (bodyA.getCollision() == false
						&& bodyB.getCollision() == false)
					return false;
				for (CollisionListener listener : listeners)
					listener.colide(bodyA, bodyB);
				return true;
			}
		return false;
	}

	public void addContactListener(CollisionListener listener) {
		listeners.add(listener);
	}

	public void remove(Body body) {
		dynamics.remove(body);
	}

	public boolean staticCollide(Body body) {
		int x = body.getX() / PPM;
		int y = body.getY() / PPM;
		Rectangle r = body.bounds();
		if (x >= 0 && y >= 0 && x < statics.length && y < statics.length)
			for (int i = 0; i < 2; i++)
				for (int j = 0; j < 2; j++)
					if (statics[x + i][y + j] != null
							&& statics[x + i][y + j].bounds().intersects(r)){
						for (CollisionListener listener : listeners)
							listener.colide(statics[x + i][y + j], body);
						return true;
					}
		return false;
	}

}
