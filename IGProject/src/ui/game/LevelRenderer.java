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
	private int tileSize = 48;
	private BufferedImage background;
	private Graphics2D bg;

	private BufferedImage[] cakeSprite ;
	private BufferedImage[] wallSprite ;
	private BufferedImage[] floorSprite ;

	
	private BufferedImage[] characterSprite ;
	private BufferedImage[] enemy_v1Sprite ;
	private BufferedImage[] enemy_v2Sprite ;


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
		enemy_v1Sprite = loadSource("img/ennemy_v1.png", 4);
		enemy_v2Sprite = loadSource("img/ennemy_v2.png", 4);

		cakeSprite = loadSource("img/cakes.png", 16);
		wallSprite = loadSource("img/wall_1.png", 1);
		floorSprite = loadSource("img/floor_1.png",1);

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
		bg.drawImage(floorSprite[0], 0, 0, getWidth(), getHeight(), this);
		bg.translate(offsetX, offsetY);

		bg.setPaint(Color.BLUE);
		for (GameObject object : level.getTiles()) 
			object.draw(this);
		for (GameObject object : level.getEnemies()) 
			object.draw(this);

		level.getCharacter().draw(this);

		g2d.drawImage(background, 0, 0, null);
		// g2d.drawImage(background.getScaledInstance(Game.WIDTH, Game.HEIGHT,
		// Image.SCALE_SMOOTH), 0, 0, null);
	}

	public void drawCharacter(GameObject go) {
		bg.setPaint(Color.WHITE);
		bg.fillRect(go.getX(), go.getY(), 32, 32);
	}

	public void drawTile(GameObject go) {
		bg.setPaint(Color.BLUE);
		bg.drawRect(go.getX(), go.getY(), 32, 32);
	}

	public void drawCake(GameObject go) {
		bg.setPaint(Color.YELLOW);
		bg.fillRect(go.getX(), go.getY(), 32, 32);
	}

	

	public void drawSpriteEnemy(GameObject go,int idSprite, double rotation, int levelEnemy) {
		switch(levelEnemy){
		case 1:
			bg.drawImage(rotation(enemy_v1Sprite[idSprite], rotation), go.getX(), go.getY(), 48,48, this);
			break;
		case 2:	
			bg.drawImage(rotation(enemy_v2Sprite[idSprite], rotation), go.getX(), go.getY(), 48,48, this);
			break;
		case 3:	
			bg.drawImage(rotation(enemy_v2Sprite[idSprite], rotation), go.getX(), go.getY(), 48,48, this);
			break;
		
		}
	}


	public void drawSpriteCake(GameObject go, int levelCake) {
		bg.drawImage(cakeSprite[levelCake], go.getX(), go.getY(), 48, 48, this);
	}

	public void drawSpriteTile(GameObject go) {
		bg.drawImage(wallSprite[0], go.getX(), go.getY(), 32, 32, this);
	}

	public void drawSpriteCharacter(GameObject go, int idSprite, double rot) {
		bg.drawImage(rotation(characterSprite[idSprite], rot), level.getCharacter().getX(), level.getCharacter().getY(), 48, 48, this);
	}


	public void drawEnemy(GameObject go) {
		bg.fillRect(go.getX(), go.getY(), 32, 32);
	}

	@Override
	public void update() {
		level.update();
	}

	@Override
	public void handleInput() {
	}

}
