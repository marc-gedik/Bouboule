package game;

import game.objects.Character;
import game.objects.Tile;
import game.objects.cakes.Cake;
import game.objects.cakes.CakeV1;
import game.objects.cakes.CakeV2;
import game.objects.cakes.CakeV3;
import game.objects.enemies.Boss;
import game.objects.enemies.Enemy;
import game.objects.enemies.EnemyV1;
import game.objects.enemies.EnemyV2;
import game.objects.enemies.EnemyV3;
import game.objects.weapons.Bullet;
import game.physics.Body;
import game.physics.BodyId;
import game.physics.BodyType;
import game.physics.ContactListener;
import game.physics.PhysicalWorld;

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
	private static List<Enemy> enemies;
	private List<Tile> tiles;
	private List<Cake> cakes;

	private List<Bullet> bullets;

	private int width, height;
	private boolean win;

	public Level(int width, int height) {
		this.width = width;
		this.height = height;

		world = new PhysicalWorld(width, height);
		contactListener = new ContactListener();
		world.addContactListener(contactListener);

		tiles = new LinkedList<Tile>();

		enemies = new ArrayList<Enemy>();
		bullets = new ArrayList<Bullet>();
		cakes = new ArrayList<Cake>();

	}

	public Character getCharacter() {
		return character;
	}

	public PhysicalWorld getWorld() {
		return world;
	}

	public boolean isFinished() {
		if (character.isDead()) {
			win = false;
			return true;
		} else if (enemies.size() == 0) {
			win = true;
			return true;
		}

		return false;
	}

	public void update(float dt) {
		handleInput();

		Queue<Body> bodies = contactListener.getBodiesToRemove();
		while (!bodies.isEmpty()) {
			Body body = bodies.poll();
			if (BodyId.isBullet(body.id))
				bullets.remove((Bullet) body.data);
			else if (BodyId.isCake(body.id))
				cakes.remove((Cake) body.data);

			world.remove(body);
		}
		Iterator<Enemy> iterator = enemies.iterator();
		while (iterator.hasNext()) {
			Enemy enemy = iterator.next();
			if (enemy.isDead()) {
				iterator.remove();
				world.remove(enemy.body);
				addCake(enemy.getX(), enemy.getY(), enemy.getVersion());
			} else {
				enemy.strategicMove(character);
				enemy.update(dt);
			}
		}
		character.update(dt);

		Iterator<Bullet> bulletIt = bullets.iterator();
		while (bulletIt.hasNext()) {
			Bullet bullet = bulletIt.next();
			if (bullet.remove()) {
				bulletIt.remove();
				world.remove(bullet.body);
			} else
				bullet.update(dt);
		}
	}

	public void handleInput() {
		Input.update();
		handleMove();
		if (Input.up())
			character.forward();
		if (Input.down())
			character.backward();
		handleShoot();
	}

	private void handleMove() {
		float dir = character.getAngle();
		if (Input.left())
			dir -= 4;
		if (Input.right())
			dir += 4;
		character.setAngle(dir);
	}

	private void handleShoot() {
		if (Input.action()) {
			character.shot(this);
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void addCake(float x, float y, int version) {
		Body body = new Body(x, y, 32, 32, true);
		body.type = BodyType.STATIC;
		body.id = BodyId.Cake;
		body.isSensor = true;
		world.addBody(body);
		Cake cake = null;
		switch (version) {
		case 1:
			cake = new CakeV1(body);
			break;
		case 2:
			cake = new CakeV2(body);
			break;
		case 3:
			cake = new CakeV3(body);
			break;
		}
		cakes.add(cake);
		body.data = cake;
	}

	public void addBullet(Bullet bullet) {
		world.addBody(bullet.body);
		bullets.add(bullet);
	}

	public void addTile(int x, int y) {
		Body body = new Body(x, y, 32, 32, true);
		body.type = BodyType.STATIC;
		body.id = BodyId.Wall;
		world.addBody(body);
		tiles.add(new Tile(body));
	}

	public void addEnemy(float x, float y, int version) {
		Body body = null;
		switch (version) {
		case 1:
		case 2:
		case 3:
			body = new Body(x, y, 32, 32, true);
			break;
		case 4:
			body = new Body(x, y, 64, 64, true);
			break;
		}
		body.type = BodyType.DYNAMIC;
		body.id = BodyId.Enemy;
		world.addBody(body);
		Enemy enemy = null;
		switch (version) {
		case 1:
			enemy = (new EnemyV1(body));
			break;
		case 2:
			enemy = (new EnemyV2(body));
			break;
		case 3:
			enemy = (new EnemyV3(body));
			break;
		case 4:
			enemy = new Boss(body);
			((Boss) enemy).setLevel(this);
			break;
		}
		body.data = enemy;
		enemies.add(enemy);
	}

	public List<Tile> getTiles() {
		return tiles;
	}

	public void setCharacter(Character character, float x, float y) {
		Body body = new Body(x, y, 20, 20, false);
		body.type = BodyType.DYNAMIC;
		body.id = BodyId.Character;
		world.addBody(body);
		character.setBody(body);
		this.character = character;
		body.data = character;
	}

	public List<Enemy> getEnemies() {
		return enemies;
	}

	public List<Cake> getCakes() {
		return cakes;
	}

	public List<Bullet> getBullets() {
		return bullets;
	}

	public boolean win() {
		return win;
	}

	public String saveLevel() {
		String infoLevel = "";
		infoLevel += LoadLevel.getLevelID() + "\n";

		infoLevel += character.getX() + "_" + character.getY() + "_"
				+ character.getPerCentLife() + "_" + character.getWeapon()
				+ "_" + character.getScore() + "_" + "\n";

		for (Cake c : cakes)
			infoLevel += c.getX() + "_" + c.getY() + "_" + c.getVersion() + "_";
		infoLevel += "\n";

		for (Enemy e : enemies)
			infoLevel += e.getX() + "_" + e.getY() + "_" + e.getVersion() + "_";

		return infoLevel;

	}

}
