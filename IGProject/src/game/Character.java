package game;

import java.awt.image.BufferedImage;

import ui.Game;
import utils.AssetsManager;


public class Character extends Dynamic implements Beatable {

	Weapon weapon;
	private float life;
	
	public Character(Body body) {
		super(body);
		BufferedImage[] img = AssetsManager.getSprites("character", 4);
		setAnimation(img, 1000 / 12f);
		weapon = Weapon.Pistol;
	}

	@Override
	public void hit(float pow) {
		System.out.println("hit character");
	}

	@Override
	public boolean isDead() {
		return life < 0;
	}

	public Weapon getWeapon() {
		return weapon;
	}

}
