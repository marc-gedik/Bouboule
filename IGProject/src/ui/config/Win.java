package ui.config;

import game.Conductor;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ui.GameStateManager;
import ui.Score;
import utils.AssetsManager;
import controler.WinListener;

public class Win extends Menu {

	private ActionListener listener;
	private JTextField name;

	public Win(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {

		listener = new WinListener(gsm);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		position(gbc, 0, 0, 1, 1);
		this.add(buttonContainer(), gbc);
		addBackground(gbc, "sub");

	}

	private Component buttonContainer() {
		JPanel containerButton = new JPanel();
		containerButton.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		JLabel title = new JLabel(AssetsManager.getString("Win.Victory"));
		JLabel nameLabel = new JLabel(AssetsManager.getString("Win.Name"));
		name = new JTextField(10);
		JLabel scoreLabel = new JLabel(AssetsManager.getString("Win.Score"));

		JButton next = button("Win.Menu");

		gbc.insets = new Insets(20, 20, 20, 20);
		gbc.gridwidth = 2;
		gbc.gridy = 1;
		gbc.gridx = 1;
		gbc.weightx = 0.5;

		title.setFont(ButtonStyle.DarkStyle.font());
		containerButton.add(title, gbc);

		gbc.gridwidth = 1;
		gbc.gridy = 2;
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.EAST;

		nameLabel.setFont(ButtonStyle.DarkStyle.font);
		containerButton.add(nameLabel, gbc);

		gbc.gridx = 2;
		gbc.anchor = GridBagConstraints.WEST;

		name.setFont(ButtonStyle.DarkStyle.font);
		name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					next.doClick();
			}

		});
		containerButton.add(name, gbc);

		gbc.gridy = 3;
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.EAST;

		scoreLabel.setFont(ButtonStyle.DarkStyle.font);
		containerButton.add(scoreLabel, gbc);

		gbc.gridx = 2;
		gbc.anchor = GridBagConstraints.WEST;
		JLabel score = new JLabel(Conductor.getScore() + "");
		score.setFont(ButtonStyle.DarkStyle.font);
		containerButton.add(score, gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 2;
		gbc.gridy = 4;
		gbc.gridx = 1;
		containerButton.add(next, gbc);

		containerButton.setOpaque(false);
		return containerButton;
	}

	private JButton button(String string) {
		JButton button = new DecoratedButton(AssetsManager.getString(string),
				ButtonStyle.WhiteStyle);
		button.addActionListener(listener);
		button.setActionCommand(string);
		return button;
	}

	@Override
	public void handleInput() {

	}

	@Override
	public void update(float dt) {
	}

	@Override
	public void back() {
		super.back();
		AssetsManager.addScore(new Score(name.getText(), Conductor.getScore()));
	}

	@Override
	protected JComponent getFirstFocus() {
		return name;
	}
}
