package game.physics;

import java.util.LinkedList;
import java.util.List;

public class PhysicalWorld {

	public final static int PPM = 32;

	private List<Body> bodies;
	private List<CollisionListener> listeners;
	
	public PhysicalWorld(int width, int height) {
		bodies = new LinkedList<Body>();
		listeners = new LinkedList<CollisionListener>();
	}

	public void addBody(Body body) {
		body.setWorld(this);
		bodies.add(body);
	}

	public boolean collide(Body bodyA) {
		for (Body bodyB : bodies)
			if (bodyA != bodyB && bodyA.bounds().intersects(bodyB.bounds())){
				if(bodyA.getCollision()==false && bodyB.getCollision()==false)
					return false;
				for(CollisionListener listener : listeners)
					listener.colide(bodyA, bodyB);
				return true;
			}
		return false;
	}

	public void addContactListener(CollisionListener listener) {
		listeners.add(listener);
	}

	public void remove(Body body) {
		bodies.remove(body);
	}
}

