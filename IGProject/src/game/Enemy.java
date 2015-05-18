package game;

import java.awt.image.BufferedImage;

import ui.Game;
import utils.AssetsManager;

public abstract class Enemy extends Dynamic {

	private int levelEnemy;

	public Enemy(Body body) {
		super(body);
	}

	public abstract void strategicMove(Character character);

	public  abstract int determineDirection(Character character);

}
