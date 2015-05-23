package controler;

import game.Level;
import game.LoadLevel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.Preferences;

import ui.GameStateManager;
import ui.config.LoadMenu;

public class LoadMenuListener  implements ActionListener {



	private GameStateManager gsm;
	private static String infoLevel="" ;
	private String []save;



	public LoadMenuListener(GameStateManager gsm, String[] save) {
		this.gsm = gsm;
		this.save=save;
	}






	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
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
			infoLevel=save[2];
			break;
		case 4:
			infoLevel=save[3];
			break;
		case 5:
			infoLevel=save[4];
			break;
		case 6:
			infoLevel=save[5];
			break;
		case 7:
			infoLevel=save[6];
			break;
		case 8:
			infoLevel=save[7];
			break;
		case 9:
			infoLevel=save[8];
			break;
		case 10:
			infoLevel=save[9];
			break;
		case 11:
			infoLevel=save[10];
			break;
		case 12:
			infoLevel=save[11];
			break;
		case 13:
			infoLevel=save[12];
			break;
		case 14:
			infoLevel=save[13];
			break;
		case 15:
			infoLevel=save[14];
			break;

		default:
			break;
		}
		gsm.pushState(GameStateManager.GAME);
	}



	public static String getInfoLevel(){
		return infoLevel;
	}
}
