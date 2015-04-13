package controler;

import ui.GameStateManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayMenuControler implements ActionListener {

	GameStateManager gsm;

	public PlayMenuControler(GameStateManager gsm) {
		this.gsm = gsm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "Menu.Game.New":
				System.out.println("New");
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
				break;
			case "Menu.Game.Load":
				System.out.println("Load");
				break;
			case "Menu.Game.Exit":
				System.out.println("Exit");
				break;
			case "Menu.Config.Keys":
				System.out.println("Keys");
				gsm.pushState(GameStateManager.KEYS);
				break;
		}

		}
	}
