package ui.config;

import java.awt.AWTKeyStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.KeyboardFocusManager;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class ImageButton extends JButton {

	
	public ImageButton(String icon, String over, String name, Set<AWTKeyStroke> forward, Set<AWTKeyStroke> backward) {
		this(icon, over, name);

		int down = KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS;
		int up = KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS;
		forward.addAll(getFocusTraversalKeys(down));
		backward.addAll(getFocusTraversalKeys(up));
		setFocusTraversalKeys(down, forward);
		setFocusTraversalKeys(up, backward);
		setFocusable(true);
	}
	
	public ImageButton(String icon, String over, String name) {
		super(new ImageIcon(icon));
		setText(name);
		Font f = new Font("Helvetica", 0, 22);
		setForeground(Color.GRAY);
		setFont(f);

		setHorizontalTextPosition(SwingConstants.CENTER);
		setVerticalTextPosition(SwingConstants.CENTER);
		setRolloverIcon(new ImageIcon(over));
		setActionCommand(name);
		setOpaque(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
	}
}
