package utils;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AssetsManager {

	private HashMap<String, BufferedImage> images;
	private HashMap<String, AudioInputStream> sounds;

	public AssetsManager() {
		loadImages();
		loadSounds();
	}

	private void loadSounds() {
		sounds = new HashMap<String, AudioInputStream>();
		loadSound("MainMenu");
	}

	public void loadSound(String name) {
		try {
			AudioInputStream sound = AudioSystem.getAudioInputStream(new File("sound/" + name + ".wav"));
			sounds.put(name, sound);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void loadImages() {
		images = new HashMap<String, BufferedImage>();
		loadImage("character");
		loadImage("enemy_v1");
		loadImage("enemy_v2");
		loadImage("enemy_v3");
		loadImage("cakes");
		loadImage("wall_1");
		loadImage("floor_1");
		loadImage("wall_2");
		loadImage("floor_2");
		loadImage("wall_3");
		loadImage("floor_3");
	}

	private void loadImage(String name) {
		try {
			BufferedImage img = ImageIO.read(new File("img/" + name + ".png"));
			images.put(name, img);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public AudioInputStream getMusic(String key) { return sounds.get(key); }

	public BufferedImage getTexture(String key) {
		return images.get(key);
	}

	public BufferedImage[] getSprites(String key, int nbSprites) {
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
}
