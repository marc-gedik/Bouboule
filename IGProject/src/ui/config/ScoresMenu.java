package ui.config;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import ui.GameStateManager;
import ui.Score;
import utils.AssetsManager;
import controler.BackButtonListener;

public class ScoresMenu extends Menu {

	public static final int NB = 8;
	private DecoratedButton b;

	public ScoresMenu(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		position(gbc, 0, 0, 1, 1);
		this.add(myContainer(), gbc);
		addBackground(gbc, "sub");

	}

	JPanel buttonContainer() {
		JPanel containerButton = new JPanel();
		containerButton.setBackground(Color.WHITE);
		b = new DecoratedButton(AssetsManager
				.getString("backButton"), ButtonStyle.GrayStyle);
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

		containerTable.setLayout(new GridLayout(0, 3, 0, 10));
		Font f_title = new Font("Helvetica", Font.BOLD, 18);
		Border bottom = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY);

		JLabel row1 = new JLabel(AssetsManager.getString("ScoresMenu.rank"));
		JLabel row2 = new JLabel(AssetsManager.getString("ScoresMenu.name"));
		JLabel row3 = new JLabel(AssetsManager.getString("ScoresMenu.score"));

		row1.setBorder(bottom);
		row2.setBorder(bottom);
		row3.setBorder(bottom);

		row1.setFont(f_title);
		row2.setFont(f_title);
		row3.setFont(f_title);

		containerTable.add(row1);
		containerTable.add(row2);
		containerTable.add(row3);
		int ranking = 1;
		List<Score> items = AssetsManager.getScores();
		for(Score score : items){
			containerTable.add(new JLabel("" + ranking++));
			containerTable.add(new JLabel(score.name));
			containerTable.add(new JLabel(String.valueOf(score.score)));
		}
		return containerTable;
	}

	JPanel myContainer() {
		JPanel myContainer = new JPanel();
		myContainer.setBorder(new EmptyBorder(20, 30, 10, 30));
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
	public void update(float dt) {
	}

	@Override
	protected JComponent getFirstFocus() {
		return b;
	}

}
