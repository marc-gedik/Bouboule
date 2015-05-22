package game.objects.weapons;

import game.Level;

public class FlameThrower extends Weapon {

	public FlameThrower() {
		super(1, 500, 5f, .1f, 100, 5f);
	}

	@Override
	public void shot(float x, float y, float angle, Level level) {
		if (shot())
			for (int i = -5; i < 5; i++)
				addBullet(level, x, y, angle + i * 2);
	}

}
