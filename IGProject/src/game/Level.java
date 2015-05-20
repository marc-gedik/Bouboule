package game;

import game.objects.Bullet;
import game.objects.Cake;
import game.objects.CakeV1;
import game.objects.Character;
import game.objects.Enemy;
import game.objects.EnemyV1;
import game.objects.EnemyV2;
import game.objects.EnemyV3;
import game.objects.Tile;
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
	private List<Enemy> enemies;
	private List<Tile> tiles;
	private List<Cake> cakes;

	private List<Bullet> bullets;

	private int width, height;
	private boolean win;

	public Level(int width, int height) {
		this.width = width;
		this.height = height;

		world = new PhysicalWorld(width, height);
		contactListener = new ContactListener(this);
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
		if(character.isDead()){
			win = false;
			return true;
		}
		else if(enemies.size() == 0){
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
			world.remove(body);
		}
		Iterator<Enemy> iterator = enemies.iterator();
		while (iterator.hasNext()) {
			Enemy enemy = iterator.next();
			if (enemy.isDead()){
				iterator.remove();
				world.remove(enemy.body);
			}
			else {
				enemy.strategicMove(character);
				enemy.update(dt);
			}
		}
		character.update(dt);

		for (Bullet bullet : bullets)
			bullet.update(dt);

	}	

	public void handleInput() {
		Input.update();
		int dir = handleMove();
		character.move(dir);
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
			bullets.add(b);
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void addCake(int x, int y, int version) {
		Body body = new Body(x, y, 32, 32, true);
		body.type = BodyType.STATIC;
	//	body.id = BodyId.Wall;
		world.addBody(body);
		//if( version==1)
		cakes.add(new CakeV1(body));
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

	public void addEnemy(int x, int y, int version) {
		Body body = new Body(x, y, 32, 32, true);
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
		}
		body.data = enemy;
		enemies.add(enemy);
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

}
