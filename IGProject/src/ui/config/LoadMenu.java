package ui.config;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

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
		this.add(textContainer(), gbc);
		this.add(wallpaper, gbc);
	}	
	
	
	
	JPanel textContainer(){
		JPanel 	containerText = new JPanel();
		containerText.setBackground(Color.WHITE);		
		containerText.setPreferredSize(new Dimension(350, 260));
		containerText.setMinimumSize(new Dimension(350, 260));
		containerText.setSize(new Dimension(350, 260));
	
		
		return containerText;
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
