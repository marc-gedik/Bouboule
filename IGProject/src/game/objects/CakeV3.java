package game.objects;

import utils.AssetsManager;
import game.physics.Body;

public class CakeV3 extends Cake{

	public CakeV3(Body body) {
		super(body);
		this.setImg(AssetsManager.getTexture("cake_v3"));
	}

}
