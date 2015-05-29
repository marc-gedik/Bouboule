package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.GameStateManager;

public class LoadMenuListener implements ActionListener {

	private GameStateManager gsm;
	private static String infoLevel = "";
	private static boolean loadRequested;
	private String[] save;

	public LoadMenuListener(GameStateManager gsm, String[] save) {
		this.gsm = gsm;
		this.save = save;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int n = Integer.parseInt(e.getActionCommand());
		infoLevel = save[n - 1];
		loadRequested = true;
		gsm.setState(GameStateManager.GAME);
	}

	public static String getInfoLevel() {
		return infoLevel;
	}
	
	public static boolean loadRequested(){
		boolean b = loadRequested;
		loadRequested = false;
		return b;
	}
}
