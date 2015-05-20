package game.objects;

import java.awt.image.BufferedImage;

import utils.AssetsManager;
import game.physics.Body;

public class CakeV1 extends Cake {

	
	public CakeV1(Body body) {
		super(body);
		this.setImg(AssetsManager.getTexture("cake_v1"));

		
	}

}
