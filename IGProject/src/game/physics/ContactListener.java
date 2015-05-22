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
		if (Category.isBullet(a.category)) {
			bodiesToRemove.add(a);
			if (Category.isEnemy(b.category))
				((Beatable) b.data).hit(level.getCharacter().getWeapon().power);
		} else if (Category.isBullet(b.category)) {
			bodiesToRemove.add(b);
			if (Category.isEnemy(a.category))
				((Beatable) a.data).hit(level.getCharacter().getWeapon().power);
		}

		else if (Category.isEnemy(a.category) && Category.isCharacter(b.category))
			((Enemy) a.data).specialPower((Character) b.data);
		else if (Category.isEnemy(b.category) && Category.isCharacter(a.category))
			((Enemy) b.data).specialPower((Character) a.data);

		else if (Category.isCake(a.category) && Category.isCharacter(b.category)){
			bodiesToRemove.add(a);
			((Cake) a.data).power(((Character) b.data));
		}
		else if (Category.isCake(b.category) && Category.isCharacter(a.category)){
			bodiesToRemove.add(b);
			((Cake) b.data).power(((Character) a.data));
		}

	}

	public Queue<Body> getBodiesToRemove() {
		return bodiesToRemove;
	}
}
