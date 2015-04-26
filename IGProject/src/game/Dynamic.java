package game;

import ui.game.LevelRenderer;

public abstract class Dynamic extends GameObject {

	protected int idSprite = 0;
	protected double rotation = 0;

	protected int nbSprite = 3; // 4 en partant de 0
	int tmp = 0;

	public Dynamic(Body body) {
		super(body);
	}

	void changeIdSprite() {
		if (tmp == 3) {
			if (idSprite == nbSprite)
				idSprite = 0;
			else
				idSprite++;
			tmp = 0;
		} else
			tmp++;
	}

	void move(int dir, int distance) {
		int x = 0, y = 0;

		if ((dir & Direction.North) == Direction.North)
			y -= distance;
		if ((dir & Direction.South) == Direction.South)
			y += distance;
		if ((dir & Direction.East) == Direction.East)
			x += distance;
		if ((dir & Direction.West) == Direction.West)
			x -= distance;

		if (y < 0) {
			if (x < 0)
				rotation = -45;
			else if (x == 0)
				rotation = 0;
			else if (x > 0)
				rotation = 45;
		} else if (y == 0) {
			if (x < 0)
				rotation = -90;
			else if (x > 0)
				rotation = 90;
		} else if (y > 0) {
			if (x < 0)
				rotation = -135;
			else if (x == 0)
				rotation = 180;
			else if (x > 0)
				rotation = 135;
		}
		body.applyForce(x, y);
	}
}
