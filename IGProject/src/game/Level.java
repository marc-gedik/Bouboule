package game;

import controler.Input;

public class Level {

	private Character character;
	private Enemy[] enemies;

	private int width, height;

	public Level() {
		character = new Character();
		width = 500;
		height = 50;
	}

	public void pause() {

	}

	public Character getCharacter() {
		return character;
	}

	public Enemy[] getEnemies() {
		return enemies;
	}

	public boolean isFinished() {
		return false;
	}

	public void update() {
		handleInput();
	}

	public void handleInput() {
		Input.update();
		int dir = handleMove();
		character.move(dir, 2);
	}

	private int handleMove() {
		int dir = Direction.None;
		if (Input.up())
			dir = dir | Direction.North;
		if (Input.down())
			dir = dir | Direction.South;
		if (Input.left())
			dir = dir | Direction.West;
		if (Input.right())
			dir = dir | Direction.East;
		return dir;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
