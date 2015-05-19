package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.GameStateManager;

public class GameOverListener implements ActionListener {

	private GameStateManager gsm;

	public GameOverListener(GameStateManager gsm) {
		this.gsm = gsm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("GameOver.Restart"))
			gsm.setState(GameStateManager.GAME);
		else if (e.getActionCommand().equals("GameOver.Menu"))
			gsm.popState();
	}
}
