package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.GameStateManager;

public class BackButtonListener implements ActionListener{


	GameStateManager gsm;
	public BackButtonListener(GameStateManager gsm) {
		this.gsm =gsm;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		gsm.popState();
	}

}
