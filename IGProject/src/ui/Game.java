package ui;

import java.util.ResourceBundle;

import ui.game.Camera;

public class Game extends MyJFrame {

	private static ResourceBundle config = ResourceBundle.getBundle("config");

	private GameStateManager gsm;
	private Camera camera;
	
	public Game() {
		setTitle(Game.getConfig().getString("Title"));
		camera = new Camera();

		gsm = new GameStateManager(this);
		
		run();
	}

	private void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while (true) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				delta--;
			}
			render();
		}
	}

	public Camera getCamera() {
		return camera;
	}
	
	private void update() {
		gsm.update();
	}

	private void render() {
		gsm.render();
	}

	public static void main(String[] args) {
		new Game();
	}

	public static ResourceBundle getConfig() {
		return config;
	}

}
