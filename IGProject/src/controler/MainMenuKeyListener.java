package controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import ui.GameStateManager;

public class MainMenuKeyListener implements KeyListener{

	JButton currentFocus;
	GameStateManager gsm;
	public MainMenuKeyListener(GameStateManager gsm) {
		this.gsm = gsm;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			System.out.println("entrer");
			gsm.pushState(MainMenuFocusListener.flag);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}