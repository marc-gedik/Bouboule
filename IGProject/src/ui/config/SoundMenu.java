package ui.config;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import ui.GameState;
import ui.GameStateManager;
import utils.AssetsManager;
import controler.BackButtonListener;

public class SoundMenu extends GameState {

	public SoundMenu(GameStateManager gsm) {
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
		JButton b = new DecoratedButton(AssetsManager
				.getString("backButton"), GrayStyle.getInstance());
		BackButtonListener bl = new BackButtonListener(gsm);
		b.addActionListener(bl);
		tmp.add(b);

		return tmp;

	}

	JPanel slideContainer() {
		JPanel tmp = new JPanel();
		tmp.setBackground(Color.WHITE);
		tmp.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		position(gbc, 0, 0, 1, 1);

		JLabel bgm = new JLabel(AssetsManager.getString("Sound.Bgm"));
		JLabel volume = new JLabel(AssetsManager.getString("Sound.Music"));

		JSlider forBgm = new JSlider(0, 10);
		JSlider forVolume = new JSlider(0, 10);

		tmp.add(bgm);
		tmp.add(forBgm);
		gbc.gridy += 10;
		tmp.add(volume);
		tmp.add(forVolume);

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
		myContainer.add(slideContainer());
		return myContainer;
	}

	@Override
	public void handleInput() {

	}

	@Override
	public void update(float dt) {

	}

}
