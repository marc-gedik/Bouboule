package ui.config;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import ui.GameState;
import ui.GameStateManager;
import utils.AssetsManager;
import utils.UIUtils;
import controler.MainMenuListener;

public class MainMenu extends GameState {

	private MainMenuListener action;
	private Component focus;

	public MainMenu(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		action = new MainMenuListener(gsm);

		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		position(gbc, 0, 0, 1, 1);
		this.add(buttonContainer(), gbc);
		addBackground(gbc, "main");
	}

	public void addButtonEvent(JButton btn) {
		btn.addActionListener(action);
	}

	JPanel buttonContainer() {
		JPanel containerButton = new JPanel();
		containerButton.setLayout(new GridLayout(4, 0, 30, 30));
		String[] names = { "MainMenu.play", "MainMenu.load", //
				"MainMenu.instructions", //
				"MainMenu.score" };

		for (String name : names) {
			DecoratedButton btn = new DecoratedButton(
					AssetsManager.getString(name), ButtonStyle.WhiteStyle,
					UIUtils.DOWN, UIUtils.UP);
			addButtonEvent(btn);
			btn.setActionCommand(name);
			containerButton.add(btn);
		}
		focus = containerButton.getComponent(0);
		focus.requestFocusInWindow();
		containerButton.setPreferredSize(new Dimension(450, 300));
		containerButton.setMinimumSize(new Dimension(450, 300));
		containerButton.setSize(new Dimension(450, 300));
		containerButton.setOpaque(false);
		return containerButton;

	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

	@Override
	public void handleInput() {
	}

	@Override
	public void update(float dt) {
	}

	@Override
	public void onBack() {
		focus.requestFocusInWindow();
	}

}
