package game.physics;

import game.Beatable;
import game.Level;
import game.objects.Character;
import game.objects.cakes.Cake;
import game.objects.enemies.Enemy;

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
		} else if (BodyId.isBullet(b.id)) {
			bodiesToRemove.add(b);
			if (BodyId.isEnemy(a.id))
				((Beatable) a.data).hit(level.getCharacter().getWeapon().power);
		}

		else if (BodyId.isEnemy(a.id) && BodyId.isCharacter(b.id))
			((Enemy) a.data).specialPower((Character) b.data);
		else if (BodyId.isEnemy(b.id) && BodyId.isCharacter(a.id))
			((Enemy) b.data).specialPower((Character) a.data);

		else if (BodyId.isCake(a.id) && BodyId.isCharacter(b.id)){
			bodiesToRemove.add(a);
			((Character) b.data).setWeapon(((Cake) a.data).getWeapon());
		}
		else if (BodyId.isCake(b.id) && BodyId.isCharacter(a.id)){
			bodiesToRemove.add(b);
			((Character) a.data).setWeapon(((Cake) b.data).getWeapon());
		}

	}

	public Queue<Body> getBodiesToRemove() {
		return bodiesToRemove;
	}
}
