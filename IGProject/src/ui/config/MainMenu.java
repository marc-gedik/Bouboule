package ui.config;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import ui.Game;
import ui.GameState;
import ui.GameStateManager;
import controler.MainMenuFocusListener;
import controler.MainMenuKeyListener;
import controler.MainMenuListener;

public class MainMenu extends GameState {

	private MainMenuListener action;
	private MainMenuKeyListener keyAction;
	private MainMenuFocusListener focusAction;

	public MainMenu(GameStateManager gsm) {
		super(gsm);
		init();
	}

	void init() {
		Background wallpaper = new Background(
				new ImageIcon("img/texture3.png"), Game.WIDTH_SCREEN,
				Game.HEIGHT_SCREEN);
		action = new MainMenuListener(gsm);
		keyAction = new MainMenuKeyListener();
		focusAction = new MainMenuFocusListener();

		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		position(gbc, 0, 0, 1, 1);
		this.add(buttonContainer(), gbc);
		this.add(wallpaper, gbc);
	}

	public void addButtonEvent(JButton btn) {
		btn.addActionListener(action);
		btn.addFocusListener(focusAction);
		btn.addKeyListener(keyAction);

	}

	JPanel buttonContainer() {
		JPanel containerButton = new JPanel();
		containerButton.setLayout(new GridLayout(4, 0, 25, 25));
		DecoratedButton play = new DecoratedButton(Game.getConfig().getString(
				"MainMenu.play"), WhiteStyle.getInstance());
		DecoratedButton load = new DecoratedButton(Game.getConfig().getString(
				"MainMenu.load"), WhiteStyle.getInstance());
		DecoratedButton instructions = new DecoratedButton(Game.getConfig()
				.getString("MainMenu.instructions"), WhiteStyle.getInstance());
		DecoratedButton scores = new DecoratedButton(Game.getConfig()
				.getString("MainMenu.score"), WhiteStyle.getInstance());

		addButtonEvent(play);
		addButtonEvent(load);
		addButtonEvent(instructions);
		addButtonEvent(scores);
		containerButton.add(play);
		containerButton.add(load);
		containerButton.add(instructions);
		containerButton.add(scores);

		containerButton.setPreferredSize(new Dimension(350, 260));
		containerButton.setMinimumSize(new Dimension(350, 260));
		containerButton.setSize(new Dimension(350, 260));
		containerButton.setOpaque(false);
		return containerButton;

	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub

	}

}
