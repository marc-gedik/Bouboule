package ui.config;

import java.awt.AWTKeyStroke;
import java.awt.Graphics;
import java.awt.KeyboardFocusManager;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.util.Set;

import javax.swing.JButton;

import controler.MainMenuFocusListener;
import controler.MainMenuKeyListener;

@SuppressWarnings("serial")
public class DecoratedButton extends JButton {
	private ButtonStyle style;
	
	private static FocusListener focusListener= new MainMenuFocusListener();
	private static KeyListener keyListener = new MainMenuKeyListener();
	
	public DecoratedButton(String s, ButtonStyle style) {
		super(s);
		this.style = style;
		init();

		addFocusListener(focusListener);
		addKeyListener(keyListener);
		addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				requestFocus();
				repaint();
			}
		});
	}

	public DecoratedButton(String s, ButtonStyle style,
			Set<AWTKeyStroke> downKeys, Set<AWTKeyStroke> upKeys) {
		this(s, style);

		int down = KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS;
		int up = KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS;
		downKeys.addAll(getFocusTraversalKeys(down));
		upKeys.addAll(getFocusTraversalKeys(up));
		setFocusTraversalKeys(down, downKeys);
		setFocusTraversalKeys(up, upKeys);
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