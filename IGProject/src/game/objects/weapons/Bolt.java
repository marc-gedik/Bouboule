package game.objects.weapons;

import ui.game.Animation;
import utils.AssetsManager;
import game.Level;

public class Bolt extends Weapon {

	public Bolt() {
		super(10, 1, 1f, .1f, 242, 10f);
		animation = new Animation(AssetsManager.getSprites("bolt", 10),
				1000 / 60f);

	}

	@Override
	public void shot(float x, float y, float angle, Level level) {
		if (shot())
			addBullet(level, x, y, 20, 20, angle, speed);
	}

}
