package game.objects.cakes;

import game.objects.Character;
import game.objects.weapons.Bolt;
import game.physics.Body;
import utils.AssetsManager;

public class CakeV1 extends Cake {

	public CakeV1(Body body) {
		super(body);
		this.setImg(AssetsManager.getTexture("cake_v1"));
		setVersion(1);
	}

	@Override
	public void power(Character character) {
		character.setWeapon(new Bolt());
	}

}
