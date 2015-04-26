package game;

import ui.game.LevelRenderer;

public class Cake extends Static {

	public Cake(Body body) {
		super(body);
	}
	
	@Override
	public void draw(LevelRenderer renderer) {
		renderer.drawCake(this);
	}

}
