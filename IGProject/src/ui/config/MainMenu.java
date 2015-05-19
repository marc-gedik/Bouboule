package ui.config;

import java.awt.AWTKeyStroke;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import ui.GameState;
import ui.GameStateManager;
import controler.MainMenuFocusListener;
import controler.MainMenuKeyListener;
import controler.MainMenuListener;
import utils.AssetsManager;

public class MainMenu extends GameState {

	private MainMenuListener action;
	private MainMenuKeyListener keyAction;
	private MainMenuFocusListener focusAction;

	public MainMenu(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		action = new MainMenuListener(gsm);
		keyAction = new MainMenuKeyListener();
		focusAction = new MainMenuFocusListener();

		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		position(gbc, 0, 0, 1, 1);
		this.add(buttonContainer(), gbc);
		addBackground(gbc, "img/texture3.png");
	}

	public void addButtonEvent(JButton btn) {
		btn.addActionListener(action);
		btn.addFocusListener(focusAction);
		btn.addKeyListener(keyAction);

	}

	JPanel buttonContainer() {
		JPanel containerButton = new JPanel();
		Set<AWTKeyStroke> downKeys = new HashSet<AWTKeyStroke>(), upKeys = new HashSet<AWTKeyStroke>();
		downKeys.add(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0));
		upKeys.add(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0));

		containerButton.setLayout(new GridLayout(4, 0, 30, 30));
		String[] names = { "MainMenu.play", "MainMenu.load", //
				"MainMenu.instructions", //
				"MainMenu.score" };

		for (String name : names) {
			DecoratedButton btn = new DecoratedButton(AssetsManager
					.getString(name), ButtonStyle.WhiteStyle, downKeys, upKeys);
			addButtonEvent(btn);
			btn.setActionCommand(name);
			containerButton.add(btn);
		}
		containerButton.getComponent(0).requestFocusInWindow();
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


}
