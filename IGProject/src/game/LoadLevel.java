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


	private static final Color ENEMY_V1 = new Color(255, 0, 0);
	private static final Color ENEMY_V2 = new Color(255, 100, 100);
	private static final Color ENEMY_V3 = new Color(255, 200, 200);
	
	private static final int VERSION_1 =1;
	private static final int VERSION_2 =2;
	private static final int VERSION_3 =3;


	private static final int TILE_WIDTH = 32;

	public static Level get(int levelID) {
		try {
			BufferedImage image = ImageIO.read(new File("levels/" + levelID
					+ ".png"));

			int width = image.getWidth();
			int height = image.getHeight();

			Level level = new Level(width, height);
			System.out.println("ICI1");
			level.addCake(10, 10, 1);
			System.out.println("IC2");
			Color tile;
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					tile = new Color(image.getRGB(i, j), false);
					if (tile.equals(WALL))
						level.addTile(i * TILE_WIDTH, j * TILE_WIDTH);

					else if (tile.equals(PLAYER))
						level.setCharacter(i * TILE_WIDTH, j * TILE_WIDTH);
					else if (tile.equals(ENEMY_V1))
						level.addEnemy(i * TILE_WIDTH, j * TILE_WIDTH, VERSION_1);
					else if (tile.equals(ENEMY_V2))
						level.addEnemy(i * TILE_WIDTH, j * TILE_WIDTH, VERSION_2);
					else if (tile.equals(ENEMY_V3))
						level.addEnemy(i * TILE_WIDTH, j * TILE_WIDTH, VERSION_3);
					
				}
			}
			System.out.println("mmmoider");
			level.addCake(10, 10, 1);
			System.out.println("coucou");

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
