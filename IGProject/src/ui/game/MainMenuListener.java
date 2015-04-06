package ui.game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.event.ChangeListener;

import ui.Game;
import ui.config.MainMenu;

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