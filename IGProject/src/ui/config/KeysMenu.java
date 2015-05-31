package ui.config;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ui.GameStateManager;
import utils.AssetsManager;
import utils.UIUtils;
import controler.BackButtonListener;
import controler.FieldListener;
import controler.KeysOption;

public class KeysMenu extends Menu {

	private JComponent focus;

	public KeysMenu(GameStateManager gsm) {
		super(gsm);
	}

	public void init() {
		this.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		position(gbc, 0, 0, 1, 1);
		this.add(myContainer(), gbc);

		addBackground(gbc, "sub");
	}

	JPanel buttonContainer() {
		JPanel tmp = new JPanel();
		tmp.setBackground(Color.WHITE);
		JButton b = new DecoratedButton(AssetsManager.getString("backButton"),
				ButtonStyle.GrayStyle, UIUtils.DOWN, UIUtils.UP);
		BackButtonListener bl = new BackButtonListener(gsm);
		b.addActionListener(bl);
		tmp.add(b);

		return tmp;

	}

	JPanel changeButtonContainer() {
		JPanel tmp = new JPanel();
		tmp.setBackground(Color.WHITE);
		tmp.setBorder(new EmptyBorder(20, 100, 0, 100));
		tmp.setLayout(new GridLayout(0, 2, 30, 10));
		String[] keys = { "Keys.Up", "Keys.Down", "Keys.Left", "Keys.Right",
				"Keys.Action" };
		FieldListener fl = new FieldListener();

		for (String key : keys) {
			JLabel keyLabel = new JLabel(AssetsManager.getString(key), JLabel.CENTER);
			keyLabel.setFont(new Font("Helvetica", Font.BOLD, 16));
			JButton keyButton = new DecoratedButton(KeysOption.toString(AssetsManager.prefInt(key)), ButtonStyle.BlueStyle, UIUtils.DOWN, UIUtils.UP);
			keyButton.setActionCommand(key);
			keyButton.addActionListener(fl);

			tmp.add(keyLabel);
			tmp.add(keyButton);
		}

		focus = (JComponent) tmp.getComponent(1);
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
		myContainer.add(changeButtonContainer(), BorderLayout.CENTER);
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
		return focus;
	}

}
