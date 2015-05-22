package ui;

import java.util.Stack;

import ui.config.*;

import ui.config.InstructionsMenu;
import ui.config.KeysMenu;
import ui.config.LoadMenu;
import ui.config.MainMenu;
import ui.config.ScoresMenu;

import ui.game.LevelRenderer;

public class GameStateManager {

	public static final int GAME = 0;
	public static final int MAIN = 1;
	public static final int LOAD = 2;
	public static final int INSTRUCTIONS = 3;
	public static final int SCORES = 4;

	public static final int KEYS = 5;
	public static final int SOUND = 6;
	public static final int GAMEOVER = 7;

	private Game game;
	private Stack<GameState> gameStates;

	public GameStateManager(Game game) {
		this.game = game;
		gameStates = new Stack<GameState>();
		pushState(MAIN);

	}

	public void update(float dt) {
		gameStates.peek().update(dt);
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
		case KEYS:
			return new KeysMenu(this);
		case SOUND:
			return new SoundMenu(this);
		case GAMEOVER:
			return new GameOver(this);
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
		set(gameState);
	}

	public void popState() {
		gameStates.pop();
		set(gameStates.peek());
		gameStates.peek().onBack();
	}

	public void set(GameState gameState) {
		game.requestFocusInWindow();
		game.setContentPane(gameState);
		game.revalidate();
	}

}
