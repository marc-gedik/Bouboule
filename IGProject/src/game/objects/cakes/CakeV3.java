package game.objects.cakes;

import game.objects.Character;
import game.physics.Body;
import utils.AssetsManager;

public class CakeV3 extends Cake{

	public CakeV3(Body body) {
		super(body);
		this.setImg(AssetsManager.getTexture("cake_v3"));
		setVersion(3);

	}

	@Override
	public void power(Character character) {
		character.addLife(100);
	}

}
