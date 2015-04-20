package game;

import java.awt.Rectangle;

public class Enemy extends Dynamic {

	private static final int WIDTH = 32;
	private static final int HEIGHT = 32;


	public Enemy(int x, int y) {
		super(x * WIDTH, y * HEIGHT);
	}



	public void strategicMove(Level l){
		int dir  = determineDirection(l);
		this.move(dir, 2);
		
	}

	public int determineDirection(Level l){
		int dir  = Direction.None;
		Character c = l.getCharacter();
		int xC = c.getX();
		int yC = c.getY();

		int xE = this.getX();
		int yE = this.getY();
		
		
		if( yC > yE)
			return Direction.South;
		if( yC < yE)
			return Direction.North;
		
		if( xC > xE)
			return Direction.East;
		if( xC < xE)
			return Direction.West;
		
		
		
		return Direction.None;
		
	}




	@Override
	public Rectangle getBounds() {
		return new Rectangle(getX(), getY(), WIDTH, HEIGHT);
	}

}
