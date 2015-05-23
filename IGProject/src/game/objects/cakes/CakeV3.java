package game.objects.cakes;

import utils.AssetsManager;
import game.objects.Character;
import game.objects.weapons.Weapon;
import game.physics.Body;

public class CakeV3 extends Cake{

	public CakeV3(Body body) {
		super(body);
		this.setImg(AssetsManager.getTexture("cake_v3"));
		setVersion(3);

	}

	@Override
	public void power(Character character) {
		// TODO Auto-generated method stub
		
	}

}
