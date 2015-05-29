package game.objects.weapons;

import game.Level;
import game.objects.Dynamic;
import ui.game.Animation;
import utils.AssetsManager;

public class Bolt extends Weapon {

	public Bolt() {

		super(10, 1, 1f, .1f, 242, 10f);
	}

	@Override
	public void shot(Dynamic o, Level level) {
		if (shot())
			addBullet(level, o, o.getX(), o.getY(), 20, 20, o.getAngle(), speed);
	}

	@Override
	protected void setAnimation() {
		animation = new Animation(AssetsManager.getSprites("bolt", 10),
				1000 / 60f);
	}

	@Override
	public String toString() {
		return "bolt";
	}
}
