package game;

public enum Weapon {
	Pistol(1);

	public final float power;

	private Weapon(float power) {
		this.power = power;
	}
}
