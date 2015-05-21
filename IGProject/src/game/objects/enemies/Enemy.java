package game.objects.enemies;

import java.awt.image.BufferedImage;

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

	public int followCharacter(Character character) {
		double xC = character.getX();
		double yC = character.getY();
		double xE = this.getX();
		double yE = this.getY();
		int direction = Direction.None;

		if (yC > yE)
			direction += Direction.South;
		else if (yC < yE)
			direction += Direction.North;
		if (xC > xE)
			direction += Direction.East;
		if (xC < xE)
			direction += Direction.West;
		return direction;
	}
	
	public abstract void specialPower(Character character);

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}
