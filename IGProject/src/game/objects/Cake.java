package game.objects;

import game.physics.Body;
import ui.game.LevelRenderer;

public class Cake extends Static {
	private int levelCake;

	public Cake(Body body, int levelCake) {
		super(body);
		this.levelCake = levelCake;
	}

}
