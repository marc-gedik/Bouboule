package game;

import java.awt.image.BufferedImage;

import ui.Game;


public class Tile extends Static {

	public Tile(Body body) {
		super(body);
		BufferedImage img = Game.assets.getTexture("wall_1");
		setAnimation(img, 1000 / 12f);
	}
}
