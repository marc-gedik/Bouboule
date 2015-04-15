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
		switch(e.getActionCommand()){
		case "Jouer":
			System.out.println("Jouer");
			gsm.pushState(GameStateManager.GAME);
			break;
		case "Charger une partie":
			System.out.println("Charger une partie");
			gsm.pushState(GameStateManager.LOAD);
			break;
		case "Instructions":
			System.out.println("Instructions");
			gsm.pushState(GameStateManager.INSTRUCTIONS);

			break;
		
		case "Score":
			System.out.println("Score");
			gsm.pushState(GameStateManager.SCORES);

			break;
		}

	}
}