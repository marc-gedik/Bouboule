package ui.config;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

import ui.Game;


@SuppressWarnings("serial")
public class DecoratedButton extends JButton {
	private boolean hover;
	static Image image;
	static Image selected;



	public DecoratedButton(String s) {
		super(Game.getConfig().getString(s));
		setFont(new Font("Helvetica", Font.BOLD, 18));   
		setForeground(Color.GRAY);

		setContentAreaFilled(false);
		setBorderPainted(false);
		setOpaque(true);

		addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				hover = true;
				repaint();
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				hover = false;
				repaint();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				hover = false;
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		Image img;
		if (!hover){
		//System.out.println("not hoouver");
		this.setBackground(Color.WHITE);	
		//g.setColor(Color.WHITE);
		}
		else{
			//System.out.println(" hoouver");
			this.setBackground(new Color(230,230,230));	
		}

		g.drawRect(0, 0, getWidth(), getHeight());
		super.paintComponent(g);

	}
}