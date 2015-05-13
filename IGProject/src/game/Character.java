package game;

import java.awt.image.BufferedImage;

import ui.Game;
import utils.AssetsManager;


public class Character extends Dynamic {

	public Character(Body body) {
		super(body);
		BufferedImage[] img = AssetsManager.getSprites("character", 4);
		setAnimation(img, 1000 / 12f);
	}

}
