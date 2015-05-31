package ui.config;

import javax.swing.JComponent;

import ui.GameState;
import ui.GameStateManager;

public abstract class Menu extends GameState {

	protected Menu(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public boolean requestFocusInWindow() {
		boolean b = super.requestFocusInWindow();
		if(getFirstFocus() != null)
			getFirstFocus().requestFocusInWindow();
		return b;
	}

	protected abstract JComponent getFirstFocus();
}
