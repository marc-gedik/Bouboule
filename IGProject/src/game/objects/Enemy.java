package game.objects;

import game.Beatable;
import game.Direction;
import game.physics.Body;


public abstract class Enemy extends Dynamic implements Beatable {

	protected float life;
	
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
		int xC = character.getX();
		int yC = character.getY();
		int xE = this.getX();
		int yE = this.getY();
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
}
