package game;

import java.util.LinkedList;
import java.util.Queue;

public class ContactListener implements CollisionListener {

	private Queue<Body> bodiesToRemove;
	private Level level;

	public ContactListener(Level level) {
		this.level = level;
		bodiesToRemove = new LinkedList<Body>();
	}

	@Override
	public void colide(Body a, Body b) {
		if (BodyId.isBullet(a.id)) {
			bodiesToRemove.add(a);
			if (BodyId.isEnemy(b.id))
				((Beatable) b.data).hit(level.getCharacter().getWeapon().power);
		}
		if (BodyId.isBullet(b.id)) {
			bodiesToRemove.add(b);
			if (BodyId.isEnemy(a.id))
				((Beatable) a.data).hit(level.getCharacter().getWeapon().power);

		}
	}

	public Queue<Body> getBodiesToRemove() {
		return bodiesToRemove;
	}
}
