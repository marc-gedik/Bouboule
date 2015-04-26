package game;

import ui.game.LevelRenderer;

public class Character extends Dynamic {

	public Character(Body body) {
		super(body);
	}

	@Override
	public void draw(LevelRenderer renderer) {
		renderer.drawCharacter(this);
	}

}
