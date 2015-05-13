package game;

import java.awt.image.BufferedImage;

import ui.Game;
import utils.AssetsManager;


public class Tile extends Static {

	public Tile(Body body) {
		super(body);
		BufferedImage img = AssetsManager.getTexture("wall_1");
		setAnimation(img, 1000 / 12f);
	}
}
