package game.objects.weapons;

import game.Level;

public class Pistol extends Weapon {

	public Pistol() {
		super(15f, 30, 1f, .5f);
	}

	@Override
	public void shot(int x, int y, int angle, Level level) {
		if (super.shot())
			level.addBullet(x, y, angle, 10);
	}

}
