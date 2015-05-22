package game.objects.enemies;

import java.awt.image.BufferedImage;

import utils.MathUtils;
import game.Beatable;
import game.Direction;
import game.objects.Character;
import game.objects.Dynamic;
import game.physics.Body;


public abstract class Enemy extends Dynamic implements Beatable {

	protected float life;
	private int version;

	
	public Enemy(Body body, float speed) {
		super(body, speed);
	}

	public abstract void strategicMove(Character character);

	@Override
	public void hit(float pow) {
		life -= pow;
	}
	
	@Override
	public boolean isDead() {
		return life < 0;
	}

	public float followCharacter(Character character) {
		float xC = character.getX();
		float yC = character.getY();
		float xE = this.getX();
		float yE = this.getY();
		return (float) Math.toDegrees(Math.atan2(yC - yE, xC - xE));
	}
	
	public abstract void specialPower(Character character);

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}
