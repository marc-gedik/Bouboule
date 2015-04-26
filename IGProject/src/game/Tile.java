package game;

import ui.game.LevelRenderer;

public class Tile extends Static {

	public Tile(Body body) {
		super(body);
	}

	@Override
	public void draw(LevelRenderer renderer) {
		renderer.drawSpriteTile(this);
	}


}
