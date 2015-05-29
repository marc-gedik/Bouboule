package ui.config;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.GameState;
import ui.GameStateManager;
import utils.AssetsManager;
import controler.BackButtonListener;
import controler.FieldListener;
import controler.KeysOption;

public class KeysMenu extends GameState {

	public KeysMenu(GameStateManager gsm) {
		super(gsm);
	}

	public void init() {
		this.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		position(gbc, 0, 0, 1, 1);
		this.add(myContainer(), gbc);

		addBackground(gbc, "img/texture3.png");
	}

	JPanel buttonContainer() {
		JPanel tmp = new JPanel();
		tmp.setBackground(Color.WHITE);
		JButton b = new DecoratedButton(AssetsManager.getString("backButton"),
				ButtonStyle.GrayStyle);
		BackButtonListener bl = new BackButtonListener(gsm);
		b.addActionListener(bl);
		tmp.add(b);

		return tmp;

	}

	JPanel changeButtonContainer() {
		JPanel tmp = new JPanel();
		tmp.setBackground(Color.WHITE);
		tmp.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		position(gbc, 0, 0, 1, 1);
		String[] keys = { "Keys.Up", "Keys.Down", "Keys.Left", "Keys.Right",
				"Keys.Action" };
		FieldListener fl = new FieldListener();

		for (String key : keys) {
			JPanel jPanel = new JPanel();
			jPanel.setBackground(Color.WHITE);
			JLabel keyLabel = new JLabel(AssetsManager.getString(key));
			JButton keyButton = new DecoratedButton(KeysOption.toString(AssetsManager.prefInt(key)), ButtonStyle.BlueStyle);
			keyButton.setActionCommand(key);
			keyButton.addActionListener(fl);

			jPanel.add(keyLabel);
			jPanel.add(keyButton);

			tmp.add(jPanel, gbc);
			gbc.gridy += 10;
		}

		return tmp;
	}

	JPanel myContainer() {
		JPanel myContainer = new JPanel();
		myContainer.setLayout(new BorderLayout());
		myContainer.setBackground(Color.WHITE);
		myContainer.setPreferredSize(new Dimension(500, 300));
		myContainer.setMinimumSize(new Dimension(500, 300));
		myContainer.setSize(new Dimension(500, 300));
		myContainer.setLayout(new BorderLayout());
		myContainer.add(buttonContainer(), BorderLayout.SOUTH);
		myContainer.add(changeButtonContainer());
		return myContainer;
	}

	@Override
	public void handleInput() {

	}

	@Override
	public void update(float dt) {

	}

}
