package game.objects.cakes;

import game.objects.weapons.ShotGun;
import game.objects.weapons.Weapon;
import game.physics.Body;
import utils.AssetsManager;

public class CakeV1 extends Cake {

	
	public CakeV1(Body body) {
		super(body);
		this.setImg(AssetsManager.getTexture("cake_v1"));
	}

	@Override
	public Weapon getWeapon() {
		return new ShotGun();
	}

}
