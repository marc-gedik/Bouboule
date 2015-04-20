package game;

import java.awt.Color;
import java.awt.Rectangle;

public class Enemy extends Dynamic {

	private static final int WIDTH = 32;
	private static final int HEIGHT = 32;
	private Color c;
	public static int nbEnemy=0;

	public Enemy(int x, int y) {
		super(x * WIDTH, y * HEIGHT);
		nbEnemy++;
		System.out.println(nbEnemy);


	}

	public Enemy(int x, int y, Color c) {
		super(x * WIDTH, y * HEIGHT);
		this.c=c;
		nbEnemy++;
	}

	public void strategicMove(Level l) {
		int dir = determineDirection(l);
		if( c.equals(Color.RED)){
			this.move(dir, 2);
		}
		
		this.move(dir, 1);

	}

	public int determineDirection(Level l) {
		Character c = l.getCharacter();
		int xC = c.getX();
		int yC = c.getY();
		int xE = this.getX();
		int yE = this.getY();

		if (yC > yE) {
			if (xC > xE)
				return Direction.South + Direction.East;
			if (xC < xE)
				return Direction.South + Direction.West;
			if (xC == xE)
				return Direction.South;
		} else if (yC < yE) {
			if (xC > xE)
				return Direction.North + Direction.East;
			if (xC < xE)
				return Direction.North + Direction.West;
			if (xC == xE)
				return Direction.North;
		} else if (yC == yE)
			if (xC > xE)
				return Direction.East;
		if (xC < xE)
			return Direction.West;
		if (xC == xE)
			return Direction.None;

		return Direction.None;

	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(getX(), getY(), WIDTH, HEIGHT);
	}

	public Color getEnemyColor() {
		return c;
	}


}
