package game.objects.weapons;

import game.Level;
import game.objects.Dynamic;
import game.physics.Body;
import game.physics.BodyId;
import game.physics.BodyType;

import java.awt.image.BufferedImage;

import ui.config.SoundManager;
import ui.game.Animation;

public abstract class Weapon {

	protected Animation animation;

	public final float power;

	public final int maxCapacity;
	public int capacity;

	private boolean charging;
	public float chargingTime;
	public final float chargingTiming;

	public float shootTime;
	public final float shootTiming;
	private boolean shooting;

	public final float dist;
	public final float speed;

	private boolean shootSound;

	Weapon(float power, int capacity, float chargingTiming, float shootTiming,
			float dist, float speed) {
		this.power = power;
		this.maxCapacity = capacity;
		this.chargingTiming = chargingTiming;
		this.shootTiming = shootTiming;
		this.dist = dist;
		this.speed = speed;
		setAnimation();
	}

	protected abstract void setAnimation();

	protected void addBullet(Level level, Dynamic o, float x, float y,
			float width, float height, float angle, float speed) {
		Body body = new Body(x, y, width, height, false);
		body.type = BodyType.DYNAMIC;
		body.id = BodyId.Bullet;
		body.isSensor = true;
		Bullet bullet = new Bullet(o, body, angle, dist, speed, power);
		body.data = bullet;
		level.addBullet(bullet);
	}

	protected boolean shot() {
		if (shooting || charging)
			return false;

		if (maxCapacity != -1 && capacity == maxCapacity) {
			animation.reset();
			capacity = 0;
			chargingTime = 0;
			charging = true;
			return false;
		}

		shootTime = 0;
		shooting = true;
		shootSound = false;
		capacity++;
		return true;
	}

	public abstract void shot(Dynamic o, Level level);

	public void update(float dt) {

		if (shootTime < shootTiming) {
			animation.update(dt);
			shootTime += dt / 1000;
			if (shootTime >= shootTiming) {
				shooting = false;
			}
		}

		if (chargingTime < chargingTiming) {
			chargingTime += dt / 1000;
			if (chargingTime >= chargingTiming)
				charging = false;
		}

	}

	public boolean isCharging() {
		return charging;
	}

	public BufferedImage getFrame() {
		return animation.getFrame();
	}

	public boolean isShooting() {
		return shooting;
	}

	public abstract String toString();

	public static Weapon valueOf(String w) {
		if (w.equals("knife"))
			return new Knife();
		else if (w.equals("flameThrower"))
			return new FlameThrower();
		else if (w.equals("bolt"))
			return new Bolt();
		return null;
	}

	protected void sound(SoundManager soundManager, String name) {
		if (!shootSound && shooting) {
			soundManager.playSound(name);
			shootSound = true;
		}
	}

	public void sound(SoundManager soundManager) {
		sound(soundManager, toString());
	}
}
