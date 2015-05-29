package controler;

import game.Level;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.config.LoadMenu;

public class SaveMenuListener implements ActionListener {

	private Level level;

	public void setLevel(Level level){
		this.level = level;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int n = Integer.parseInt(e.getActionCommand()) - 1;
		LoadMenu.getSave()[n] = level.saveLevel();
		LoadMenu.getPref().put("save" + n, LoadMenu.getSave()[n]);
	}

}
