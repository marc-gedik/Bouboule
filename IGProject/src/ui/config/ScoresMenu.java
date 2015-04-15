package ui.config;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import ui.GameState;
import ui.GameStateManager;

public class ScoresMenu extends GameState {

	public ScoresMenu(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		Background wallpaper = new Background(new ImageIcon("img/texture3.png"));
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		position(gbc, 0, 0, 1, 1);
		this.add(textContainer(), gbc);
		gbc.weightx = gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		this.add(wallpaper, gbc);
	}

	JPanel textContainer() {
		JPanel containerText = new JPanel();
		containerText.setBackground(Color.WHITE);
		containerText.setPreferredSize(new Dimension(350, 260));
		containerText.setMinimumSize(new Dimension(350, 260));
		containerText.setSize(new Dimension(350, 260));

		return containerText;
	}

	@Override
	public void handleInput() {
	}

	@Override
	public void update() {
	}

	@Override
	public void render(Graphics g) {
	}

}
