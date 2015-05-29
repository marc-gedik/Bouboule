package game.objects.weapons;

import game.Level;
import game.objects.Dynamic;
import ui.game.Animation;
import utils.AssetsManager;

public class Vomit extends Weapon {
	public Vomit() {
		super(5, -1, 0, .33f, 64, 8);
	}

	@Override
	public void shot(Dynamic o, Level level) {
		if (shot())
			addBullet(level, o, o.getX(), o.getY(), 32, 32, o.getAngle(), speed);
	}

	@Override
	protected void setAnimation() {
		animation = new Animation(AssetsManager.getSprites("vomit", 9),
				1000 / 12f);
	}

	@Override
	public String toString() {
		return "vomit";
	}
}
