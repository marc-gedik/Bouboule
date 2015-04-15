package ui;

import java.awt.Graphics;
import java.awt.GridBagConstraints;

import javax.swing.JPanel;

import ui.game.Camera;

public abstract class GameState extends JPanel {
	
    protected GameStateManager gsm;
    protected Game game;
    
    protected Camera camera;
    
	protected GameState(GameStateManager gsm){
    	this.gsm = gsm;
    	this.game = gsm.game();
    	this.camera = game.getCamera();
    	init();
    }
    
    public abstract void handleInput();

    public abstract void update();

	public abstract void render(Graphics g);
	
	public abstract void init();
	
	protected static void position(GridBagConstraints gbc, int x, int y, int a, int b) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridheight = a;
		gbc.gridwidth = b;
		gbc.gridwidth = GridBagConstraints.REMAINDER; // fin de la ligne
	}

	
}
