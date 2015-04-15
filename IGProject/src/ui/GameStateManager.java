package ui;

import game.Levels;

import java.awt.Graphics;
import java.util.Stack;

import ui.config.InstructionsMenu;
import ui.config.LoadMenu;
import ui.config.MainMenu;
import ui.config.ScoresMenu;
import ui.config.KeysMenu;
import ui.game.LevelRenderer;

public class GameStateManager {

	public static final int GAME = 0;
	public static final int MAIN = 1;
	public static final int LOAD = 2;
	public static final int INSTRUCTIONS = 3;
	public static final int SCORES = 4;

	public static final int KEYS = 5;

	private Game game;
	private Stack<GameState> gameStates;

	public GameStateManager(Game game) {
		
		new Levels("test.png");

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
		case LOAD:
			return new LoadMenu(this);
		case INSTRUCTIONS:
			return new InstructionsMenu(this);
		case SCORES:
			return new ScoresMenu(this);
		case KEYS :
			return new KeysMenu(this);
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
		game.revalidate();
	}

	public void popState() {
		gameStates.pop();
		game.setContentPane(gameStates.peek());
		game.revalidate();
	}

}
