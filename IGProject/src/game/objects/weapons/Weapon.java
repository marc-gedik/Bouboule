package game.objects.weapons;

import game.Level;

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

	public Weapon(float power, int capacity, float chargingTiming,
			float shootTiming) {
		this.power = power;
		this.maxCapacity = capacity;
		this.chargingTiming = chargingTiming;
		this.shootTiming = shootTiming;
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

	public abstract void shot(int x, int y, int angle, Level level);

	public void update(float dt) {
		if (shootTime < shootTiming) {
			shootTime += dt / 1000;
			if (shootTime > shootTiming)
				shooting = false;
		}

		if (chargingTime < chargingTiming) {
			chargingTime += dt / 1000;
			if (chargingTime > chargingTiming)
				charging = false;
		}

	}

	public boolean isCharging(){
		return charging;
	}
}
