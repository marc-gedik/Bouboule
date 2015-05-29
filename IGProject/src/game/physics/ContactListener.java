package game.physics;

import game.Beatable;
import game.objects.Character;
import game.objects.cakes.Cake;
import game.objects.enemies.Enemy;
import game.objects.weapons.Bullet;

import java.util.LinkedList;
import java.util.Queue;

public class ContactListener implements CollisionListener {

	private Queue<Body> bodiesToRemove;

	public ContactListener() {
		bodiesToRemove = new LinkedList<Body>();
	}

	@Override
	public void colide(Body a, Body b) {
		if (BodyId.isBullet(a.id)) {
			Bullet bullet = (Bullet) a.data;
			if (BodyId.isEnemy(b.id) || BodyId.isCharacter(b.id))
				if (b.data != bullet.thrower)
					((Beatable) b.data).hit(bullet.power);
		} else if (BodyId.isBullet(b.id)) {
			Bullet bullet = (Bullet) b.data;
			if (BodyId.isEnemy(a.id) || BodyId.isCharacter(a.id))
				if (a.data != bullet.thrower)
					((Beatable) a.data).hit(bullet.power);
		}

		else if (BodyId.isEnemy(a.id) && BodyId.isCharacter(b.id))
			((Enemy) a.data).specialPower((Character) b.data);
		else if (BodyId.isEnemy(b.id) && BodyId.isCharacter(a.id))
			((Enemy) b.data).specialPower((Character) a.data);

		else if (BodyId.isCake(a.id) && BodyId.isCharacter(b.id)) {
			bodiesToRemove.add(a);
			((Cake) a.data).power(((Character) b.data));
		} else if (BodyId.isCake(b.id) && BodyId.isCharacter(a.id)) {
			bodiesToRemove.add(b);
			((Cake) b.data).power(((Character) a.data));
		}

	}

	public Queue<Body> getBodiesToRemove() {
		return bodiesToRemove;
	}
}
