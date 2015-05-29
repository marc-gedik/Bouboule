package controler;

import game.Conductor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ui.GameStateManager;

public class PlayMenuControler implements ActionListener {

	GameStateManager gsm;

	public PlayMenuControler(GameStateManager gsm) {
		this.gsm = gsm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if (s.equals("Menu.Game.New"))
			gsm.pushState(GameStateManager.GAME);
		else if (s.equals("Menu.Game.Restart")) {
			Conductor.reset();
			gsm.setState(GameStateManager.GAME);
		} else if (s.equals("Menu.Game.Pause"))
			gsm.pause();
		else if (s.equals("Menu.Game.Save"))
			gsm.pushState(GameStateManager.SAVE);
		else if (s.equals("Menu.Game.Load"))
			gsm.pushState(GameStateManager.LOAD);
		else if(s.equals("Menu.Game.MainMenu"))
			gsm.popState();
		else if (s.equals("Menu.Game.Exit"))
			System.exit(0);
		else if (s.equals("Menu.Config.Keys"))
			gsm.pushState(GameStateManager.KEYS);
		else if (s.equals("Menu.Config.Sound"))
			gsm.pushState(GameStateManager.SOUND);
		else if (s.equals("Menu.Help.Instruction"))
			gsm.pushState(GameStateManager.INSTRUCTIONS);
		else if (s.equals("Menu.Help.About"))
			JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
					"Projet d'interfaces graphiques presenté par :\n \n"
							+ "- Marc Gedik\n" + "- Safir Medjeber\n"
							+ "- Celia Hammouche\n \n" + "Juin 2015");

	}
}
