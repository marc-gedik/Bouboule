package game.objects.enemies;

import game.Level;
import game.objects.Character;
import game.objects.weapons.Vomit;
import game.objects.weapons.Weapon;
import game.physics.Body;

import java.awt.geom.Rectangle2D.Float;
import java.awt.image.BufferedImage;

import utils.AssetsManager;
import utils.MathUtils;

public class Boss extends Enemy {

	private Weapon weapon;
	private Level level;
	
	public Boss(Body body) {
		super(body, 3);
		BufferedImage[] img = AssetsManager.getSprites("fasto", 4);
		setAnimation(img, 1000 / 12f);
		life = 3000;
		setVersion(4);
		weapon = new Vomit();
	}

	public void setLevel(Level level) {
		this.level = level;
	}
	
	@Override
	public void strategicMove(Character character) {
		Float bounds = body.bounds();
		
		double dist = MathUtils.dist2(character.getX(), bounds.getCenterX(), character.getY(), bounds.getCenterY());
		angle = followCharacter(character);
		if(dist < weapon.dist * weapon.dist){
			weapon.shot(this, level);
		}
	}

	@Override
	public void specialPower(Character character) {
		character.hit(25);
	}

	@Override
	public void update(float dt) {
		super.update(dt);
		weapon.update(dt);
		move(angle);
	}

	public boolean shooting() {
		return weapon.isShooting();
	}

	public Weapon getWeapon() {
		return weapon;
	}
}
