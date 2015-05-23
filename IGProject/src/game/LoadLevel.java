package game;

import game.objects.enemies.Enemy;

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
	private static int levelID;


	public static Level get(int ID) {
		try {
			levelID=ID;
			BufferedImage image = ImageIO.read(new File("levels/" + ID
					+ ".png"));

			int width = image.getWidth();
			int height = image.getHeight();

			Level level = new Level(width, height);
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


	public static Level getSavedLevel(String levelInfo) {

		String[] parts = levelInfo.split("\n");

		String saveIdLevel = parts[0];
		String[] characterPosition = parts[1].split("_");
		String[] cakesPositions = parts[2].split("_");
		String[] enemiesPositions = parts[3].split("_");


		levelID = Integer.parseInt(saveIdLevel);
		try {
			BufferedImage image = ImageIO.read(new File("levels/" + saveIdLevel
					+ ".png"));

			int width = image.getWidth();
			int height = image.getHeight();

			Level level = new Level(width, height);
			Color tile;
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					tile = new Color(image.getRGB(i, j), false);
					if (tile.equals(WALL))
						level.addTile(i * TILE_WIDTH, j * TILE_WIDTH);
				}
			}
			level.setCharacter(Integer.parseInt(characterPosition[0]), Integer.parseInt(characterPosition[1]));


			for (int i=0; i <cakesPositions.length; i=i+3) {
				level.addCake(Integer.parseInt(cakesPositions[i]),
						Integer.parseInt(cakesPositions[i+1]),
						Integer.parseInt(cakesPositions[i+2]));


			}

			for (int i=0; i <enemiesPositions.length; i=i+3) {
				level.addEnemy(Integer.parseInt(enemiesPositions[i]),
						Integer.parseInt(enemiesPositions[i+1]),
						Integer.parseInt(enemiesPositions[i+2]));


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




	public static int getLevelID(){
		return levelID;
	}

}
