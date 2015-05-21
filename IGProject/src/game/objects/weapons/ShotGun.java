package game.objects.weapons;

import game.Level;

public class ShotGun extends Weapon {

	public ShotGun() {
		super(25, 2, 2f, 1f);
	}

	@Override
	public void shot(int x, int y, int angle, Level level) {
		if (shot()) {
			level.addBullet(x - 5, y - 5, angle, 5);
			level.addBullet(x + 5, y + 5, angle, 5);
		}
	}

}
