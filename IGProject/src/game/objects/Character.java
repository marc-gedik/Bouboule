package game.objects;

import game.Beatable;
import game.Level;
import game.objects.weapons.Knife;
import game.objects.weapons.Weapon;
import game.physics.Body;

import java.awt.image.BufferedImage;

import utils.AssetsManager;

public class Character extends Dynamic implements Beatable {

	private final static float characterSpeed = 5;

	private Weapon weapon;
	private float life;

	private boolean invinsible;
	private float invinsibleTime = 1f;
	private float invinsibleTiming = .5f;

	private float slowDownTime = 1f;
	private float slowDownTiming = 1f;

	private final int maxLife;

	private long score;

	public Character() {
		this(null);
	}

	public Character(Body body) {
		super(body, characterSpeed);
		BufferedImage[] img = AssetsManager.getSprites("character", 4);
		setAnimation(img, 1000 / 12f);
		maxLife = 100;
		init();
	}

	private void init() {
		weapon = new Knife();
		life = 100;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	@Override
	public void hit(float pow) {
		if (!invinsible) {
			life -= pow;
			invinsibleTime = 0;
			invinsible = true;
		}
	}

	public void slowDown(float speed) {
		slowDownTime = 0;
		this.speed = speed;
	}

	@Override
	public boolean isDead() {
		if (life < 0) {
			init();
			return true;
		}
		return false;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	@Override
	public void update(float dt) {
		super.update(dt);
		score += dt;
		weapon.update(dt);

		if (invinsibleTime < invinsibleTiming) {
			invinsibleTime += dt / 1000;
			if (invinsibleTime > invinsibleTiming)
				invinsible = false;
		}

		if (slowDownTime < slowDownTiming) {
			slowDownTime += dt / 1000;
			if (slowDownTime > slowDownTiming)
				speed = characterSpeed;
		}
	}

	public void shot(Level level) {
		weapon.shot(this, level);
	}

	public void setWeapon(Weapon weapon) {
		if (!weapon.toString().equals(this.weapon.toString()))
			this.weapon = weapon;
	}

	public float getPerCentLife() {
		return (life / maxLife);
	}

	public boolean charging() {
		return weapon.isCharging();
	}

	public void forward() {
		move(angle);
	}

	public void backward() {
		move(angle + 180);
	}

	public void setAngle(float dir) {
		angle = dir;
	}

	public boolean shooting() {
		return weapon.isShooting();
	}

	public void addLife(float pc) {
		life += maxLife * pc;
		if (life > maxLife)
			life = maxLife;
	}

	public void setLife(float f) {
		life = f * maxLife;
	}

	public long getScore() {
		return score;
	}

	public void setScore(long l) {
		score = l;
	}
}
