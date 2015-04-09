package ui;

import java.awt.Graphics;
import java.util.Stack;

import ui.config.MainMenu;
import ui.game.LevelRenderer;

public class GameStateManager {

	public static final int GAME = 0;
	public static final int MAIN = 1;

	private Game game;

	private Stack<GameState> gameStates;

	public GameStateManager(Game game) {
		this.game = game;
		gameStates = new Stack<GameState>();
		pushState(MAIN);
	}

	public void update() {
		gameStates.peek().update();
	}

	public void render(Graphics g) {
		gameStates.peek().repaint();
	}

	public Game game() {
		return game;
	}

	private GameState getState(int state) {
		switch (state) {
		case GAME:
			return new LevelRenderer(this);
		case MAIN:
			return new MainMenu(this);
		}
		return null;
	}

	public void setState(int state) {
		popState();
		pushState(state);
	}

	public void pushState(int state) {
		GameState gameState = getState(state);
		gameStates.push(gameState);
		game.setContentPane(gameState);
		game.repaint();
	}

	public void popState() {
		GameState g = gameStates.pop();
	}

}
