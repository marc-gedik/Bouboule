package controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;

public class MainMenuKeyListener implements KeyListener {

	private static JButton button;

	public MainMenuKeyListener() {
		// TODO Auto-generated constructor stub
	}

	public static void setButton(JButton button) {
		MainMenuKeyListener.button = button;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
			button.doClick();
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}