package game.objects.cakes;

import utils.AssetsManager;
import game.objects.weapons.Weapon;
import game.physics.Body;

public class CakeV3 extends Cake{

	public CakeV3(Body body) {
		super(body);
		this.setImg(AssetsManager.getTexture("cake_v3"));
	}

	@Override
	public Weapon getWeapon() {
		// TODO Auto-generated method stub
		return null;
	}

}
