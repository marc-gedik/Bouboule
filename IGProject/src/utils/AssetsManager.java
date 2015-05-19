package utils;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import javax.imageio.ImageIO;
import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import controler.KeysOption;
import ui.Game;

public class AssetsManager {

	private static ResourceBundle config;
	private static HashMap<String, BufferedImage> images;
	private static HashMap<String, AudioInputStream> sounds;
	private static Preferences preferences;

	static {
		System.out.println("ok");
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
		try {
			if (!preferences.getBoolean("created", false)) {
				preferences.putBoolean("created", true);
				String[] keys = { "Keys.Up", "Keys.Down", "Keys.Left",
						"Keys.Right", "Keys.Action", "Sound.Volume" };
				int[] values = { KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT,
						KeyEvent.VK_RIGHT, KeyEvent.VK_SPACE, 3 };
				for(int i = 0; i < keys.length; i ++)
					preferences.putInt(keys[i], values[i]);

			}
			preferences.flush();
		} catch (BackingStoreException e) {
			e.printStackTrace();
		}
	}

	private static void loadSounds() {
		sounds = new HashMap<String, AudioInputStream>();
		loadSound("MainMenu");
		loadSound("SimpleShoot");
	}

	public static void loadSound(String name) {
		try {
			AudioInputStream sound = AudioSystem.getAudioInputStream(new File(
					"sound/" + name + ".wav"));
			sounds.put(name, sound);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void loadImages() {
		images = new HashMap<String, BufferedImage>();
		loadImage("character");
		loadImage("enemy_v1");
		loadImage("enemy_v2");
		loadImage("enemy_v3");
		loadImage("cakes");
		loadImage("bullet");
		for (int i = 0; i < 3; i++) {
			loadImage("wall_" + i);
			loadImage("floor_" + i);
		}
	}

	private static void loadImage(String name) {
		try {
			BufferedImage img = ImageIO.read(new File("img/" + name + ".png"));
			images.put(name, img);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static AudioInputStream getMusic(String key) {
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
}
