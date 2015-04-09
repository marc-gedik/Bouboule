package ui.game;

import game.Level;

import java.awt.Graphics;
import java.awt.Graphics2D;

import controler.GameControler;
import ui.GameState;
import ui.GameStateManager;

public class LevelRenderer extends GameState {

	private Level level;

	public LevelRenderer(GameStateManager gsm) {
		super(gsm);
		level = new Level();
	}
	
	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.draw(level.getCharacter().getBounds());
	}

	@Override
	public void update() {
		handleInput();
		level.update();
	}

	@Override
	public void handleInput() {
		
	}
	
}
