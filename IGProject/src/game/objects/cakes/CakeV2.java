package game.objects.cakes;

import utils.AssetsManager;
import game.objects.Character;
import game.objects.weapons.Weapon;
import game.physics.Body;

public class CakeV2 extends Cake{

	public CakeV2(Body body) {
		super(body);
		this.setImg(AssetsManager.getTexture("cake_v2"));
		// TODO Auto-generated constructor stub
	}

	@Override
	public void power(Character character) {
		// TODO Auto-generated method stub
		
	}


}
