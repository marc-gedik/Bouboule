package game;

public class EnemyV3 extends Enemy {

	public EnemyV3(Body body, int levelEnemy) {
		super(body, levelEnemy);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void strategicMove(Character character) {
		int dir = determineDirection(character);
		this.move(dir, 1);
	
	}

	@Override
	public int determineDirection(Character character) {
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

}
