package controler;

import game.Level;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.GameState;
import ui.GameStateManager;
import ui.config.LoadMenu;

public class SaveMenuListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Integer.parseInt(e.getActionCommand())) {
		case 1:
			LoadMenu.getSave()[0]=Level.saveLevel();
			LoadMenu.getPref().put("save0",LoadMenu.getSave()[0]);
			break;
		case 2:
			LoadMenu.getSave()[1]=Level.saveLevel();
			LoadMenu.getPref().put("save1",LoadMenu.getSave()[1]);
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			break;
		case 10:
			break;
		case 11:
			break;
		case 12:
			break;
		case 13:
			break;
		case 14:
			break;
		case 15:
			break;

		default:
			break;
		}		
	}




}
