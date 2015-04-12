package ui.config;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class DecoratedButton extends JButton {
	private boolean hover;
	private ButtonStyle style;

	public DecoratedButton(String s, ButtonStyle style) {
		super(s);
		this.style = style;
		init();

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

	public void init() {
		setFont(style.font());
		setForeground(style.foreground());
		setBackground(style.background());

		setContentAreaFilled(false);
		setBorderPainted(false);
		setFocusable(true);
		setOpaque(true);
	}

	protected void paintComponent(Graphics g) {
		if (hover)
			this.setBackground(style.onHover());
		else
			this.setBackground(style.background());

		super.paintComponent(g);
	}

	public void setHover(boolean hover) {
		this.hover = hover;
	}
}