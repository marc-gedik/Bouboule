package ui.config;

import java.awt.Graphics;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class DecoratedButton extends JButton {
	private ButtonStyle style;

	public DecoratedButton(String s, ButtonStyle style) {
		super(s);
		this.style = style;
		init();
		
		addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				requestFocus();
				repaint();
			}
		});
	}

	public void init() {
		setFont(style.font());
		setForeground(style.foreground());
		setBackground(style.background());
		
		setFocusPainted(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setFocusable(true);
		setOpaque(true);
	}

	protected void paintComponent(Graphics g) {
		if (isFocusOwner())
			this.setBackground(style.onHover());
		else
			this.setBackground(style.background());

		super.paintComponent(g);
	}

}