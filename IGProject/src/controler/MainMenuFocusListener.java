package controler;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;

import ui.config.DecoratedButton;

public class MainMenuFocusListener implements FocusListener {

	@Override
	public void focusGained(FocusEvent e) {

		JButton currentFocus = (DecoratedButton) e.getSource();
		MainMenuKeyListener.setButton(currentFocus);
		/*
		 * String s = currentFocus.getActionCommand(); if
		 * (s.equals(Game.getConfig().getString("MainMenu.play"))) { } else if
		 * (s.equals(Game.getConfig().getString("MainMenu.load"))) {
		 * System.out.println("lancer load"); } else if (s
		 * .equals(Game.getConfig().getString("MainMenu.instructions"))) {
		 * System.out.println("lancer instructions"); } else if
		 * (s.equals(Game.getConfig().getString("MainMenu.score"))) {
		 * System.out.println("lancer scores");
		 * 
		 * }
		 */
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}

}
