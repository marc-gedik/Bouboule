package ui.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.Game;

public class MainMenuListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		switch(e.getActionCommand()){
		case "Jouer":
			System.out.println("Jouer");
			new Game();
			break;
		case "Charger une partie":
			System.out.println("Charger une partie");
			break;
		case "Instructions":
			System.out.println("Instructions");
			break;
		
		case "Score":
			System.out.println("Score");
			break;
		}

	}
}