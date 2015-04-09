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

import controler.MainMenuListener;
import ui.GameState;
import ui.GameStateManager;


public class MainMenu extends GameState {

	JButton play;
	JButton load;
	DecoratedButton currentFocus;
	MainMenuListener action;
	
	public MainMenu(GameStateManager gsm) {
		super(gsm);
		this.setPreferredSize(new Dimension(600,400));	

		init();		
	}

	FocusListener l = new FocusListener() {
		
		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void focusGained(FocusEvent e) {
			currentFocus= (DecoratedButton)e.getSource();
			if(currentFocus==play){
				System.out.println("lancer play");
			}
		}
	};


	void init(){
	addKeyListener(new  KeyListener() {
		
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
				System.out.println("ok");
		}
	});
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		Background wallpaper = new Background(new ImageIcon("img/texture3.png"),2048,2048);
		action = new MainMenuListener(gsm);
		JPanel myContainer;
		myContainer = buttonContainer();		
		position(gbc, 0, 0, 1, 1);
		this.add(myContainer, gbc);
		this.add(wallpaper, gbc);
	}	



	JPanel buttonContainer(){
		JPanel containerButton = new JPanel();
		containerButton.setLayout(new GridLayout(4,0,25,25));
		play = new DecoratedButton("MainMenu.play");	
		load = new DecoratedButton("MainMenu.load");
		JButton	instructions = new DecoratedButton("MainMenu.instructions");
		JButton	scores = new DecoratedButton("MainMenu.score");
		
		play.addActionListener(action);
		play.addFocusListener(l);
		
		
		load.addActionListener(action);
		load.addFocusListener(l);

		instructions.addActionListener(action);
		scores.addActionListener(action);
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


	public static void position(GridBagConstraints gbc, int x, int y, int a,
			int b) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridheight = a;
		gbc.gridwidth = b;
		gbc.gridwidth = GridBagConstraints.REMAINDER; // fin de la ligne
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
