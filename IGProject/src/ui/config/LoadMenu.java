package ui.config;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.prefs.Preferences;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ui.GameState;
import ui.GameStateManager;
import utils.AssetsManager;
import controler.BackButtonListener;
import controler.LoadMenuListener;

public class LoadMenu extends GameState {	
	
	
	private static Preferences pref = Preferences.userNodeForPackage(LoadMenu.class);

	private static String[] save = new String[]{
		getPref().get("save0", ""), 
		getPref().get("save1", ""), 
		getPref().get("save2", ""), 
		getPref().get("save3", ""), 
		getPref().get("save4", ""), 
		getPref().get("save5", ""), 
		getPref().get("save6", ""), 
		getPref().get("save7", ""), 
		getPref().get("save8", ""), 
		getPref().get("save9", ""), 
		getPref().get("save10", ""), 
		getPref().get("save11", ""), 
		getPref().get("save12", ""), 
		getPref().get("save13", ""), 
		getPref().get("save14", ""), 
	};

	
	
	
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
		LoadMenuListener l = new LoadMenuListener(gsm, getSave());
		JPanel containerLevel = new JPanel();
		containerLevel.setLayout(new GridLayout(3, 5, 0, 15));
		containerLevel.setPreferredSize(new Dimension(480, 240));
		containerLevel.setMinimumSize(new Dimension(480, 240));
		containerLevel.setSize(new Dimension(100, 240));
		JButton[] level = new JButton[15];
		containerLevel.setBackground(Color.WHITE);

		for (int i = 0; i < level.length; i++) {
			if (getSave()[i].equals("")){
				level[i] = new ImageButton("img/d2.png", "img/d2_over.png", i+ 1 + "");
				level[i].setEnabled(false);
			}
			else {
				level[i] = new ImageButton("img/d2.png", "img/d2_over.png", i+ 1 + "");
				
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

		myContainer.setLayout(new BorderLayout());
		myContainer.add(levelContainer(), BorderLayout.NORTH);
		myContainer.add(buttonContainer(), BorderLayout.SOUTH);

		return myContainer;
	}

	@Override
	public void handleInput() {
	}

	@Override
	public void update(float dt) {
	}

	public static Preferences getPref() {
		return pref;
	}

	public static void setPref(Preferences pref) {
		LoadMenu.pref = pref;
	}

	public static String[] getSave() {
		return save;
	}

	public static void setSave(String[] save) {
		LoadMenu.save = save;
	}

}
