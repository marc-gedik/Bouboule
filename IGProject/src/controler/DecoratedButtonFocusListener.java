package controler;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;

import ui.config.DecoratedButton;

public class DecoratedButtonFocusListener implements FocusListener {

	@Override
	public void focusGained(FocusEvent e) {
		JButton currentFocus = (JButton) e.getSource();
		MainMenuKeyListener.setButton(currentFocus);
	}

	@Override
	public void focusLost(FocusEvent e) {
	}

}
