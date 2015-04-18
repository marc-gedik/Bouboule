package ui.config;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import ui.Game;
import ui.GameState;
import ui.GameStateManager;
import controler.BackButtonListener;

public class ScoresMenu extends GameState {

	public static String[] rank = new String[10];

	// initialisation temporaire

	void initTab() {
		for (int i = 0; i < rank.length; i++) {
			rank[i] = "Marco " + (int) (Math.random() * 5000);
		}
		afficheTab();

	}

	void afficheTab() {
		for (int i = 0; i < rank.length; i++) {
			System.out.println(rank[i]);
		}
	}

	public ScoresMenu(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		initTab();

		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		position(gbc, 0, 0, 1, 1);
		this.add(myContainer(), gbc);
		addBackground(gbc, "img/texture3.png");

	}

	JPanel buttonContainer() {
		JPanel containerButton = new JPanel();
		containerButton.setBackground(Color.WHITE);
		JButton b = new DecoratedButton(Game.getConfig()
				.getString("backButton"), GrayStyle.getInstance());
		BackButtonListener bl = new BackButtonListener(gsm);
		b.addActionListener(bl);
		containerButton.add(b);

		return containerButton;

	}

	void tableStyle(JPanel containerText) {

	}

	JPanel tableContainer() {
		JPanel containerTable = new JPanel();
		containerTable.setBackground(Color.WHITE);

		containerTable.setLayout(new GridLayout(11, 3, 0, 10));
		Font f_cell = new Font("Helvetica", 0, 14);
		Font f_title = new Font("Helvetica", Font.BOLD, 18);
		Border bottom = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY);

		JLabel row1 = new JLabel(Game.getConfig().getString("ScoresMenu.rank"));
		JLabel row2 = new JLabel(Game.getConfig().getString("ScoresMenu.name"));
		JLabel row3 = new JLabel(Game.getConfig().getString("ScoresMenu.score"));

		row1.setBorder(bottom);
		row2.setBorder(bottom);
		row3.setBorder(bottom);

		row1.setFont(f_title);
		row2.setFont(f_title);
		row3.setFont(f_title);

		containerTable.add(row1);
		containerTable.add(row2);
		containerTable.add(row3);
		int ranking;
		String items[];
		for (int i = 0; i < rank.length; i++) {
			ranking = i + 1;
			items = rank[i].split(" ");
			containerTable.add(new JLabel("" + ranking));
			containerTable.add(new JLabel(items[0]));
			containerTable.add(new JLabel(items[1]));

		}
		return containerTable;

	}

	JPanel myContainer() {
		JPanel myContainer = new JPanel();
		myContainer.setBorder( new EmptyBorder(20, 30, 10, 30));
		myContainer.setLayout(new BorderLayout());
		myContainer.setBackground(Color.WHITE);
		myContainer.setPreferredSize(new Dimension(600, 400));
		myContainer.setMinimumSize(new Dimension(600, 400));
		myContainer.setSize(new Dimension(600, 400));
		myContainer.setLayout(new BorderLayout());
		myContainer.add(buttonContainer(), BorderLayout.SOUTH);
		myContainer.add(tableContainer(), BorderLayout.NORTH);

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
