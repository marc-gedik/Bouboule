package game;

import ui.game.LevelRenderer;

public class Cake extends Static {
	private int levelCake;

	public Cake(Body body, int levelCake) {
		super(body);
		this.levelCake = levelCake;
	}

	@Override
	public void draw(LevelRenderer renderer) {
		renderer.drawSpriteCake(this, levelCake);
	}

}
