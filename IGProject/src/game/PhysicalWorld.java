package game;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PhysicalWorld {

	public final static int PPM = 32;

	private int width, height;
	
	private Set<Body>[][] bodies;
	private List<Body> dynamics;

	public PhysicalWorld(int width, int height) {
		this.width = width;
		this.height = height;
		dynamics = new LinkedList<Body>();
		bodies = new Set[width][height];
		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++)
				bodies[i][j] = new HashSet<Body>();
	}

	public void addBody(Body body) {
		bodies[body.getX() / PPM][body.getY() / PPM].add(body);
		if (body.type == BodyType.DYNAMIC)
			dynamics.add(body);
	}

	public void update() {
		for (Body body : dynamics) {
			int x = body.getX() / PPM;
			int y = body.getY() / PPM;
			for (int i = -1; i < 2; i++)
				for (int j = -1; j < 2; j++)
					if (x + i >= 0 && y + j >= 0 && x + i < width && y + j < height
					&& bodies[x + i][y + j].size() >= 1)
						for (Body bodyB : bodies[x + i][y + j]){
							System.out.println("Collid");
							body.collision(bodyB);
						}
			bodies[body.getLastX() / PPM][body.getLastY() / PPM].remove(body);
			bodies[x][y].add(body);
		}
	}
}

enum BodyType {
	STATIC, DYNAMIC
}