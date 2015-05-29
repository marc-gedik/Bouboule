package ui;

import java.util.Stack;

import ui.config.GameOver;
import ui.config.InstructionsMenu;
import ui.config.KeysMenu;
import ui.config.LevelTransition;
import ui.config.LoadMenu;
import ui.config.MainMenu;
import ui.config.SaveMenu;
import ui.config.ScoresMenu;
import ui.config.SoundMenu;
import ui.config.Win;
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
	public static final int LEVELTRANSITION = 8;
	public static final int SAVE = 9;
	public static final int WIN = 10;

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
		case LEVELTRANSITION:
			return new LevelTransition(this);
		case SAVE:
			return new SaveMenu(this);
		case WIN:
			return new Win(this);
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
		gameStates.pop().back();
		set(gameStates.peek());
		gameStates.peek().onBack();
	}

	public void set(GameState gameState) {
		game.requestFocusInWindow();
		game.setContentPane(gameState);
		game.revalidate();
		game.getContentPane().requestFocusInWindow();
	}

	public void resize(int width, int height) {
		gameStates.peek().resized(width, height);

	}

	public void pause() {
		if(game.hasFocus())
			gameStates.peek().requestFocusInWindow();
		else
			game.requestFocusInWindow();
	}

}
