package ui.config;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Background extends JPanel {

	private Image img;
	private int x;
	private int y;

	public Background(ImageIcon img, int cx, int cy) {
		x=cx;
		y=cy;
		this.img = img.getImage();
		Dimension size = new Dimension(x, y);
		setPreferredSize(size);
		setMinimumSize(size);
	}



	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
	}

}