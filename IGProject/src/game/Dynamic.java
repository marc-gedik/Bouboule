package game;


public abstract class Dynamic extends GameObject {

	protected int idSprite = 0;

	int tmp = 0;

	public Dynamic(Body body) {
		super(body);
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
				angle = -45;
			else if (x == 0)
				angle = 0;
			else if (x > 0)
				angle = 45;
		} else if (y == 0) {
			if (x < 0)
				angle = -90;
			else if (x > 0)
				angle = 90;
		} else if (y > 0) {
			if (x < 0)
				angle = -135;
			else if (x == 0)
				angle = 180;
			else if (x > 0)
				angle = 135;
		}
		body.applyForce(x, y);
	}
}
