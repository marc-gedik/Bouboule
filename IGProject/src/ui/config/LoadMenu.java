package ui.config;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ui.GameState;
import ui.GameStateManager;
import utils.AssetsManager;
import controler.BackButtonListener;
import controler.LoadMenuListener;

public class LoadMenu extends GameState {

	public LoadMenu(GameStateManager gsm) {
		super(gsm);
	}

	public void init() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		position(gbc, 0, 0, 1, 1);
		this.add(myContainer(), gbc);
		addBackground(gbc, "img/texture3.png");

	}

	JPanel levelContainer() {
		LoadMenuListener l = new LoadMenuListener(gsm);
		JPanel containerLevel = new JPanel();
		containerLevel.setLayout(new GridLayout(3, 5, 0, 15));
		containerLevel.setPreferredSize(new Dimension(480, 240));
		containerLevel.setMinimumSize(new Dimension(480, 240));
		containerLevel.setSize(new Dimension(100, 240));
		JButton[] level = new JButton[15];
		containerLevel.setBackground(Color.WHITE);

		for (int i = 0; i < level.length; i++) {
			if (i < 8)
				level[i] = new ImageButton("img/d2.png", "img/d2_over.png", i+ 1 + "");
			else {
				level[i] = new ImageButton("img/d2.png", "img/d2.png", i + 1+ "");
				level[i].setEnabled(false);
			}
			level[i].addActionListener(l);
			containerLevel.add(level[i]);
		}

		return containerLevel;

	}

	JPanel buttonContainer() {
		JPanel tmp = new JPanel();
		tmp.setBackground(Color.WHITE);
		JButton b = new DecoratedButton(AssetsManager
				.getString("backButton"), ButtonStyle.GrayStyle);
		BackButtonListener bl = new BackButtonListener(gsm);
		b.addActionListener(bl);
		tmp.add(b);
		return tmp;
	}

	JPanel myContainer() {
		JPanel myContainer = new JPanel();
		myContainer.setBorder(new EmptyBorder(15, 15, 15, 15));
		myContainer.setLayout(new BorderLayout());
		myContainer.setBackground(Color.WHITE);
		myContainer.setPreferredSize(new Dimension(600, 400));
		myContainer.setMinimumSize(new Dimension(600, 400));
		myContainer.setSize(new Dimension(600, 400));

		FlowLayout flow = new FlowLayout(FlowLayout.CENTER);
		myContainer.setLayout(new BorderLayout());
		myContainer.add(levelContainer(), BorderLayout.NORTH);
		myContainer.add(buttonContainer(), BorderLayout.SOUTH);

		return myContainer;
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub

	}

}
