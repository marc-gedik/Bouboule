package game.objects.cakes;

import game.objects.Character;
import game.objects.weapons.FlameThrower;
import game.physics.Body;
import utils.AssetsManager;

public class CakeV2 extends Cake{

	public CakeV2(Body body) {
		super(body);
		this.setImg(AssetsManager.getTexture("cake_v2"));
		setVersion(2);
	}

	@Override
	public void power(Character character) {
		character.setWeapon(new FlameThrower());
	}


}
