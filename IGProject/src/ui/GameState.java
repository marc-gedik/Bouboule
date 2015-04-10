package ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;

import javax.swing.JPanel;

public abstract class GameState extends JPanel {
	
    protected GameStateManager gsm;

	protected GameState(GameStateManager gsm){
    	this.gsm = gsm;
		this.setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));	

    }
    
    public abstract void handleInput();

    public abstract void update();

	public abstract void render(Graphics g);
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		render(g);
	}
	
	
	protected static void position(GridBagConstraints gbc, int x, int y, int a, int b) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridheight = a;
		gbc.gridwidth = b;
		gbc.gridwidth = GridBagConstraints.REMAINDER; // fin de la ligne
	}
}
