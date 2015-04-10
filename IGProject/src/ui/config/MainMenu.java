package ui.config;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ResourceBundle;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.ChangeListener;

import controler.MainMenuFocusListener;
import controler.MainMenuKeyListener;
import controler.MainMenuListener;
import ui.GameState;
import ui.GameStateManager;


public class MainMenu extends GameState {

	public static JButton play;
	public static JButton load;
	public static JButton instructions;
	public static JButton scores;

	MainMenuListener action;
	MainMenuKeyListener keyAction;
	MainMenuFocusListener focusAction;

	public MainMenu(GameStateManager gsm) {
		super(gsm);
		this.setPreferredSize(new Dimension(600,400));	
		init();		
	}



	void init(){
		Background wallpaper = new Background(new ImageIcon("img/texture3.png"),
				GameStateManager.WIDTH_SCREEN, GameStateManager.HEIGHT_SCREEN);
		action = new MainMenuListener(gsm);
		keyAction = new MainMenuKeyListener(gsm);
		focusAction	 = new MainMenuFocusListener();

		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		position(gbc, 0, 0, 1, 1);
		this.add(buttonContainer(), gbc);
		this.add(wallpaper, gbc);
	}	


	
	
	public void addButtonEvent(JButton btn){
		btn.addActionListener(action);
		btn.addFocusListener(focusAction);
		btn.addKeyListener(keyAction);

	}

	JPanel buttonContainer(){
		JPanel containerButton = new JPanel();
		containerButton.setLayout(new GridLayout(4,0,25,25));
		play = new DecoratedButton("MainMenu.play");	
		load = new DecoratedButton("MainMenu.load");
		instructions = new DecoratedButton("MainMenu.instructions");
		scores = new DecoratedButton("MainMenu.score");

		addButtonEvent(play);
		addButtonEvent(load);
		addButtonEvent(instructions);
		addButtonEvent(scores);
		containerButton.add(play);
		containerButton.add(load);
		containerButton.add(instructions);
		containerButton.add(scores);

		containerButton.setPreferredSize(new Dimension(350, 260));
		containerButton.setMinimumSize(new Dimension(350, 260));
		containerButton.setSize(new Dimension(350, 260));
		containerButton.setOpaque(false);
		return containerButton;

	}





	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
