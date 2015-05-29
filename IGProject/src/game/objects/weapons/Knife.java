package game.objects.weapons;

import game.Level;
import game.objects.Dynamic;
import ui.game.Animation;
import utils.AssetsManager;

public class Knife extends Weapon {
	public Knife(){super(5, -1, 0, .33f, 50, 8); }

	@Override
	public void shot(Dynamic o, Level level) {
		if (shot())
			addBullet(level, o, o.getX(), o.getY(), 32, 32, o.getAngle(), speed);
	}

	@Override
	protected void setAnimation() {
		animation = new Animation(AssetsManager.getSprites("cut", 5),
				1000 / 15f);
	}

	@Override
	public String toString() {
		return "knife";
	}

}
