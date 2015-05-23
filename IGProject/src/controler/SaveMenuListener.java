package controler;

import game.Level;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.GameState;
import ui.GameStateManager;

public class SaveMenuListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Integer.parseInt(e.getActionCommand())) {
		case 1:
			System.out.println(Level.saveLevel());
			break;
		case 2:
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
