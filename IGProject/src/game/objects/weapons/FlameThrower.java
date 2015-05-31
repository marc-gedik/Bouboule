package game.objects.weapons;

import game.Level;
import game.objects.Dynamic;
import ui.game.Animation;
import utils.AssetsManager;

public class FlameThrower extends Weapon {
	public FlameThrower() {
		super(15, 500, 5f, .8f, 240, 8f);
	}

	@Override
	public void shot(Dynamic o, Level level) {
		if (shot())
			addBullet(level, o, o.getX(), o.getY(), 16, 16, o.getAngle(), speed);
	}

	@Override
	protected void setAnimation() {
		animation = new Animation(AssetsManager.getSprites("flamethrower", 29),
				1000 / 60f);
	}

	@Override
	public String toString() {
		return "flameThrower";
	}
}
