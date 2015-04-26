package game;

public abstract class Dynamic extends GameObject {


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

		body.applyForce(x, y);
	}

}
