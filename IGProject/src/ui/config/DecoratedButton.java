package ui.config;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.plaf.basic.BasicBorders;

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
		setFocusable(true);
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
		if (!isFocusOwner()){
			this.setBackground(Color.WHITE);
			
			//System.out.println("mon focuse");
		}
		else{

			this.setBackground(new Color(240,240,240));

		}

		super.paintComponent(g);

	}
}