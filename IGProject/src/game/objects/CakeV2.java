package game.objects;

import utils.AssetsManager;
import game.physics.Body;

public class CakeV2 extends Cake{

	public CakeV2(Body body) {
		super(body);
		this.setImg(AssetsManager.getTexture("cake_v2"));
		// TODO Auto-generated constructor stub
	}

}
