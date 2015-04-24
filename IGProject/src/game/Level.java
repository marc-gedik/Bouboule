package game;

import java.util.LinkedList;
import java.util.List;

import controler.Input;

public class Level {

	private Character character;
	private Enemy[] enemy = new Enemy[10];

	private List<GameObject> gameObjects;
	private int width, height;

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		gameObjects = new LinkedList<GameObject>();
	}

	public void addObject(GameObject object) {
		gameObjects.add(object);
	}

	public Enemy[] getEnemy(){
		return enemy;
	}
	public Enemy getLastEnemy(){
		return enemy[Enemy.nbEnemy-1];
	}
	
	public Character getCharacter() {
		return character;
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
		character.move(dir, 4);
		for (int i = 0; i < Enemy.nbEnemy; i++) {
			enemy[i].strategicMove(this);
		}
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

	public void setCharacter(Character character) {
		this.character = character;
	}

	
	public void setEnemy(Enemy enemy) {
		this.enemy[Enemy.nbEnemy-1] = enemy;

	}

	
	public List<GameObject> getGameObjects() {
		return gameObjects;
	}

}
