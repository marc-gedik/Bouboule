package controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import ui.GameStateManager;

public class MainMenuKeyListener implements KeyListener {

	private static JButton button;

	public static void setButton(JButton button) {
		MainMenuKeyListener.button = button;
	}
	
	public MainMenuKeyListener() {
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			button.doClick();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}