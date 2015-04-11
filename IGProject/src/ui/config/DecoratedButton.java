package ui.config;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.plaf.basic.BasicBorders;

import ui.Game;
import ui.GameStateManager;


@SuppressWarnings("serial")
public class DecoratedButton extends JButton {
	private boolean hover;
	static Image image;
	static Image selected;


	public DecoratedButton(String s, int style) {
		super(Game.getConfig().getString(s));
		if(style==1)
			setStyle1();
		if(style==2)
			setStyle2();



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



	public void setStyle1(){
		setFont(new Font("Helvetica", Font.BOLD, 18));   
		setForeground(Color.GRAY);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setFocusable(true);
		setOpaque(true);
	}


	public void setStyle2(){
		setFont(new Font("Helvetica", Font.BOLD, 16));   
		setForeground(Color.WHITE);
		this.setBackground(Color.BLACK);

		setContentAreaFilled(false);
		setBorderPainted(false);
		setFocusable(true);
		setOpaque(true);
	}


	@Override
	protected void paintComponent(Graphics g) {
		Image img;
		if (!isFocusOwner() && GameStateManager.CURRENT_SCREEN==GameStateManager.MAIN)
			this.setBackground(Color.WHITE);
		else if (!isFocusOwner() && GameStateManager.CURRENT_SCREEN==GameStateManager.INSTRUCTIONS)
			this.setBackground(Color.GRAY);

		else if (GameStateManager.CURRENT_SCREEN==GameStateManager.INSTRUCTIONS)
			this.setBackground(new Color(240,240,240));
		else if (GameStateManager.CURRENT_SCREEN==GameStateManager.MAIN)
			this.setBackground(new Color(240,240,240));



		super.paintComponent(g);

	}
}