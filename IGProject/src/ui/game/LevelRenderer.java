package ui.game;

import game.GameObject;
import game.Level;
import game.Levels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Transparency;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import ui.Game;
import ui.GameState;
import ui.GameStateManager;

public class LevelRenderer extends GameState {

	private Level level;
	private int tileSize = 32;
	private BufferedImage background;

	public LevelRenderer(GameStateManager gsm) {
		super(gsm);

		level = Levels.get("test");
		setDoubleBuffered(true);
		camera.setBounds(0, level.getWidth() * tileSize, 0, level.getHeight()
				* tileSize);
		background = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getDefaultScreenDevice().getDefaultConfiguration()
				.createCompatibleImage(Game.WIDTH, Game.HEIGHT, Transparency.OPAQUE);
	}

	@Override
	public void init() {
	}

	@Override
	public void render(Graphics g) {
		if (g == null)
			return;
		camera.setPosition(level.getCharacter().getX(), level.getCharacter()
				.getY());
		float offsetX = -camera.getX() + Game.WIDTH / 2;
		float offsetY = -camera.getY() + Game.HEIGHT / 2;
		
		Graphics2D g2d = (Graphics2D) g;
		
		Graphics2D bg = (Graphics2D) background.getGraphics();
		bg.setPaint(Color.BLACK);
		bg.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		bg.translate(offsetX, offsetY);
		
		bg.setPaint(Color.WHITE);
		bg.draw(level.getCharacter().getBounds());
		
		bg.setPaint(Color.RED);
		for(GameObject gameObject : level.getGameObjects())
			bg.draw(gameObject.getBounds());
		
		g2d.drawImage(background, 0, 0, null);
	}

	@Override
	public void update() {
		level.update();
	}

	@Override
	public void handleInput() {
	}

}
