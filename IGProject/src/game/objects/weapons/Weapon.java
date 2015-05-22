package game.objects.weapons;

import game.Level;
import game.physics.Body;
import game.physics.Category;
import game.physics.BodyType;
import game.physics.LBody;
import game.physics.RBody;

public abstract class Weapon {

	public final float power;

	public final int maxCapacity;
	public int capacity;

	private boolean charging;
	public float chargingTime;
	public final float chargingTiming;

	public float shootTime;
	public final float shootTiming;
	private boolean shooting;

	private final float dist;
	private final float speed;
	
	public Weapon(float power, int capacity, float chargingTiming,
			float shootTiming, float dist, float speed) {
		this.power = power;
		this.maxCapacity = capacity;
		this.chargingTiming = chargingTiming;
		this.chargingTime = chargingTiming;
		
		this.shootTiming = shootTiming;
		this.shootTime = shootTiming;
		
		this.dist = dist;
		this.speed = speed;
	}

	protected void addBullet(Level level, float x, float y, float angle){
		Body body = new LBody(BodyType.DYNAMIC, x, y, 50, angle);
		body.category = Category.Bullet;
		body.mask = Category.Enemy;
		Bullet bullet = new Bullet(body, angle, dist, speed);
		body.data = bullet;
		level.addBullet(bullet);
	}
	
	protected boolean shot() {
		if (shooting || charging)
			return false;
		
		if (capacity == maxCapacity) {
			capacity = 0;
			chargingTime = 0;
			charging = true;
			return false;
		}

		shootTime = 0;
		shooting = true;
		capacity++;
		return true;
	}

	public abstract void shot(float x, float y, float angle, Level level);

	public void update(float dt) {
		if (shootTime < shootTiming) {
			shootTime += dt / 1000;
			if (shootTime > shootTiming)
				shooting = false;
		}

		if (chargingTime < chargingTiming) {
			chargingTime += dt / 1000;
			if (chargingTime >= chargingTiming)
				charging = false;
		}

	}

	public boolean isCharging(){
		return charging;
	}
}
