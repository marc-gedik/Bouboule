package ui.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import utils.AssetsManager;
import game.Level;

public class HUD {

	private Level level;

	public HUD(Level level) {
		this.level = level;
	}

	void paint(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.drawImage(AssetsManager.getTexture("empty_hearth"), 0, 0, null);
		float perCent = level.getCharacter().getPerCentLife();
		BufferedImage img = AssetsManager.getTexture("full_hearth");
		g.drawImage(img, 0, 0, (int) (img.getWidth() * perCent), 64, 0, 0,
				(int) (img.getWidth() * perCent), 64, null);
		if (level.getCharacter().charging()) {
			Font currentFont = g.getFont();
			Font newFont = currentFont.deriveFont(currentFont.getSize() * 2f);
			g.setFont(newFont);

			g.drawString(AssetsManager.getString("Game.Reloading"), 200, img.getHeight());
		}
	}
}
