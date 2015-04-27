package game;

import java.awt.image.BufferedImage;

import ui.Game;


public class Character extends Dynamic {

	public Character(Body body) {
		super(body);
		BufferedImage[] img = Game.assets.getSprites("character", 4);
		setAnimation(img, 1000 / 12f);
	}

}
