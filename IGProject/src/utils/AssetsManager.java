package utils;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.print.attribute.standard.Media;

public class AssetsManager {

	private HashMap<String, BufferedImage> images;
	private HashMap<String, Media> sounds;

	public AssetsManager() {
		loadImages();
		loadSounds();
	}

	private void loadSounds() {
		sounds = new HashMap<String, Media>();
	}

	private void loadImages() {
		images = new HashMap<String, BufferedImage>();
		loadImage("character");
		loadImage("enemy_v1");
		loadImage("ennemy_v2");
		loadImage("cakes");
		loadImage("wall_1");
		loadImage("floor_1");
	}

	private void loadImage(String name) {
		try {
			BufferedImage img = ImageIO.read(new File("img/" + name + ".png"));
			images.put(name, img);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

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
