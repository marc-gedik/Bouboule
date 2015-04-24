package ui.game;

import game.Enemy;
import game.GameObject;
import game.Level;
import game.LoadLevel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
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
	private int tileSize = 32;
	private BufferedImage background;
	private Graphics2D bg;

	private BufferedImage[] cakeSprite ;
	private BufferedImage[] characterSprite ;




	public LevelRenderer(GameStateManager gsm) {
		super(gsm);
		init();

		level = LoadLevel.get("test");
		setDoubleBuffered(true);
		camera.setBounds(0, level.getWidth() * tileSize, 0, level.getHeight()
				* tileSize);
		// background = GraphicsEnvironment.getLocalGraphicsEnvironment()
		// .getDefaultScreenDevice().getDefaultConfiguration()
		// .createCompatibleImage(2000, 2000, Transparency.OPAQUE);
		background = GraphicsEnvironment
				.getLocalGraphicsEnvironment()
				.getDefaultScreenDevice()
				.getDefaultConfiguration()
				.createCompatibleImage(Game.WIDTH, Game.HEIGHT,
						Transparency.OPAQUE);

	}

	
	
	BufferedImage rotation(BufferedImage img, double rot){
		AffineTransform tx = new AffineTransform();
		tx.rotate(rot, img.getWidth() / 2, img.getHeight() / 2);

		AffineTransformOp op = new AffineTransformOp(tx,
				AffineTransformOp.TYPE_BILINEAR);
		img = op.filter(img, null);
		return img;

	}

	@Override
	public void init() {
		characterSprite = loadSource("img/character.png", 4);
		cakeSprite = loadSource("img/cakes.png", 16);


	}

	public BufferedImage[] loadSource(String fileName, int nbSprite){
		BufferedImage[] sprites= new BufferedImage[nbSprite];
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(fileName));
		} catch (IOException e) {
			System.out.println(e);
		}
		int width = img.getWidth();
		int height = img.getHeight();
		int widthSprite = width/nbSprite;

		for(int i = 0; i < nbSprite; i++)
			sprites[i]= img.getSubimage(i*widthSprite, 0, widthSprite, height);

		return sprites;


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

		bg = (Graphics2D) background.getGraphics();
		//bg.setPaint(Color.BLACK);
		bg.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		bg.translate(offsetX, offsetY);

		level.getCharacter().draw(this);

		bg.setPaint(Color.BLUE);
		for(GameObject gameObject : level.getGameObjects())
			gameObject.draw(this);

		g2d.drawImage(background, 0, 0, null);
		//g2d.drawImage(background.getScaledInstance(Game.WIDTH, Game.HEIGHT, Image.SCALE_SMOOTH), 0, 0, null);
	}

	public void drawCharacter(GameObject character) {
		bg.setPaint(Color.BLACK);
		bg.fill(level.getCharacter().getBounds());
	}

	public void drawTile(GameObject go) {
		bg.setPaint(Color.BLUE);
		bg.draw(go.getBounds());
	}

	public void drawCake(GameObject go) {
		bg.setPaint(Color.YELLOW);
		bg.fill(go.getBounds());
	}


	public void drawSpriteCake(GameObject go, int levelCake) {
		bg.drawImage(cakeSprite[levelCake], go.getX(), go.getY(), 64,64, this);
	}



	public void drawSpriteCharacter(GameObject go, int idSprite, double rot) {
			
		bg.drawImage(rotation(characterSprite[idSprite], rot), level.getCharacter().getX(), level.getCharacter().getY(), 64,64, this);
	}


	public void drawEnemy(GameObject go) {
		bg.setPaint(((Enemy) go).getEnemyColor());
		bg.fill(go.getBounds());
	}

	@Override
	public void update() {
		level.update();
	}

	@Override
	public void handleInput() {
	}

}
