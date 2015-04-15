package controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameControler implements KeyListener {

	public GameControler() {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Input.keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Input.keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent event) {
	}

}
