package game.objects.weapons;

import game.Level;

public class ShotGun extends Weapon {

	public ShotGun() {
		super(25, 2, 2f, 1f, 150f, 9f);
	}

	@Override
	public void shot(float x, float y, float angle, Level level) {
		if (shot()) {
			addBullet(level, x, y, angle - 10);
			addBullet(level, x, y, angle - 5);
			addBullet(level, x, y, angle);
			addBullet(level, x, y, angle + 5);
			addBullet(level, x, y, angle - 10);
		}
	}

}
