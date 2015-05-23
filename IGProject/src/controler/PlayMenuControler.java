package controler;

import ui.Game;
import ui.GameStateManager;
import game.Level;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayMenuControler implements ActionListener {

	GameStateManager gsm;

	public PlayMenuControler(GameStateManager gsm) {
		this.gsm = gsm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Menu.Game.New":
			System.out.println("New");
			gsm.pushState(GameStateManager.GAME);
			break;
		case "Menu.Game.Restart":
			System.out.println("Restart");
			break;
		case "Menu.Game.Pause":
			System.out.println("Pause");
			break;
		case "Menu.Game.Resume":
			System.out.println("Resume");
			break;
		case "Menu.Game.Save":
			System.out.println("Save");
			gsm.pushState(GameStateManager.SAVE);
			
			
			break;
		case "Menu.Game.Load":
			System.out.println("Load");
			gsm.pushState(GameStateManager.LOAD);
			break;
		case "Menu.Game.Exit":
			System.out.println("Exit");
			System.exit(0);
			break;
		case "Menu.Config.Keys":
			System.out.println("Keys");
			gsm.pushState(GameStateManager.KEYS);
			break;
		case "Menu.Config.Sound":
			System.out.println("Sound");
			gsm.pushState(GameStateManager.SOUND);
			break;
		case "Menu.Help.Instruction":
			System.out.println("Instructions");
			gsm.pushState(GameStateManager.INSTRUCTIONS);
			break;
		case "Menu.Help.About":
			System.out.println("About");
			JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
					"Projet d'interfaces graphiques present� par :\n \n" +
							"- Marc Gedik\n" +
							"- Safir Medjeber\n" +
							"- Celia Hammouche\n \n" +
					"Juin 2015");
			break;
		}

	}
}
