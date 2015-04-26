package game;

import ui.game.LevelRenderer;

public abstract class GameObject {

	protected Body body;
	
	public GameObject(Body body) {
		this.body = body;
	}

	public int getX() {
		return body.getX();
	}

	public int getY() {
		return body.getY();
	}

	public abstract void draw(LevelRenderer renderer);

}
