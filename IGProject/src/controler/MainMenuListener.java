package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.GameStateManager;

public class MainMenuListener implements ActionListener {

	GameStateManager gsm;

	public MainMenuListener(GameStateManager gsm) {
		this.gsm = gsm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("MainMenu.play"))
			gsm.pushState(GameStateManager.GAME);
		else if (e.getActionCommand().equals("MainMenu.load"))
			gsm.pushState(GameStateManager.LOAD);
		else if (e.getActionCommand().equals("MainMenu.instructions"))
			gsm.pushState(GameStateManager.INSTRUCTIONS);
		else if (e.getActionCommand().equals("MainMenu.score"))
			gsm.pushState(GameStateManager.SCORES);

	}
}