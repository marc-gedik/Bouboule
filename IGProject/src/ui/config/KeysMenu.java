package ui.config;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.Game;
import ui.GameState;
import ui.GameStateManager;
import controler.BackButtonListener;
import controler.FieldListener;

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
		JButton b = new DecoratedButton(Game.getConfig()
				.getString("backButton"), GrayStyle.getInstance());
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

		JPanel upLine = new JPanel();
		JPanel downLine = new JPanel();
		JPanel leftLine = new JPanel();
		JPanel rightLine = new JPanel();
		JPanel actionLine = new JPanel();

		upLine.setBackground(Color.WHITE);
		downLine.setBackground(Color.WHITE);
		leftLine.setBackground(Color.WHITE);
		rightLine.setBackground(Color.WHITE);
		actionLine.setBackground(Color.WHITE);

		JLabel up = new JLabel(Game.getConfig().getString("Keys.Up"));
		JLabel down = new JLabel(Game.getConfig().getString("Keys.Down"));
		JLabel left = new JLabel(Game.getConfig().getString("Keys.Left"));
		JLabel right = new JLabel(Game.getConfig().getString("Keys.Right"));
		JLabel action = new JLabel(Game.getConfig().getString("Keys.Action"));

		JButton forUp = new DecoratedButton("\u2191", BlueStyle.getInstance());
		JButton forDown = new DecoratedButton("\u2193", BlueStyle.getInstance());
		JButton forLeft = new DecoratedButton("\u2190", BlueStyle.getInstance());
		JButton forRight = new DecoratedButton("\u2192",
				BlueStyle.getInstance());
		JButton forAction = new DecoratedButton("Espace",
				BlueStyle.getInstance());

		FieldListener fl = new FieldListener();
		forUp.addActionListener(fl);
		forDown.addActionListener(fl);
		forLeft.addActionListener(fl);
		forRight.addActionListener(fl);
		forAction.addActionListener(fl);

		upLine.add(up);
		upLine.add(forUp);
		downLine.add(down);
		downLine.add(forDown);
		leftLine.add(left);
		leftLine.add(forLeft);
		rightLine.add(right);
		rightLine.add(forRight);
		actionLine.add(action);
		actionLine.add(forAction);

		tmp.add(upLine, gbc);
		gbc.gridy += 10;
		tmp.add(downLine, gbc);
		gbc.gridy += 10;
		tmp.add(leftLine, gbc);
		gbc.gridy += 10;
		tmp.add(rightLine, gbc);
		gbc.gridy += 10;
		tmp.add(actionLine, gbc);

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
	public void update() {

	}

	@Override
	public void render(Graphics g) {

	}
}
