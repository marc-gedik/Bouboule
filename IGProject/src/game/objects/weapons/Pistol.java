package game.objects.weapons;

import game.Level;

public class Pistol extends Weapon {

	public Pistol() {
		super(15f, 30, 1f, .5f, 200f, 12f);
	}

	@Override
	public void shot(float x, float y, float angle, Level level) {
		if (super.shot())
			addBullet(level, x, y, angle);
	}

}
