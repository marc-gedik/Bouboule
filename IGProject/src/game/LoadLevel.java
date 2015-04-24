package game;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LoadLevel {

	private static final Color WALL = Color.BLACK;
	private static final Color PLAYER = Color.GREEN;
	private static final Color CAKE_V1 =  new Color(255, 255, 0);
	private static final Color CAKE_V2 =  new Color(255, 230, 120);
	private static final Color CAKE_V3 =  new Color(255, 200, 120);

	private static final Color ENEMY_V1 = new Color(255, 0, 0);
	private static final Color ENEMY_V2 =  new Color(255, 100, 100);
	private static final Color ENEMY_V3 =  new Color(255, 200, 200);


	public static Level get(String levelID) {
		try {
			BufferedImage image = ImageIO.read(new File("levels/" + levelID + ".png"));

			int width = image.getWidth();
			int height = image.getHeight();

			Level level = new Level(width, height);
			Color tile;
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					tile = new Color(image.getRGB(i, j), false);
					if (tile.equals(WALL))
						level.addObject(new Tile(i, j));
					else if (tile.equals(CAKE_V1))
						level.addObject(new Cake(i, j, 1));
					else if (tile.equals(CAKE_V2))
						level.addObject(new Cake(i, j, 2));
					else if (tile.equals(CAKE_V3))
						level.addObject(new Cake(i, j, 3));
					else if (tile.equals(PLAYER))
						level.setCharacter(new Character(i, j));
					else if (tile.equals(ENEMY_V1)){
						level.setEnemy(new Enemy(i, j, ENEMY_V1));	
						level.addObject(level.getLastEnemy());
					}
					else if (tile.equals(ENEMY_V2)){
						level.setEnemy(new Enemy(i, j, ENEMY_V2));
						level.addObject(level.getLastEnemy());
					}
					else if (tile.equals(ENEMY_V3)){
						level.setEnemy(new Enemy(i, j, ENEMY_V3));
						level.addObject(level.getLastEnemy());

					}
				}
			}
			return level;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
