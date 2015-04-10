package ui.config;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import ui.Game;
import ui.GameState;
import ui.GameStateManager;

public class InstructionsMenu extends GameState{

	public InstructionsMenu(GameStateManager gsm) {
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
		containerText.setPreferredSize(new Dimension(500, 300));
		containerText.setMinimumSize(new Dimension(500, 300));
		containerText.setSize(new Dimension(500, 300));
	containerText.setLayout(new BorderLayout());;
		String text = "Il s’agit d’un jeu dans lequel \nun personnage (le goinfre) évolue se\n"
				+ " façon controlée par l’utilisateur \net cherche à se nourrir \n"
				+ "de gâteaux qui se déplaçent dans \nl’aire de jeu. Bien entendu de\n "
				+ "méchants nutritionistes sont aussi \nprésents sur l’aire de jeu qui tentent\n "
				+ "d’empêcher par divers moyens, le \ngoinfre de se goinfrer…";
		JTextArea jta = new JTextArea(text, 80,80);
		jta.setFont(new Font("Helvetica", Font.BOLD, 18));
		jta.setForeground(Color.GRAY);
		Insets m = new Insets(10,10,10,10);
				jta.setMargin(m);
		containerText.add(jta, BorderLayout.WEST);
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
