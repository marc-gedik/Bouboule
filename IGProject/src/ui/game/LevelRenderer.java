package ui.game;

import game.Level;
import game.Levels;
import game.LoadLevel;
import game.objects.Dynamic;
import game.objects.GameObject;
import game.objects.Tile;
import game.objects.cakes.Cake;
import game.objects.enemies.Enemy;
import game.objects.weapons.Bullet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Transparency;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.List;
import java.awt.geom.Rectangle2D.Float;

import ui.Game;
import ui.GameState;
import ui.GameStateManager;
import utils.AssetsManager;

public class LevelRenderer extends GameState {

	private Level level;
	private int tileSize = 48;
	private BufferedImage statics;
	private BufferedImage background;
	private Graphics2D bg;
	private Rectangle bgBounds;

	private HUD hud;

	public LevelRenderer(GameStateManager gsm) {
		super(gsm);
		init();

		level = LoadLevel.get(Levels.getLevel());
		camera.setBounds(0, level.getWidth() * tileSize, 0, level.getHeight()
				* tileSize);
		hud = new HUD(level);
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getDefaultScreenDevice();

		int width = Game.WIDTH;
		int height = Game.HEIGHT;

		background = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getDefaultScreenDevice().getDefaultConfiguration()
				.createCompatibleImage(width, height, Transparency.OPAQUE);

		createStatics();
	}

	private void createStatics() {
		statics = new BufferedImage(level.getWidth() * tileSize,
				level.getHeight() * tileSize, BufferedImage.TYPE_INT_RGB);
		BufferedImage floor = AssetsManager.getTexture("floor_"
				+ Levels.getLevel());
		BufferedImage wall = AssetsManager.getTexture("wall_"
				+ Levels.getLevel());

		int iw = floor.getWidth();
		int ih = floor.getHeight(this);

		Graphics2D g2d = (Graphics2D) statics.getGraphics();
		for (int x = 0; x < level.getWidth(); x++)
			for (int y = 0; y < level.getHeight(); y++)
				g2d.drawImage(floor, x * iw, y * ih, iw, ih, this);
		for (Tile o : level.getTiles()) {
			Float bounds = o.bounds();
			g2d.drawImage(
					wall,
					(int) (o.getX() - (wall.getWidth() - bounds.getWidth()) / 2),
					(int) (o.getY() - (wall.getHeight() - bounds.getHeight()) / 2),
					wall.getWidth(), wall.getHeight(), null);
		}
	}

	BufferedImage rotate(BufferedImage img, double rot) {
		AffineTransform tx = new AffineTransform();
		tx.rotate(Math.toRadians(rot), img.getWidth() / 2, img.getHeight() / 2);

		AffineTransformOp op = new AffineTransformOp(tx,
				AffineTransformOp.TYPE_BILINEAR);
		img = op.filter(img, null);
		return img;

	}

	@Override
	public void init() {

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		float scaleX = Game.WIDTH / 800f;
		float scaleY = Game.WIDTH / 800f;

		camera.scale(scaleX, scaleY);
		camera.setPosition(level.getCharacter().getX(), level.getCharacter()
				.getY());
		float offsetX = -camera.getX() + Game.WIDTH / 2;
		float offsetY = -camera.getY() + Game.HEIGHT / 2;

		Graphics2D g2d = (Graphics2D) g;

		bg = (Graphics2D) background.getGraphics();
		bgBounds = new Rectangle((int) camera.getX() - Game.WIDTH / 2,
				(int) camera.getY() - Game.HEIGHT / 2, Game.WIDTH, Game.HEIGHT);
		bg.setPaint(Color.BLACK);
		bg.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

		bg.translate(offsetX, offsetY);
		bg.scale(scaleX, scaleY);

		bg.drawImage(statics, 0, 0, null);

		drawCake();

		List<Enemy> enemies = level.getEnemies();
		for (int i = 0; i < enemies.size(); i++)
			draw(enemies.get(i));

		draw(level.getCharacter());

		List<Bullet> bullets = level.getBullets();
		for (int i = 0; i < bullets.size(); i++)
			draw(bullets.get(i));

		bg.translate(-offsetX, -offsetY);
		hud.paint(bg);
		g2d.drawImage(background, 0, 0, null);
		bg.dispose();
	}

	private void draw(Dynamic o) {
		BufferedImage img = o.getAnimation().getFrame();
		Float bounds = o.bounds();
		if (bounds.intersects(bgBounds)) {
			img = rotate(img, o.getAngle()+90);
			draw(o, img);
		}
	}

	private void drawCake() {
		for (Cake c : level.getCakes()) {
			draw(c, c.getImg());
		}

	}

	private void draw(GameObject o, BufferedImage img) {
		Float bounds = o.bounds();
		bg.drawImage(img,
				(int) (o.getX() - (img.getWidth() - bounds.getWidth()) / 2),
				(int) (o.getY() - (img.getHeight() - bounds.getHeight()) / 2),
				img.getWidth(), img.getHeight(), null);
		if (debug) {
			bg.draw(bounds);
		}
	}

	@Override
	public void update(float dt) {
		level.update(dt);
		if (level.isFinished()) {
			if (level.win()) {
				if (Levels.hasNext()) {
					Levels.next();
					gsm.setState(GameStateManager.GAME);
				} else
					gsm.setState(GameStateManager.MAIN);
			} else
				gsm.setState(GameStateManager.GAMEOVER);
		}
	}

	@Override
	public void handleInput() {
	}

}
