package game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import controler.Input;

public class Level {

	private PhysicalWorld world;
	private ContactListener contactListener;

	private Character character;
	private List<Enemy> enemies;
	private List<Tile> tiles;
	private List<Bullet> bullets;

	private int width, height;

	public Level(int width, int height) {
		this.width = width;
		this.height = height;

		world = new PhysicalWorld(width, height);
		contactListener = new ContactListener();
		world.addContactListener(contactListener);

		tiles = new LinkedList<Tile>();
		enemies = new LinkedList<Enemy>();
		bullets = new ArrayList<Bullet>();

	}

	public Character getCharacter() {
		return character;
	}

	public PhysicalWorld getWorld() {
		return world;
	}

	public boolean isFinished() {
		return false;
	}

	public void update(float dt) {
		handleInput();
		Queue<Body> bodies = contactListener.getBodiesToRemove();
		while (!bodies.isEmpty()) {
			Body body = bodies.poll();
			if (BodyId.isBullet(body.id))
				bullets.remove((Bullet) body.data);
			world.remove(body);
		}
		for (Enemy enemy : enemies) {
			enemy.strategicMove(character);
			enemy.update(dt);
		}
		character.update(dt);

		for (Bullet bullet : bullets) {
			bullet.move(bullet.getDirection(), 10);
			bullet.update(dt);
		}
	}

	public void handleInput() {
		Input.update();
		int dir = handleMove();
		character.move(dir, 4);
		for (Enemy enemy : enemies)
			enemy.strategicMove(character);
		handleShoot();
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

	private void handleShoot() {
		if (Input.action()) {
			Bullet b = addBullet(character.getX() + 7, character.getY() + 7,
					character);
			bullets.add( b);
		}

	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void addCake(int x, int y, int i) {

	}

	public Bullet addBullet(int x, int y, Character character) {
		Body body = new Body(x, y, 5, 5, false);
		body.type = BodyType.DYNAMIC;
		body.id = BodyId.Bullet;
		world.addBody(body);
		Bullet bullet = new Bullet(body, character);
		body.data = bullet;
		return bullet;

	}

	public void addTile(int x, int y) {
		Body body = new Body(x, y, 32, 32, true);
		body.type = BodyType.STATIC;
		body.id = BodyId.Wall;
		world.addBody(body);
		tiles.add(new Tile(body));
	}

	public void addEnemy(int x, int y, int i, int version) {
		Body body = new Body(x, y, 32, 32, true);
		body.type = BodyType.DYNAMIC;
		body.id = BodyId.Enemy;
		world.addBody(body);
		switch (version) {
		case 1:
			enemies.add(new EnemyV1(body, i));
			break;
		case 2:
			enemies.add(new EnemyV2(body, i));
			break;
		case 3:
			enemies.add(new EnemyV3(body, i));
			break;
		}
	}

	public List<Tile> getTiles() {
		return tiles;
	}

	public void setCharacter(int x, int y) {
		Body body = new Body(x, y, 20, 20, false);
		body.type = BodyType.DYNAMIC;
		body.id = BodyId.Character;
		world.addBody(body);
		character = new Character(body);
	}

	public List<Enemy> getEnemies() {
		return enemies;
	}

	public List<Bullet> getBullets() {
		return bullets;
	}

}
