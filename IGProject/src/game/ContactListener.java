package game;

import java.util.LinkedList;
import java.util.Queue;

public class ContactListener implements CollisionListener {

	private Queue<Body> bodiesToRemove;
	
	public ContactListener() {
		bodiesToRemove = new LinkedList<Body>();
	}
	
	@Override
	public void colide(Body a, Body b){
		if(BodyId.isBullet(a.id))
			bodiesToRemove.add(a);
		if(BodyId.isBullet(b.id))
			bodiesToRemove.add(b);
	}
	
	public Queue<Body> getBodiesToRemove() {
		return bodiesToRemove;
	}
}
