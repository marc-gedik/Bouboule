package ui.config;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controler.BackButtonListener;
import ui.Game;
import ui.GameState;
import ui.GameStateManager;

public class LoadMenu  extends GameState {


	public LoadMenu(GameStateManager gsm) {
		super(gsm);
		init();
	}



	void init(){
		Background wallpaper = new Background(new ImageIcon("img/texture3.png"),
				Game.WIDTH_SCREEN, Game.HEIGHT_SCREEN);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		position(gbc, 0, 0, 1, 1);
		this.add(myContainer(), gbc);
		this.add(wallpaper, gbc);
	}	



	JPanel levelContainer(){

		JPanel containerLevel = new JPanel();
		containerLevel.setLayout(new GridLayout(3,5));
		containerLevel.setPreferredSize(new Dimension(480, 240));
		containerLevel.setMinimumSize(new Dimension(480, 240));
		containerLevel.setSize(new Dimension(100, 240));
		JButton[] level= new JButton[15];
		containerLevel.setBackground(Color.WHITE);

		for (int i = 0; i < level.length; i++) {
			if(i<8)
			level[i]= new ImageButton("img/d2.png", "img/d2_over.png", i+1+"");
			else{
			level[i]= new ImageButton("img/d2.png", "img/d2.png", i+1+"");
			level[i].setEnabled(false);
			}
			containerLevel.add(level[i]);
		}
		


		return containerLevel;


	}
	
	
	JPanel buttonContainer(){
		JPanel tmp = new JPanel();
		tmp.setBackground(Color.WHITE);		
		JButton b = new DecoratedButton(Game.getConfig().getString("backButton"), GrayStyle.getInstance());
		BackButtonListener bl = new BackButtonListener(gsm);
		b.addActionListener(bl);
		tmp.add(b);		
		return tmp;
	}

	JPanel myContainer(){
		JPanel myContainer = new JPanel();
		myContainer.setBorder( new EmptyBorder(10, 10, 10, 10));
		myContainer.setLayout(new BorderLayout());
		myContainer.setBackground(Color.WHITE);		
		myContainer.setPreferredSize(new Dimension(500, 300));
		myContainer.setMinimumSize(new Dimension(500, 300));
		myContainer.setSize(new Dimension(500, 300));
		
		FlowLayout flow = new FlowLayout(FlowLayout.CENTER);  
	    myContainer.setLayout(flow); 
		myContainer.add(levelContainer());	
		myContainer.add(buttonContainer());	



		return myContainer;	
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
