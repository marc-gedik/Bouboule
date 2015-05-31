package utils;

import java.awt.AWTKeyStroke;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

import javax.swing.KeyStroke;

public class UIUtils {

	public static final Set<AWTKeyStroke> UP;
	public static final Set<AWTKeyStroke> DOWN;
	public static final Set<AWTKeyStroke> LEFT;
	public static final Set<AWTKeyStroke> RIGHT;
	static {
		UP = new HashSet<AWTKeyStroke>();
		DOWN = new HashSet<AWTKeyStroke>();
		LEFT = new HashSet<AWTKeyStroke>();
		RIGHT = new HashSet<AWTKeyStroke>();
		
		DOWN.add(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0));
		UP.add(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0));
		LEFT.add(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0));
		RIGHT.add(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0));
	}

}
