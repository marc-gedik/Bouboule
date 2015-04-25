package game;

import java.awt.Color;
import java.awt.Rectangle;

import ui.game.LevelRenderer;

public class Enemy extends Dynamic {

	private static final int WIDTH = 32;
	private static final int HEIGHT = 32;
	private int levelEnemy;
	public static int nbEnemy = 0;

	public Enemy(int x, int y) {
		super(x * WIDTH, y * HEIGHT);
		nbEnemy++;
		System.out.println(nbEnemy);

	}

	
	
	public Enemy(int x, int y, int levelEnemy) {
		super(x * WIDTH, y * HEIGHT);
		this.levelEnemy=levelEnemy;
		System.out.println(levelEnemy);
		nbEnemy++;
	}

	
	public void strategicMove(Level l) {
		int dir = determineDirection(l);
		this.move(dir, 1);

	}

	
	
	public int determineDirection(Level l) {
		Character c = l.getCharacter();
		int xC = c.getX();
		int yC = c.getY();
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

	@Override
	public Rectangle getBounds() {
		return new Rectangle(getX(), getY(), WIDTH, HEIGHT);
	}

	
	@Override
	public void draw(LevelRenderer renderer) {
		renderer.drawSpriteEnemy(this, idSprite, rotation, levelEnemy);
	}

}
