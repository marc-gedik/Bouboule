package game;

import game.objects.Character;
import game.objects.weapons.Weapon;

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
	private static final Color BOSS = new Color(255, 255, 0);

	private static final int VERSION_1 = 1;
	private static final int VERSION_2 = 2;
	private static final int VERSION_3 = 3;
	private static final int VERSION_BOSS = 4;

	private static final int TILE_WIDTH = 32;
	private static int levelID;

	public static Level get(int ID, Character character) {
		try {
			levelID = ID;
			BufferedImage image = ImageIO
					.read(new File("levels/" + ID + ".png"));

			int width = image.getWidth();
			int height = image.getHeight();

			Level level = new Level(width, height);
			Color tile;
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					int x = i * TILE_WIDTH;
					int y = j * TILE_WIDTH;
					tile = new Color(image.getRGB(i, j), false);
					if (tile.equals(WALL))
						level.addTile(x, y);

					else if (tile.equals(PLAYER))
						level.setCharacter(character, x, y);
					else if (tile.equals(ENEMY_V1))
						level.addEnemy(x, y, 
								VERSION_1);
					else if (tile.equals(ENEMY_V2))
						level.addEnemy(x, y,
								VERSION_2);
					else if (tile.equals(ENEMY_V3))
						level.addEnemy(x, y,
								VERSION_3);
					else if(tile.equals(BOSS))
						level.addEnemy(x, y, VERSION_BOSS);

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

	public static Level getSavedLevel(String levelInfo, Character character) {

		String[] parts = levelInfo.split("\n");

		String saveIdLevel = parts[0];
		String[] characterPosition = parts[1].split("_");
		String[] cakesPositions = parts[2].split("_");

		String[] enemiesPositions = parts[3].split("_");

		levelID = Integer.parseInt(saveIdLevel);
		Levels.setLevel(levelID);
		System.out.println(saveIdLevel);
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

			level.setCharacter(character,
					Float.parseFloat(characterPosition[0]),
					Float.parseFloat(characterPosition[1]));
			level.getCharacter()
					.setLife(Float.parseFloat(characterPosition[2]));
			level.getCharacter()
					.setWeapon(Weapon.valueOf(characterPosition[3]));
			level.getCharacter().setScore(Long.parseLong(characterPosition[4]));

			if (cakesPositions.length >= 3) {
				for (int i = 0; i < cakesPositions.length; i = i + 3) {
					level.addCake(Float.parseFloat(cakesPositions[i]),
							Float.parseFloat(cakesPositions[i + 1]),
							Integer.parseInt(cakesPositions[i + 2]));

				}
			}
			for (int i = 0; i < enemiesPositions.length; i = i + 3) {
				level.addEnemy(Float.parseFloat(enemiesPositions[i]),
						Float.parseFloat(enemiesPositions[i + 1]),
						Integer.parseInt(enemiesPositions[i + 2]));

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

	public static int getLevelID() {
		return levelID;
	}

}
