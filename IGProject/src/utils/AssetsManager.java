package utils;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import javax.imageio.ImageIO;

import ui.Game;
import ui.Score;
import ui.config.ScoresMenu;

public class AssetsManager {

	private static ResourceBundle config;
	private static HashMap<String, BufferedImage> images;
	private static HashMap<String, File> sounds;
	private static Preferences preferences;

	static {
		loadBundle();
		loadPrefs();
		loadImages();
		loadSounds();
	}

	private static void loadBundle() {
		config = ResourceBundle.getBundle("config");
	}

	private static void loadPrefs() {
		preferences = Preferences.userNodeForPackage(Game.class);
		if (!preferences.getBoolean("created", false)) {
			preferences.putBoolean("created", true);
			String[] keys = { "Keys.Up", "Keys.Down", "Keys.Left",
					"Keys.Right", "Keys.Action", "Sound.Volume" };
			int[] values = { KeyEvent.VK_UP, KeyEvent.VK_DOWN,
					KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_SPACE, 3 };
			for (int i = 0; i < keys.length; i++)
				preferences.putInt(keys[i], values[i]);
			for (int i = 0; i < ScoresMenu.NB; i++)
				preferences.put("score" + i + ".name", "");
		}
		try {
			preferences.flush();
		} catch (BackingStoreException e) {
			e.printStackTrace();
		}
	}

	private static void loadSounds() {
		sounds = new HashMap<String, File>();
		loadSound("MainMenu");
		loadSound("SimpleShoot");
		loadSound("knife");
		loadSound("bolt");
		loadSound("flamethrower");
		loadSound("vomit");
		loadSound("knife");
		loadSound("flameThrower");
	}

	public static void loadSound(String name) {
		File file = new File("sound/" + name + ".wav");
		sounds.put(name, file);
	}

	private static void loadImages() {
		images = new HashMap<String, BufferedImage>();
		loadImage("character.png", "character");
		loadImage("bullet.png", "bullet");
		loadImage("empty_hearth.png", "empty_hearth");
		loadImage("full_hearth.png", "full_hearth");
		loadImage("flamethrower.png", "flamethrower");
		loadImage("bolt.png", "bolt");
		loadImage("cut.png", "cut");
		loadImage("vomit.png", "vomit");

		loadImage("enemy_v1.png", "enemy_v1");
		loadImage("enemy_v2.png", "enemy_v2");
		loadImage("enemy_v3.png", "enemy_v3");
		loadImage("fasto.png", "fasto");

		loadImage("cake_v1.png", "cake_v1");
		loadImage("cake_v2.png", "cake_v2");
		loadImage("cake_v3.png", "cake_v3");

		loadImage("back.png", "main", "sub");
		for (int i = 0; i < 4; i++) {
			loadImage("level" + i + ".png", "level" + i);
		}
	}

	private static void loadImage(String fileName, String... names) {
		try {
			BufferedImage img = ImageIO.read(new File("img/" + fileName));
			for (String name : names)
				images.put(name, img);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static File getMusic(String key) {
		return sounds.get(key);
	}

	public static BufferedImage getTexture(String key) {
		return images.get(key);
	}

	public static BufferedImage[] getSprites(String key, int nbSprites) {
		BufferedImage[] sprites = new BufferedImage[nbSprites];
		BufferedImage img = images.get(key);

		int width = img.getWidth();
		int height = img.getHeight();
		int widthSprite = width / nbSprites;

		for (int i = 0; i < nbSprites; i++)
			sprites[i] = img.getSubimage(i * widthSprite, 0, widthSprite,
					height);

		return sprites;
	}

	public static String getString(String key) {
		return config.getString(key);
	}

	public static int prefInt(String key) {
		return preferences.getInt(key, -1);
	}

	public static void intPref(String key, int value) {
		preferences.remove(key);
		preferences.putInt(key, value);
		try {
			preferences.flush();
		} catch (BackingStoreException e) {
			e.printStackTrace();
		}
	}

	public static List<Score> getScores() {
		List<Score> scores = new LinkedList<Score>();
		for (int i = 0; i < ScoresMenu.NB; i++) {
			String name = preferences.get("score" + i + ".name", "");
			Long score = preferences.getLong("score" + i + ".score", 0);
			if (!name.equals(""))
				scores.add(new Score(name, score));
		}
		return scores;
	}

	public static void addScore(Score newScore) {
		int i;
		for (i = 0; i < ScoresMenu.NB; i++) {
			Long score = preferences.getLong("score" + i + ".score", -1);
			if (score == -1 || newScore.better(score)) {
				decaleScore(i);
				preferences.put("score" + i + ".name", newScore.name);
				preferences.putLong("score" + i + ".score", newScore.score);
				break;
			}
		}
		try {
			preferences.flush();
		} catch (BackingStoreException e) {
			e.printStackTrace();
		}
	}

	private static void decaleScore(int from) {
		for (int j = ScoresMenu.NB - 1; j > from; j--) {
			String name = preferences.get("score" + (j - 1) + ".name", "");
			long score = preferences.getLong("score" + (j - 1) + ".score", -1);
			preferences.put("score" + j + ".name", name);
			preferences.putLong("score" + j + ".score", score);
		}
	}
}
