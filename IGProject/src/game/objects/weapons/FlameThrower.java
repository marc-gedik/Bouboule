package game.objects.weapons;

import ui.game.Animation;
import utils.AssetsManager;
import game.Level;

public class FlameThrower extends Weapon {

	public FlameThrower() {
		super(2, 500, 5f, .1f, 240, 8f);
		animation = new Animation(AssetsManager.getSprites("flamethrower", 29),
				1000 / 60f);
	}

	@Override
	public void shot(float x, float y, float angle, Level level) {
		if (shot())
			addBullet(level, x, y, 16, 16, angle, speed);
	}

}
