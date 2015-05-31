package ui.config;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.GameStateManager;
import utils.AssetsManager;
import controler.GameOverListener;

public class GameOver extends Menu {

	private ActionListener listener;
	private JButton restart;
	
	public GameOver(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		listener = new GameOverListener(gsm);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		position(gbc, 0, 0, 1, 1);
		this.add(buttonContainer(), gbc);
		addBackground(gbc, "sub");
	}

	private Component buttonContainer() {
        JPanel containerButton = new JPanel();
        containerButton.setLayout(new GridLayout(4, 0 , 30 , 30));


		JLabel title = new JLabel(AssetsManager.getString("GameOver.GameOver"));
		title.setFont(ButtonStyle.DarkStyle.font());
		restart = button("GameOver.Restart");
		JButton menu = button("GameOver.Menu");

		containerButton.add(title);
		containerButton.add(restart);
		containerButton.add(menu);

		restart.requestFocusInWindow();
		containerButton.setPreferredSize(new Dimension(450, 300));
		containerButton.setMinimumSize(new Dimension(450, 300));
		containerButton.setSize(new Dimension(450, 300));
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
	protected JComponent getFirstFocus() {
		return restart;
	}

}
