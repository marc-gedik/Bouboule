package ui.game;

import game.Dynamic;
import game.Enemy;
import game.GameObject;
import game.Level;
import game.LoadLevel;
import game.Static;
import game.Tile;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Transparency;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import ui.Game;
import ui.GameState;
import ui.GameStateManager;

public class LevelRenderer extends GameState {

	private Level level;
	private int tileSize = 48;
	private BufferedImage background;
	private Graphics2D bg;

	public LevelRenderer(GameStateManager gsm) {
		super(gsm);
		init();

		level = LoadLevel.get("level1");
		setDoubleBuffered(true);
		camera.setBounds(0, level.getWidth() * tileSize, 0, level.getHeight()
				* tileSize);
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();

		background = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getDefaultScreenDevice().getDefaultConfiguration()
				.createCompatibleImage(width, height, Transparency.OPAQUE);
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
	public void render(Graphics g) {
		if (g == null)
			return;
		float scaleX = Game.WIDTH / 800f;
		float scaleY = Game.WIDTH / 800f;

		camera.scale(scaleX, scaleY);
		camera.setPosition(level.getCharacter().getX(), level.getCharacter()
				.getY());
		float offsetX = -camera.getX() + Game.WIDTH / 2;
		float offsetY = -camera.getY() + Game.HEIGHT / 2;

		Graphics2D g2d = (Graphics2D) g;

		bg = (Graphics2D) background.getGraphics();
		bg.setPaint(Color.BLACK);
		bg.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

		bg.translate(offsetX, offsetY);
		bg.scale(scaleX, scaleY);

		BufferedImage floor = Game.assets.getTexture("floor_1");
		int iw = floor.getWidth();
		int ih = floor.getHeight(this);

		for (int x = 0; x < level.getWidth(); x++)
			for (int y = 0; y < level.getHeight(); y++)
				bg.drawImage(floor, x * iw, y * ih, iw, ih, this);

		for (Tile object : level.getTiles())
			draw(object);
		for (Enemy object : level.getEnemies())
			draw(object);

		draw(level.getCharacter());

		g2d.drawImage(background, 0, 0, null);
		// g2d.drawImage(background.getScaledInstance(Game.WIDTH, Game.HEIGHT,
		// Image.SCALE_SMOOTH), 0, 0, null);
	}

	private void draw(Static o) {
		BufferedImage img = o.getAnimation().getFrame();
		draw(o, img);
	}

	private void draw(Dynamic o) {
		BufferedImage img = o.getAnimation().getFrame();
		if (o.getAngle() != 0)
			img = rotate(img, o.getAngle());
		draw(o, img);
	}

	private void draw(GameObject o, BufferedImage img) {
		Rectangle bounds = o.bounds();
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
	}

	@Override
	public void handleInput() {
	}

}
